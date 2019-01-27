
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*7.2*/import java.util
/*8.2*/import views.html.helper.select
/*9.2*/import views.html.helper.form

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Form[String],List[FavouriteItem],String,RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(emailForm: Form[String],favList: List[FavouriteItem], recentCrawlerTime: String)(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.152*/("""


"""),format.raw/*13.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="container">
            <p class="row" style="margin-top: 3%">Latest Crawler happens at : """),_display_(/*24.80*/recentCrawlerTime),format.raw/*24.97*/("""</p>
            <div class="row">
                <a class="btn btn-primary col" href="/most-popular-discount-list"><p>Search Most Popular Discount</p></a>
                <a class="btn btn-warning col" href="/sort-product-price"><p>Sort Product Discounted Price</p></a>
                <a class="btn btn-info col" href="/discount-stats"><p>Discount Info Stats</p></a>
            </div>

            <div class="row" style="margin-bottom: 3%"></div>

            """),_display_(/*33.14*/if(favList!=null)/*33.31*/{_display_(Seq[Any](format.raw/*33.32*/("""

                """),format.raw/*35.17*/("""<p class="row">Wish List :</p>

                <div class="row" style="margin-bottom: 3%">
                """),_display_(/*38.18*/helper/*38.24*/.form(action = routes.HomeController.sendEmail())/*38.73*/ {_display_(Seq[Any](format.raw/*38.75*/("""
                    """),format.raw/*39.21*/("""<div class="select_bar">
                        """),_display_(/*40.26*/helper/*40.32*/.inputText(emailForm("email"))),format.raw/*40.62*/("""
                        """),format.raw/*41.25*/("""<input class="mostPopularButton btn btn-primary" type="submit" value="Send Email" onclick="alert('Email has been successfully sent')">
                    </div>
                """)))}),format.raw/*43.18*/("""
                """),format.raw/*44.17*/("""</div>

                <div class="row">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Discount Infomation</th>
                            </tr>
                        </thead>
                        <tbody>
                        """),_display_(/*55.26*/for(fav <- favList) yield /*55.45*/ {_display_(Seq[Any](format.raw/*55.47*/("""
                            """),format.raw/*56.29*/("""<tr>
                                <td>"""),_display_(/*57.38*/fav/*57.41*/.item),format.raw/*57.46*/("""</td>
                                <td>Price Have Been Discounted To """),_display_(/*58.68*/fav/*58.71*/.price),format.raw/*58.77*/("""</td>
                            </tr>
                        """)))}),format.raw/*60.26*/("""
                        """),format.raw/*61.25*/("""</tbody>
                    </table>
                </div>
            """)))}),format.raw/*64.14*/("""
        """),format.raw/*65.9*/("""</div>
    </body>
</html>"""))
      }
    }
  }

  def render(emailForm:Form[String],favList:List[FavouriteItem],recentCrawlerTime:String,request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(emailForm,favList,recentCrawlerTime)(request,messagesProvider)

  def f:((Form[String],List[FavouriteItem],String) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (emailForm,favList,recentCrawlerTime) => (request,messagesProvider) => apply(emailForm,favList,recentCrawlerTime)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 14 10:28:32 EST 2018
                  SOURCE: /Users/chenxinyun/final scala/scala_final_project/app/views/main.scala.html
                  HASH: 04c456af14b0f8579e6f697fb3b176ddbaf004c4
                  MATRIX: 432->261|456->280|495->314|893->346|1140->496|1173->502|2224->1526|2262->1543|2764->2018|2790->2035|2829->2036|2877->2056|3016->2168|3031->2174|3089->2223|3129->2225|3179->2247|3257->2298|3272->2304|3323->2334|3377->2360|3589->2541|3635->2559|4091->2988|4126->3007|4166->3009|4224->3039|4294->3082|4306->3085|4332->3090|4433->3164|4445->3167|4472->3173|4570->3240|4624->3266|4732->3343|4769->3353
                  LINES: 17->7|18->8|19->9|24->10|29->10|32->13|43->24|43->24|52->33|52->33|52->33|54->35|57->38|57->38|57->38|57->38|58->39|59->40|59->40|59->40|60->41|62->43|63->44|74->55|74->55|74->55|75->56|76->57|76->57|76->57|77->58|77->58|77->58|79->60|80->61|83->64|84->65
                  -- GENERATED --
              */
          