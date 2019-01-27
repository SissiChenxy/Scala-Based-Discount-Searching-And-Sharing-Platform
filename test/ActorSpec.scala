import java.util.concurrent.ConcurrentHashMap

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import controllers.Crawler.Actor.{MasterActor, WorkerActor}
import scala.concurrent.duration._
import controllers.Crawler.Message.{CrawlerStart, DetailInformation, FinishMainPageCrawler, ParseMainPage}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class ActorSpec extends TestKit(ActorSystem("DealmoonSystemSpec"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll{

  val master = system.actorOf(Props[MasterActor])
  val worker = system.actorOf(Props[WorkerActor])

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "An master actor" must {

    "start crawling and create the same number of child actors as pages" in {
      val probe = TestProbe()
      probe.send(master,CrawlerStart("https://www.dealmoon.com/Beauty","Beauty",20))
      probe.expectMsg("Crawler Started!")
      probe.expectMsg(20)
    }

    "Re-assign worker actors with Detail Page task and modify the crawled lists" in {
      val probe = TestProbe()
      probe.send(master,FinishMainPageCrawler(List("https://www.dealmoon.com/Up-to-400-Off-La-Mer-8/1113283.html"),"Beauty"))
      probe.expectMsg("Assign Detail Page Crawler Task!")
      probe.expectMsg("Finished")
    }

  }


  "An worker actor" must {

    "receive parse main page job, return the urls list and finish signal" in {
      val probe = TestProbe()
      probe.send(worker,ParseMainPage("https://www.dealmoon.com/Beauty/3","Beauty"))
      probe.expectMsg("Parse Main Page task received!")
      probe.expectMsgType[List[String]]
      probe.expectMsgClass(classOf[FinishMainPageCrawler])

    }

    "receive parse detail page job, return the discounts map and finish signal" in {
      val probe = TestProbe()
      probe.send(worker,DetailInformation("https://www.dealmoon.com/Up-to-400-Off-La-Mer-8/1113283.html","Beauty"))
      probe.expectMsg("Parse Detail Page task received!")
      probe.expectMsgType[ConcurrentHashMap[String, String]]
      probe.expectMsg("csv file saved")
    }

  }


}