package controllers.Crawler.Actor

import java.net.URLEncoder

import controllers.Crawler.Message.{CrawlerStart, DetailInformation, FinishMainPageCrawler, ParseMainPage}
import akka.actor.{Actor, ActorRef, Props}
import controllers.HomeController

import scala.collection.mutable
import util.control.Breaks._


class MasterActor extends Actor {
  private var num = 0
  private[this] var _children: mutable.Buffer[ActorRef] = collection.mutable.Buffer[ActorRef]()

  def children: mutable.Buffer[ActorRef] = _children

  def children_=(value: mutable.Buffer[ActorRef]): Unit = {
    _children = value
  }

  override def receive = {

    case crawlerStart: CrawlerStart => {
      sender ! "Crawler Started!"
      for (i <- 1 to crawlerStart.maxpage) {
        var url = crawlerStart.url
        url = url.format(URLEncoder.encode(crawlerStart.category, "UTF-8"))
        url += i
        //println(url)
        val actor = context.actorOf(Props[WorkerActor], "child" + num)
        children += actor
        actor ! ParseMainPage(url,crawlerStart.category)
        num += 1
      }
      sender ! num
    }

    case finishMainPageCrawler: FinishMainPageCrawler => {
      sender ! "Assign Detail Page Crawler Task!"
      var urlList: List[String] = finishMainPageCrawler.urls
      //println(urlList)
      while (urlList.nonEmpty) {
        breakable {
          for (i <- 0 to children.length) {
            if (urlList.isEmpty) break
            val detailUrl = urlList.head
            children(i) ! DetailInformation(detailUrl,finishMainPageCrawler.category)
            sender ! "Finished"
            urlList = urlList.drop(1)
          }
        }
      }
    }

  }
}