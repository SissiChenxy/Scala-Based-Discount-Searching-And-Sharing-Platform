import akka.actor.Status.Success
import controllers.HomeController
import org.scalatestplus.play.PlaySpec
import play.api.mvc.{Result, Results}
import play.api.test.{FakeRequest, Helpers}
import scala.concurrent._
import ExecutionContext.Implicits.global

import scala.concurrent.{Await, Future}

class PlayControllerSpec extends PlaySpec with Results {
  val controller = new HomeController(Helpers.stubControllerComponents(), null)

  "Main Page" should {
    "should have result of status code 200" in {
      val futureResult: Future[Result] = controller.main().apply(FakeRequest())
      futureResult.map(result => result.header.status == 200)
    }
  }

  "Search most popular platform by category page" should {
    "should have result of status code 200" in {
      val futureResult: Future[Result] = controller.conditionCollect().apply(FakeRequest())
      futureResult.map(result => result.header.status == 200)
    }
  }

  "Sort discounted product page" should {
    "should have result of status code 200" in {
      val futureResult: Future[Result] = controller.keywordCollect().apply(FakeRequest())
      futureResult.map(result => result.header.status == 200)
    }
  }

  "Deal information statistics page" should {
    "should have result of status code 200" in {
      val futureResult: Future[Result] = controller.discountInfoStatsCategoryCollect().apply(FakeRequest())
      futureResult.map(result => result.header.status == 200)
    }
  }
}