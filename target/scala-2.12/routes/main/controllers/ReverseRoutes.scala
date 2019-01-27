// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/chenxinyun/final scala/scala_final_project/conf/routes
// @DATE:Fri Dec 14 10:28:31 EST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def discountInfoStatsCategoryCollect(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discount-stats")
    }
  
    // @LINE:8
    def main(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:12
    def keywordCollect(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sort-product-price")
    }
  
    // @LINE:24
    def sendEmail(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "email/")
    }
  
    // @LINE:13
    def sortProductPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sort-product-price")
    }
  
    // @LINE:10
    def searchMostPopularDiscountPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "most-popular-discount-list")
    }
  
    // @LINE:15
    def addFav(fav:String, price:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "fav/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("fav", fav)) + "/price/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("price", price)))
    }
  
    // @LINE:18
    def discountInfoStatsPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "discount-stats")
    }
  
    // @LINE:9
    def conditionCollect(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "most-popular-discount-list")
    }
  
  }

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
