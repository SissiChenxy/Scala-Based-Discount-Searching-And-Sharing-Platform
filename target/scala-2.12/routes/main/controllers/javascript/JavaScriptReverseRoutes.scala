// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/chenxinyun/final scala/scala_final_project/conf/routes
// @DATE:Fri Dec 14 10:28:31 EST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.javascript {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def discountInfoStatsCategoryCollect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.discountInfoStatsCategoryCollect",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "discount-stats"})
        }
      """
    )
  
    // @LINE:8
    def main: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.main",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:12
    def keywordCollect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.keywordCollect",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sort-product-price"})
        }
      """
    )
  
    // @LINE:24
    def sendEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sendEmail",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "email/"})
        }
      """
    )
  
    // @LINE:13
    def sortProductPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sortProductPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sort-product-price"})
        }
      """
    )
  
    // @LINE:10
    def searchMostPopularDiscountPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchMostPopularDiscountPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "most-popular-discount-list"})
        }
      """
    )
  
    // @LINE:15
    def addFav: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addFav",
      """
        function(fav0,price1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "fav/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("fav", fav0)) + "/price/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("price", price1))})
        }
      """
    )
  
    // @LINE:18
    def discountInfoStatsPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.discountInfoStatsPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "discount-stats"})
        }
      """
    )
  
    // @LINE:9
    def conditionCollect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.conditionCollect",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "most-popular-discount-list"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
