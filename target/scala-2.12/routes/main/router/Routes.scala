// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/chenxinyun/final scala/scala_final_project/conf/routes
// @DATE:Fri Dec 14 10:28:31 EST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  HomeController_0: controllers.HomeController,
  // @LINE:22
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    HomeController_0: controllers.HomeController,
    // @LINE:22
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.main()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """most-popular-discount-list""", """controllers.HomeController.conditionCollect()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """most-popular-discount-list""", """controllers.HomeController.searchMostPopularDiscountPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sort-product-price""", """controllers.HomeController.keywordCollect()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sort-product-price""", """controllers.HomeController.sortProductPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fav/""" + "$" + """fav<[^/]+>/price/""" + "$" + """price<[^/]+>""", """controllers.HomeController.addFav(fav:String, price:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discount-stats""", """controllers.HomeController.discountInfoStatsCategoryCollect()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discount-stats""", """controllers.HomeController.discountInfoStatsPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """email/""", """controllers.HomeController.sendEmail()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_HomeController_main0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_main0_invoker = createInvoker(
    HomeController_0.main(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "main",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_conditionCollect1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("most-popular-discount-list")))
  )
  private[this] lazy val controllers_HomeController_conditionCollect1_invoker = createInvoker(
    HomeController_0.conditionCollect(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "conditionCollect",
      Nil,
      "GET",
      this.prefix + """most-popular-discount-list""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_searchMostPopularDiscountPost2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("most-popular-discount-list")))
  )
  private[this] lazy val controllers_HomeController_searchMostPopularDiscountPost2_invoker = createInvoker(
    HomeController_0.searchMostPopularDiscountPost(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchMostPopularDiscountPost",
      Nil,
      "POST",
      this.prefix + """most-popular-discount-list""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_keywordCollect3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sort-product-price")))
  )
  private[this] lazy val controllers_HomeController_keywordCollect3_invoker = createInvoker(
    HomeController_0.keywordCollect(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "keywordCollect",
      Nil,
      "GET",
      this.prefix + """sort-product-price""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_sortProductPost4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sort-product-price")))
  )
  private[this] lazy val controllers_HomeController_sortProductPost4_invoker = createInvoker(
    HomeController_0.sortProductPost(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sortProductPost",
      Nil,
      "POST",
      this.prefix + """sort-product-price""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_addFav5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fav/"), DynamicPart("fav", """[^/]+""",true), StaticPart("/price/"), DynamicPart("price", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addFav5_invoker = createInvoker(
    HomeController_0.addFav(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addFav",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """fav/""" + "$" + """fav<[^/]+>/price/""" + "$" + """price<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_discountInfoStatsCategoryCollect6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discount-stats")))
  )
  private[this] lazy val controllers_HomeController_discountInfoStatsCategoryCollect6_invoker = createInvoker(
    HomeController_0.discountInfoStatsCategoryCollect(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "discountInfoStatsCategoryCollect",
      Nil,
      "GET",
      this.prefix + """discount-stats""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_discountInfoStatsPost7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discount-stats")))
  )
  private[this] lazy val controllers_HomeController_discountInfoStatsPost7_invoker = createInvoker(
    HomeController_0.discountInfoStatsPost(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "discountInfoStatsPost",
      Nil,
      "POST",
      this.prefix + """discount-stats""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_sendEmail9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("email/")))
  )
  private[this] lazy val controllers_HomeController_sendEmail9_invoker = createInvoker(
    HomeController_0.sendEmail(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sendEmail",
      Nil,
      "GET",
      this.prefix + """email/""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_HomeController_main0_route(params@_) =>
      call { 
        controllers_HomeController_main0_invoker.call(HomeController_0.main())
      }
  
    // @LINE:9
    case controllers_HomeController_conditionCollect1_route(params@_) =>
      call { 
        controllers_HomeController_conditionCollect1_invoker.call(HomeController_0.conditionCollect())
      }
  
    // @LINE:10
    case controllers_HomeController_searchMostPopularDiscountPost2_route(params@_) =>
      call { 
        controllers_HomeController_searchMostPopularDiscountPost2_invoker.call(HomeController_0.searchMostPopularDiscountPost())
      }
  
    // @LINE:12
    case controllers_HomeController_keywordCollect3_route(params@_) =>
      call { 
        controllers_HomeController_keywordCollect3_invoker.call(HomeController_0.keywordCollect())
      }
  
    // @LINE:13
    case controllers_HomeController_sortProductPost4_route(params@_) =>
      call { 
        controllers_HomeController_sortProductPost4_invoker.call(HomeController_0.sortProductPost())
      }
  
    // @LINE:15
    case controllers_HomeController_addFav5_route(params@_) =>
      call(params.fromPath[String]("fav", None), params.fromPath[String]("price", None)) { (fav, price) =>
        controllers_HomeController_addFav5_invoker.call(HomeController_0.addFav(fav, price))
      }
  
    // @LINE:17
    case controllers_HomeController_discountInfoStatsCategoryCollect6_route(params@_) =>
      call { 
        controllers_HomeController_discountInfoStatsCategoryCollect6_invoker.call(HomeController_0.discountInfoStatsCategoryCollect())
      }
  
    // @LINE:18
    case controllers_HomeController_discountInfoStatsPost7_route(params@_) =>
      call { 
        controllers_HomeController_discountInfoStatsPost7_invoker.call(HomeController_0.discountInfoStatsPost())
      }
  
    // @LINE:22
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:24
    case controllers_HomeController_sendEmail9_route(params@_) =>
      call { 
        controllers_HomeController_sendEmail9_invoker.call(HomeController_0.sendEmail())
      }
  }
}
