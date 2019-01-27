
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

object discountInfoStats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Form[String],List[scala.Tuple2[Any, Int]],List[scala.Tuple2[Any, Any]],RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(keywordCategory: Form[String], platformCountList: List[(Any, Int)], platformFavoriteList: List[(Any, Any)])(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.179*/("""


"""),format.raw/*12.1*/("""<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>
    </head>
    <body>
        <div class="container">
                <p class="row" style="margin-top: 3%">Top 10 Most Post Platforms: </p>
            """),_display_(/*23.14*/if(platformCountList != null)/*23.43*/ {_display_(Seq[Any](format.raw/*23.45*/("""
                """),format.raw/*24.17*/("""<div id="platformPost" style="width: 80%" class="row">
                    <canvas id="platformPostChart" width="80%" height="40%" style="width: 80%;
                        height: 40%"></canvas>
                    <script >
                            var ctxCount = document.getElementById("platformPostChart");
                            var platforms = [];
                            var platformPostData = [];
                            """),_display_(/*31.30*/for((platform, count) <- platformCountList) yield /*31.73*/ {_display_(Seq[Any](format.raw/*31.75*/("""
                            """),format.raw/*32.29*/("""platforms.push(""""),_display_(/*32.46*/platform),format.raw/*32.54*/("""")
                            platformPostData.push("""),_display_(/*33.52*/count),format.raw/*33.57*/(""")
                            """)))}),format.raw/*34.30*/("""
                            """),format.raw/*35.29*/("""var chart = new Chart(ctxCount, """),format.raw/*35.61*/("""{"""),format.raw/*35.62*/("""
                                """),format.raw/*36.33*/("""type: "bar",
                                data: """),format.raw/*37.39*/("""{"""),format.raw/*37.40*/("""
                                    """),format.raw/*38.37*/("""labels: platforms,
                                    datasets: ["""),format.raw/*39.48*/("""{"""),format.raw/*39.49*/("""
                                        """),format.raw/*40.41*/("""data: platformPostData,
                                        backgroundColor: [
                                            'rgba(255, 99, 132, 0.2)',
                                            'rgba(54, 162, 235, 0.2)',
                                            'rgba(255, 206, 86, 0.2)',
                                            'rgba(75, 192, 192, 0.2)',
                                            'rgba(153, 102, 255, 0.2)',
                                            'rgba(255, 159, 64, 0.2)',
                                            'rgba(255, 99, 132, 0.2)',
                                            'rgba(54, 162, 235, 0.2)',
                                            'rgba(255, 206, 86, 0.2)',
                                            'rgba(75, 192, 192, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(255,99,132,1)',
                                            'rgba(54, 162, 235, 1)',
                                            'rgba(255, 206, 86, 1)',
                                            'rgba(75, 192, 192, 1)',
                                            'rgba(153, 102, 255, 1)',
                                            'rgba(255, 159, 64, 1)',
                                            'rgba(255,99,132,1)',
                                            'rgba(54, 162, 235, 1)',
                                            'rgba(255, 206, 86, 1)',
                                            'rgba(75, 192, 192, 1)'
                                        ],
                                        borderWidth: 1

                                    """),format.raw/*67.37*/("""}"""),format.raw/*67.38*/("""]
                                """),format.raw/*68.33*/("""}"""),format.raw/*68.34*/("""
                            """),format.raw/*69.29*/("""}"""),format.raw/*69.30*/(""")

                    </script>
                </div>
            """)))}),format.raw/*73.14*/("""

            """),format.raw/*75.13*/("""<div class="w-100"></div>

                <p class="row">Top 5 Popular Platforms:</p>
                <div id="categorySelect" class="row">
                """),_display_(/*79.18*/helper/*79.24*/.form(action = routes.HomeController.discountInfoStatsPost())/*79.85*/ {_display_(Seq[Any](format.raw/*79.87*/("""

                    """),format.raw/*81.21*/("""<div id="dropdownlist">
                    """),_display_(/*82.22*/select(
                        field = keywordCategory("category"),
                        options = Seq(
                            "Clothing-Jewelry-Bags" -> "Clothing-Jewelry-Bags",
                            "Beauty" -> "Beauty",
                            "Electronics-Computers" -> "Electronics-Computers",
                            "At-Home" -> "At-Home",
                            "Baby-Kids" -> "Baby-Kids",
                            "Sports-Outdoors" -> "Sports-Outdoors"
                        ),
                        '_default -> "Choose One Category",
                    )),format.raw/*93.22*/("""
                    """),format.raw/*94.21*/("""</div>
                    <input class="btn btn-primary" type="submit" value="Submit">
                """)))}),format.raw/*96.18*/("""
                """),format.raw/*97.17*/("""</div>

                """),_display_(/*99.18*/if(platformFavoriteList != null)/*99.50*/ {_display_(Seq[Any](format.raw/*99.52*/("""
                    """),format.raw/*100.21*/("""<div id="platformFavorite" style="width: 80%;" class="row">
                        <canvas id="platformFavoriteChart" width="80%" height="40%" style="width: 80%;
                            height: 40%"></canvas>
                        <script>
                                var ctxFavorite = document.getElementById("platformFavoriteChart");
                                var platforms = [];
                                var platformFavoriteData = [];
                                console.log("favorite list here:" + """"),_display_(/*107.71*/platformFavoriteList),format.raw/*107.91*/("""");
                                """),_display_(/*108.34*/for((platform, favorites) <- platformFavoriteList) yield /*108.84*/ {_display_(Seq[Any](format.raw/*108.86*/("""
                                """),format.raw/*109.33*/("""platforms.push(""""),_display_(/*109.50*/platform),format.raw/*109.58*/("""")
                                platformFavoriteData.push("""),_display_(/*110.60*/favorites),format.raw/*110.69*/(""");
                                """)))}),format.raw/*111.34*/("""
                                """),format.raw/*112.33*/("""var chart = new Chart(ctxFavorite, """),format.raw/*112.68*/("""{"""),format.raw/*112.69*/("""
                                    """),format.raw/*113.37*/("""type: "bar",
                                    data: """),format.raw/*114.43*/("""{"""),format.raw/*114.44*/("""
                                        """),format.raw/*115.41*/("""labels: platforms,
                                        datasets: ["""),format.raw/*116.52*/("""{"""),format.raw/*116.53*/("""
                                            """),format.raw/*117.45*/("""label: "# of favorites",
                                            data: platformFavoriteData,
                                            backgroundColor: [
                                                'rgba(255, 99, 132, 0.2)',
                                                'rgba(54, 162, 235, 0.2)',
                                                'rgba(255, 206, 86, 0.2)',
                                                'rgba(75, 192, 192, 0.2)',
                                                'rgba(153, 102, 255, 0.2)'
                                            ],
                                            borderColor: [
                                                'rgba(255,99,132,1)',
                                                'rgba(54, 162, 235, 1)',
                                                'rgba(255, 206, 86, 1)',
                                                'rgba(75, 192, 192, 1)',
                                                'rgba(153, 102, 255, 1)'
                                            ],
                                            borderWidth: 1
                                        """),format.raw/*134.41*/("""}"""),format.raw/*134.42*/("""]
                                    """),format.raw/*135.37*/("""}"""),format.raw/*135.38*/("""
                                """),format.raw/*136.33*/("""}"""),format.raw/*136.34*/(""")
                        </script>
                    </div>
                """)))}),format.raw/*139.18*/("""
            """),format.raw/*140.13*/("""<a class="row" href="/">Back to main page</a>
            </div>
    </body>
</html>"""))
      }
    }
  }

  def render(keywordCategory:Form[String],platformCountList:List[scala.Tuple2[Any, Int]],platformFavoriteList:List[scala.Tuple2[Any, Any]],request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(keywordCategory,platformCountList,platformFavoriteList)(request,messagesProvider)

  def f:((Form[String],List[scala.Tuple2[Any, Int]],List[scala.Tuple2[Any, Any]]) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (keywordCategory,platformCountList,platformFavoriteList) => (request,messagesProvider) => apply(keywordCategory,platformCountList,platformFavoriteList)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 11 23:54:44 EST 2018
                  SOURCE: /Users/chenxinyun/final scala/scala_final_project/app/views/discountInfoStats.scala.html
                  HASH: c26720f44d71a2786f8c58238039435011d156b1
                  MATRIX: 432->261|456->280|883->298|1156->475|1189->481|2329->1594|2367->1623|2407->1625|2453->1643|2935->2098|2994->2141|3034->2143|3092->2173|3136->2190|3165->2198|3247->2253|3273->2258|3336->2290|3394->2320|3454->2352|3483->2353|3545->2387|3625->2439|3654->2440|3720->2478|3815->2545|3844->2546|3914->2588|5679->4325|5708->4326|5771->4361|5800->4362|5858->4392|5887->4393|5991->4466|6035->4482|6224->4644|6239->4650|6309->4711|6349->4713|6401->4737|6474->4783|7107->5395|7157->5417|7295->5524|7341->5542|7395->5569|7436->5601|7476->5603|7527->5625|8094->6164|8136->6184|8202->6222|8269->6272|8310->6274|8373->6308|8418->6325|8448->6333|8539->6396|8570->6405|8639->6442|8702->6476|8766->6511|8796->6512|8863->6550|8948->6606|8978->6607|9049->6649|9149->6720|9179->6721|9254->6767|10449->7933|10479->7934|10547->7973|10577->7974|10640->8008|10670->8009|10785->8092|10828->8106
                  LINES: 17->7|18->8|23->9|28->9|31->12|42->23|42->23|42->23|43->24|50->31|50->31|50->31|51->32|51->32|51->32|52->33|52->33|53->34|54->35|54->35|54->35|55->36|56->37|56->37|57->38|58->39|58->39|59->40|86->67|86->67|87->68|87->68|88->69|88->69|92->73|94->75|98->79|98->79|98->79|98->79|100->81|101->82|112->93|113->94|115->96|116->97|118->99|118->99|118->99|119->100|126->107|126->107|127->108|127->108|127->108|128->109|128->109|128->109|129->110|129->110|130->111|131->112|131->112|131->112|132->113|133->114|133->114|134->115|135->116|135->116|136->117|153->134|153->134|154->135|154->135|155->136|155->136|158->139|159->140
                  -- GENERATED --
              */
          