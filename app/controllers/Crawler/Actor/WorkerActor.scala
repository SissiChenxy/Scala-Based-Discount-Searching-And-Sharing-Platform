package controllers.Crawler.Actor

import java.io.{File, FileWriter}
import java.nio.file.{Files, Paths}
import java.util
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import java.util.logging.Level

import controllers.Crawler.Message.{DetailInformation, FinishMainPageCrawler, ParseMainPage}
import akka.actor.Actor
import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.{BrowserVersion, WebClient}
import org.apache.commons.logging.LogFactory
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

class WorkerActor extends Actor {

  private val allDiscoutedProductMap = new util.HashMap[String, String]()

  def receive = {

    case parseMainPage: ParseMainPage => {
      sender ! "Parse Main Page task received!"
      val url = parseMainPage.url
      requestGetUrl(url, new ConcurrentHashMap[String, String](), "MAIN", parseMainPage.category)
    }
    case parseDetailInformation: DetailInformation => {
      sender ! "Parse Detail Page task received!"
      val url = parseDetailInformation.url
      requestGetUrl(url, new ConcurrentHashMap[String, String](), "DETAIL", parseDetailInformation.category)
    }
  }

  //recursively retry automatically, retry 100 times, interval is 10 seconds, discountsMap save the crawler data
  def requestGetUrl(url: String, discountsMap: ConcurrentHashMap[String, String], docType: String, category: String): Unit = {
    Try(Jsoup.connect(url).header("Accept-Encoding", "gzip, deflate")
      .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
      .maxBodySize(0)
      .timeout(50000)
      .get()
    ) match { //use Try to determine whether succeed or fail
      case Failure(exception) =>
          println(exception.getMessage)
          context.stop(self)

      case Success(doc: Document) => {
        if (docType.equals("MAIN")) parseMainPageDoc(doc, category)
        else {
          parseDetailInformation(doc, category, discountsMap)
        }
      }
    }
  }


  //analyze single category and filter the Analytical and Evaluation articles
  def parseMainPageDoc(doc: Document, category: String) = {
    var urls = List[String]()
    for (element <- doc.select("div.mlist")) {

      if (!element.select("span.more.from-web > a").html().contains("Dealmoon.com")) { //only save target data
        val url = element.select("div.img_wrap > a").attr("href")
        urls = url :: urls
      }
    }
    sender ! urls
    sender ! FinishMainPageCrawler(urls, category)
  }

  //analyze single category and filter the Analytical and Evaluation articles
  def parseDetailInformation(doc: Document, category: String, discountsMap: ConcurrentHashMap[String, String]) = {
    val url = doc.select("a.last-bc").attr("href")
    val merchant = doc.select("div.cz_date > a").text().replace(",", " ").replace("切换到中文 Report Error ", "")
    val favorite = doc.select("span.j-stat-count-fav > em.j-count").text()
    val share = doc.select("span.j-stat-count-share > em.j-count").text()
    val comments = doc.select("span.j-stat-count-comment > em.j-count").text()
    val discount = doc.select("span.notice_item").text()
    for (element <- doc.select("div.dpc_box")) {
      val title = element.select("div.deal_text").text().replace("&nbsp", " ").replace(",", "")
      discountsMap.put(title, url + "," //url
        + discount + "," //discount, if expired shows here
        + merchant + "," //merchant
        //+ element.select("div.tw_pic > img").attr("src") + ","
        + title + "," //title
        + element.select("p.tw_text").text().split(" ").head + "," //discounted price
        + element.select("p.tw_text > i").text() + "," //original price
        + category + ","
        + favorite + ","
        + share + ","
        + comments
        //+ element.select("div.pubtime").text() + "," //postTime
        //+ element.select(s"em.shareNums-$id").html()    //shares
      )
    }
    sender ! discountsMap
    saveFile(category, discountsMap)
  }

  //output in file
  def saveFile(category: String, discountsMap: ConcurrentHashMap[String, String]) = synchronized {
    println("Save Discount Map: " + discountsMap.size())
    val csvFile = new File("Discounted_Product_Information.csv")
    var writer: FileWriter = null
    if (!csvFile.exists()) {
      writer = new FileWriter(csvFile, true)
      writer.write("URL,Discount,Platform,Title,DiscountedPrice,OriginalPrice,Category,Favorites,Shares,Comments" + "\n")
    } else {
      writer = new FileWriter(csvFile, true)
    }

    for ((_, value) <- discountsMap) {
      writer.write(value + "\n")
    }
    writer.close()
    sender ! "csv file saved"
  }

}
