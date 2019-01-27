// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/chenxinyun/final scala/scala_final_project/conf/routes
// @DATE:Fri Dec 14 10:28:31 EST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
