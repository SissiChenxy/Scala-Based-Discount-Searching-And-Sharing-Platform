package controllers.Crawler

import controllers.Crawler.Actor.MasterActor
import controllers.Crawler.Message.CrawlerStart
import akka.actor.{ActorSystem, Props}

import scala.concurrent.duration._

//url pattern, all the categories to crawler
object DealmoonScrawler {

  val categoryMap = Map(
    "Clothing-Jewelry-Bags" -> 80, //tag，页数
    "Beauty" -> 80,
    "Electronics-Computers" -> 88,
    "At-Home" -> 94,
    "Baby-Kids" -> 66,
    "Sports-Outdoors" -> 19
  )
  val url = "https://www.dealmoon.com/%s/"

  def main(args: Array[String]): Unit = {
   start()
  }

  def start(): Unit = {
    val system = ActorSystem("DealmoonSystem")
    val masterActor = system.actorOf(Props[MasterActor], "master")
    implicit val ec = system.dispatcher
    //crawler start
    for ((category, page) <- categoryMap) {
      println(category + "  | " + page)
      masterActor ! CrawlerStart(url, category, page)
      //system.scheduler.schedule(0.seconds,300000.millis, masterActor, CrawlerStart(url, category, page))
    }

  }
}
