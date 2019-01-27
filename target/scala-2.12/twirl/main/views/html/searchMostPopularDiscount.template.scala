
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
/*8.2*/import helper._

object searchMostPopularDiscount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[SearchFilterCondition],List[PopularDiscount],RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(searchConditionForm: Form[SearchFilterCondition], mostPopularDiscountList: List[PopularDiscount])(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.169*/("""


"""),format.raw/*12.1*/("""<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
<body>
    <div class="container">
    <div id="searchPopular" class="row" style="margin-top: 3%">
        """),_display_(/*22.10*/helper/*22.16*/.form(action = routes.HomeController.searchMostPopularDiscountPost())/*22.85*/ {_display_(Seq[Any](format.raw/*22.87*/("""
            """),format.raw/*23.13*/("""<div class="select_bar">
                <div class="dropdownlist">

                """),_display_(/*26.18*/select(
                    field = searchConditionForm("category"),
                    options = Seq(
                        "Clothing-Jewelry-Bags" -> "Clothing-Jewelry-Bags",
                        "Beauty" -> "Beauty",
                        "Electronics-Computers" -> "Electronics-Computers",
                        "At-Home" -> "At-Home",
                        "Baby-Kids" -> "Baby-Kids",
                        "Sports-Outdoors" -> "Sports-Outdoors"
                    ),
                    '_default -> "Choose One Category",
                )),format.raw/*37.18*/("""
                """),format.raw/*38.17*/("""</div>
                <div class="select_bar">
                    """),_display_(/*40.22*/select(
                        field = searchConditionForm("matrix"),
                        options = Seq(
                            "Favorites" -> "By Favorites",
                            "Shares" -> "By Shares",
                            "Comments" -> "By Comments",
                        ),
                        '_default -> "Choose One Matrix",
                    )),format.raw/*48.22*/("""

                    """)))}),format.raw/*50.22*/("""
                """),format.raw/*51.17*/("""</div>
            <input class="btn btn-primary" type="submit" value="Search"></input>
        </div>
    </div>

    """),_display_(/*56.6*/if(mostPopularDiscountList!=null)/*56.39*/{_display_(Seq[Any](format.raw/*56.40*/("""
        """),format.raw/*57.9*/("""<div id="mostPopularList" class="row">
            <table class="table">
                <tr>
                    <th>Discount</th>
                    <th>Platform</th>
                </tr>
                """),_display_(/*63.18*/for(item <- mostPopularDiscountList) yield /*63.54*/{_display_(Seq[Any](format.raw/*63.55*/("""
                    """),format.raw/*64.21*/("""<tr>
                        <td>"""),_display_(/*65.30*/item/*65.34*/.discount),format.raw/*65.43*/("""</td>
                        <td>"""),_display_(/*66.30*/item/*66.34*/.platform),format.raw/*66.43*/("""</td>
                    </tr>
                """)))}),format.raw/*68.18*/("""
            """),format.raw/*69.13*/("""</table>
        </div>
    """)))}),format.raw/*71.6*/("""
        """),format.raw/*72.9*/("""<a class="row" href="/">Back to main page</a>
    </div>
</body>
</html>"""))
      }
    }
  }

  def render(searchConditionForm:Form[SearchFilterCondition],mostPopularDiscountList:List[PopularDiscount],request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(searchConditionForm,mostPopularDiscountList)(request,messagesProvider)

  def f:((Form[SearchFilterCondition],List[PopularDiscount]) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (searchConditionForm,mostPopularDiscountList) => (request,messagesProvider) => apply(searchConditionForm,mostPopularDiscountList)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 11 23:54:44 EST 2018
                  SOURCE: /Users/chenxinyun/final scala/scala_final_project/app/views/searchMostPopularDiscount.scala.html
                  HASH: 760579f3a1c25297b11ecc3f29a1842d0883593f
                  MATRIX: 432->261|456->280|870->298|1133->465|1166->471|2175->1453|2190->1459|2268->1528|2308->1530|2350->1544|2466->1633|3059->2205|3105->2223|3203->2294|3617->2687|3673->2712|3719->2730|3870->2855|3912->2888|3951->2889|3988->2899|4230->3114|4282->3150|4321->3151|4371->3173|4433->3208|4446->3212|4476->3221|4539->3257|4552->3261|4582->3270|4664->3321|4706->3335|4767->3366|4804->3376
                  LINES: 17->7|18->8|23->9|28->9|31->12|41->22|41->22|41->22|41->22|42->23|45->26|56->37|57->38|59->40|67->48|69->50|70->51|75->56|75->56|75->56|76->57|82->63|82->63|82->63|83->64|84->65|84->65|84->65|85->66|85->66|85->66|87->68|88->69|90->71|91->72
                  -- GENERATED --
              */
          