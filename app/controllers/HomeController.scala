package controllers

import java.text.SimpleDateFormat
import java.util.Date

import controllers.Crawler.DealmoonScrawler
import javax.inject._
import models.{FavouriteItem, SearchFilterCondition}
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.Forms.mapping
import play.api.libs.mailer.{Email, MailerClient}
import play.api.mvc._
import play.utils.UriEncoding

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, mailerClient: MailerClient) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  val conditionForm: Form[SearchFilterCondition] = Form(
    mapping(
      "category" -> text,
      "matrix" -> text
    )(SearchFilterCondition.apply)(SearchFilterCondition.unapply)
  )

  val keywordProduct = Form(
    tuple(
      "keyword" -> text,
      "category" -> text
    )
  )

  val platformFavoriteCategory = Form(
    single(
      "category" -> text
    )
  )

  val emailForm = Form(
    single(
      "email" -> text
    )
  )

  var favList = List[FavouriteItem]()
  var emailReceivers = List[String]()
  var crawlerStartTime = ""
  DealmoonScrawler.start()

  def main = Action { implicit request: Request[AnyContent] =>
    val startTime = System.currentTimeMillis()
    val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = new Date(startTime)
    crawlerStartTime = formatter.format(date)
    Ok(views.html.main(emailForm,favList,crawlerStartTime))
  }


  def conditionCollect() = Action { implicit request =>
    Ok(views.html.searchMostPopularDiscount(conditionForm, null))
  }

  def searchMostPopularDiscountPost() = Action { implicit request =>
    val formData: SearchFilterCondition = conditionForm.bindFromRequest.get // Careful: BasicForm.form.bindFromRequest returns an Option
    Ok(views.html.searchMostPopularDiscount(conditionForm,SparkAnalysis.mostPopularDiscount(formData.category,formData.matrix)))
  }

  def keywordCollect() = Action { implicit request =>
    Ok(views.html.sortedProduct(keywordProduct, null))
  }

  def addFav(fav: String, price: String) = Action { implicit request =>
    var decodedItem = UriEncoding.decodePathSegment(fav, "UTF-8")
    decodedItem = decodedItem.replace("+", " ")
    var decodedPrice = UriEncoding.decodePathSegment(price, "UTF-8")
    decodedPrice = decodedPrice.replace("+", " ")
    val item: FavouriteItem = FavouriteItem(decodedItem, decodedPrice);
    favList = item :: favList
    Ok(views.html.main(emailForm,favList,crawlerStartTime))
  }


  def sortProductPost() = Action { implicit request =>
    val formData = keywordProduct.bindFromRequest.get // Careful: BasicForm.form.bindFromRequest returns an Option
    Ok(views.html.sortedProduct(keywordProduct,SparkAnalysis.sortDiscountInfo(formData._1,formData._2)))
  }

  def discountInfoStatsCategoryCollect() = Action{ implicit request =>
    val platformPostCountList = SparkAnalysis.platformCount()
    Ok(views.html.discountInfoStats(platformFavoriteCategory,platformPostCountList,null))
  }

  def discountInfoStatsPost() = Action{ implicit request =>
    val formData = platformFavoriteCategory.bindFromRequest.get
    Ok(views.html.discountInfoStats(platformFavoriteCategory,null,SparkAnalysis.firstFivePlatformOfCategory(formData)))
  }

  def sendEmail() = Action{ implicit request =>
    val formData = emailForm.bindFromRequest.get
    emailReceivers = formData.toString :: emailReceivers
    var htmlContent = "<h3>Recent Update Of Your Item</h3></br><b>Discount Information:</b>" + "</br>" +
      "<table border='1'><tr><th>Item</th><th>Discount Infomation</th></tr>";
    for (item <- favList) {
      htmlContent = htmlContent + "<tr><td>" + item.item + "</td>" + "<td>" + item.price + "</td></tr>"
    }
    val email = Email(
      "An Update Of Your Recent Favourite Items",
      "sparkprojecttest@outlook.com",
      //Seq("wu.x@husky.neu.edu", "chen.xinyu@husky.neu.edu"),
      emailReceivers,
      bodyHtml = Some(htmlContent)
    )
    mailerClient.send(email)
    Ok(views.html.main(emailForm,favList,crawlerStartTime))
  }

}
