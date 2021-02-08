// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Mon Feb 08 18:28:58 CET 2021


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
