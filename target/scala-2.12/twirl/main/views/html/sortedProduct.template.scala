
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

object sortedProduct extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[scala.Tuple2[String, String]],List[SortedProductInfo],RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(keywordProduct: Form[(String,String)], sortedProductInfoList: List[SortedProductInfo])(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.158*/("""


"""),format.raw/*12.1*/("""<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>
    </head>
<body>

    <div class="container">
    <div id="searchPopular" class="row" style="margin-top: 3%">
        """),_display_(/*26.10*/helper/*26.16*/.form(action = routes.HomeController.sortProductPost())/*26.71*/ {_display_(Seq[Any](format.raw/*26.73*/("""
            """),format.raw/*27.13*/("""<div class="select_bar">
                """),_display_(/*28.18*/helper/*28.24*/.inputText(keywordProduct("keyword"))),format.raw/*28.61*/("""
                """),_display_(/*29.18*/select(
                    field = keywordProduct("category"),
                    options = Seq(
                        "Clothing-Jewelry-Bags" -> "Clothing-Jewelry-Bags",
                        "Beauty" -> "Beauty",
                        "Electronics-Computers" -> "Electronics-Computers",
                        "At-Home" -> "At-Home",
                        "Baby-Kids" -> "Baby-Kids",
                        "Sports-Outdoors" -> "Sports-Outdoors"
                    ),
                    '_default -> "Choose One Category",
                )),format.raw/*40.18*/("""
                """),format.raw/*41.17*/("""<input class="mostPopularButton btn btn-primary" type="submit" value="Search">
            </div>
        """)))}),format.raw/*43.10*/("""
    """),format.raw/*44.5*/("""</div>

    """),_display_(/*46.6*/if(sortedProductInfoList!=null)/*46.37*/{_display_(Seq[Any](format.raw/*46.38*/("""
        """),format.raw/*47.9*/("""<div id="mostPopularList" class="row">
            <table class="table" id="table">
                <tr>
                    <th>Title</th>
                    <th>Discounted Price</th>
                    <th>Original Price</th>
                    <th>Platform</th>
                    <th>Operation</th>
                    <th>Operation</th>
                </tr>
                """),_display_(/*57.18*/for((item, index) <- sortedProductInfoList.zipWithIndex) yield /*57.74*/{_display_(Seq[Any](format.raw/*57.75*/("""
                    """),format.raw/*58.21*/("""<tr>
                        <td>"""),_display_(/*59.30*/item/*59.34*/.title),format.raw/*59.40*/("""</td>
                        <td>"""),_display_(/*60.30*/item/*60.34*/.discountedPrice),format.raw/*60.50*/("""</td>
                        <td>"""),_display_(/*61.30*/item/*61.34*/.originalPrice),format.raw/*61.48*/("""</td>
                        <td>"""),_display_(/*62.30*/item/*62.34*/.platform),format.raw/*62.43*/("""</td>
                        <td><a class="btn btn-info" onclick="alert('Item has been added to the favourite list')" href=""""),_display_(/*63.121*/controllers/*63.132*/.routes.HomeController.addFav(helper.urlEncode(item.title), helper.urlEncode(item.discountedPrice))),format.raw/*63.231*/("""">Add to Favourite</a>
                        </td>
                        <td><button class="btn btn-primary" onclick="customclick("""),_display_(/*65.83*/index),format.raw/*65.88*/(""", '"""),_display_(/*65.92*/item/*65.96*/.discountedPrice),format.raw/*65.112*/("""')">Trend Graph</button></td>
                    </tr>
                """)))}),format.raw/*67.18*/("""
            """),format.raw/*68.13*/("""</table>
        </div>
    """)))}),format.raw/*70.6*/("""
    """),_display_(/*71.6*/if(sortedProductInfoList!=null)/*71.37*/ {_display_(Seq[Any](format.raw/*71.39*/("""
        """),_display_(/*72.10*/for((item, index) <- sortedProductInfoList.zipWithIndex) yield /*72.66*/ {_display_(Seq[Any](format.raw/*72.68*/("""
            """),format.raw/*73.13*/("""<div id=""""),_display_(/*73.23*/(index.toString() + 'i')),format.raw/*73.47*/("""" class="modal">
                <canvas id=""""),_display_(/*74.30*/(index.toString() + 'j')),format.raw/*74.54*/("""" width="600" height="400"></canvas>
                <a href="#" rel="modal:close">Close</a>
            </div>
        """)))}),format.raw/*77.10*/("""
    """)))}),format.raw/*78.6*/("""

        """),format.raw/*80.9*/("""<a class="row" href="/">Back to main page</a>

</div>
</body>
    <script >
       function customclick(index, price) """),format.raw/*85.43*/("""{"""),format.raw/*85.44*/("""
           """),format.raw/*86.12*/("""console.log("here i clicked " + index + "  " + price);
           var filteredPrice = price.substring(1);
           // In case of pound price
           console.log(filteredPrice);
           var data = [];
           data.push(filteredPrice);
           for (var i = 0; i < 3; i++) """),format.raw/*92.40*/("""{"""),format.raw/*92.41*/("""
             """),format.raw/*93.14*/("""data.push(filteredPrice - Math.random() * filteredPrice * 0.05);
           """),format.raw/*94.12*/("""}"""),format.raw/*94.13*/("""
           """),format.raw/*95.12*/("""var options = """),format.raw/*95.26*/("""{"""),format.raw/*95.27*/("""
               """),format.raw/*96.16*/("""type: 'line',
               data: """),format.raw/*97.22*/("""{"""),format.raw/*97.23*/("""
                   """),format.raw/*98.20*/("""labels: ["Current", "History 1", "History 2", "History 3"],
                   datasets: [
                       """),format.raw/*100.24*/("""{"""),format.raw/*100.25*/("""
                           """),format.raw/*101.28*/("""label: 'Price',
                           data: data,
                           borderWidth: 1
                       """),format.raw/*104.24*/("""}"""),format.raw/*104.25*/(""",
                   ]
               """),format.raw/*106.16*/("""}"""),format.raw/*106.17*/(""",
               options: """),format.raw/*107.25*/("""{"""),format.raw/*107.26*/("""
                   """),format.raw/*108.20*/("""scales: """),format.raw/*108.28*/("""{"""),format.raw/*108.29*/("""
                       """),format.raw/*109.24*/("""yAxes: ["""),format.raw/*109.32*/("""{"""),format.raw/*109.33*/("""
                           """),format.raw/*110.28*/("""ticks: """),format.raw/*110.35*/("""{"""),format.raw/*110.36*/("""
                               """),format.raw/*111.32*/("""reverse: false
                           """),format.raw/*112.28*/("""}"""),format.raw/*112.29*/("""
                       """),format.raw/*113.24*/("""}"""),format.raw/*113.25*/("""]
                   """),format.raw/*114.20*/("""}"""),format.raw/*114.21*/("""
               """),format.raw/*115.16*/("""}"""),format.raw/*115.17*/("""
           """),format.raw/*116.12*/("""}"""),format.raw/*116.13*/(""";
           var ctx = document.getElementById(index+ 'j').getContext('2d');
           console.log(ctx);
           new Chart(ctx, options);
           event.preventDefault();
           $('#' + index + 'i').modal();
       """),format.raw/*122.8*/("""}"""),format.raw/*122.9*/("""
    """),format.raw/*123.5*/("""</script>
</html>"""))
      }
    }
  }

  def render(keywordProduct:Form[scala.Tuple2[String, String]],sortedProductInfoList:List[SortedProductInfo],request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(keywordProduct,sortedProductInfoList)(request,messagesProvider)

  def f:((Form[scala.Tuple2[String, String]],List[SortedProductInfo]) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (keywordProduct,sortedProductInfoList) => (request,messagesProvider) => apply(keywordProduct,sortedProductInfoList)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 14 10:28:32 EST 2018
                  SOURCE: /Users/chenxinyun/final scala/scala_final_project/app/views/sortedProduct.scala.html
                  HASH: b1d8779dfbee36af667b70e2b632e8fc87a5f52c
                  MATRIX: 432->261|456->280|867->298|1119->454|1152->460|2378->1659|2393->1665|2457->1720|2497->1722|2539->1736|2609->1779|2624->1785|2682->1822|2728->1841|3316->2408|3362->2426|3502->2535|3535->2541|3576->2556|3616->2587|3655->2588|3692->2598|4114->2993|4186->3049|4225->3050|4275->3072|4337->3107|4350->3111|4377->3117|4440->3153|4453->3157|4490->3173|4553->3209|4566->3213|4601->3227|4664->3263|4677->3267|4707->3276|4862->3403|4883->3414|5004->3513|5168->3650|5194->3655|5225->3659|5238->3663|5276->3679|5382->3754|5424->3768|5485->3799|5518->3806|5558->3837|5598->3839|5636->3850|5708->3906|5748->3908|5790->3922|5827->3932|5872->3956|5946->4003|5991->4027|6146->4151|6183->4158|6222->4170|6373->4293|6402->4294|6443->4307|6761->4597|6790->4598|6833->4613|6938->4690|6967->4691|7008->4704|7050->4718|7079->4719|7124->4736|7188->4772|7217->4773|7266->4794|7411->4910|7441->4911|7499->4940|7651->5063|7681->5064|7750->5104|7780->5105|7836->5132|7866->5133|7916->5154|7953->5162|7983->5163|8037->5188|8074->5196|8104->5197|8162->5226|8198->5233|8228->5234|8290->5267|8362->5310|8392->5311|8446->5336|8476->5337|8527->5359|8557->5360|8603->5377|8633->5378|8675->5391|8705->5392|8964->5623|8993->5624|9027->5630
                  LINES: 17->7|18->8|23->9|28->9|31->12|45->26|45->26|45->26|45->26|46->27|47->28|47->28|47->28|48->29|59->40|60->41|62->43|63->44|65->46|65->46|65->46|66->47|76->57|76->57|76->57|77->58|78->59|78->59|78->59|79->60|79->60|79->60|80->61|80->61|80->61|81->62|81->62|81->62|82->63|82->63|82->63|84->65|84->65|84->65|84->65|84->65|86->67|87->68|89->70|90->71|90->71|90->71|91->72|91->72|91->72|92->73|92->73|92->73|93->74|93->74|96->77|97->78|99->80|104->85|104->85|105->86|111->92|111->92|112->93|113->94|113->94|114->95|114->95|114->95|115->96|116->97|116->97|117->98|119->100|119->100|120->101|123->104|123->104|125->106|125->106|126->107|126->107|127->108|127->108|127->108|128->109|128->109|128->109|129->110|129->110|129->110|130->111|131->112|131->112|132->113|132->113|133->114|133->114|134->115|134->115|135->116|135->116|141->122|141->122|142->123
                  -- GENERATED --
              */
          