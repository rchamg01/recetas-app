// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/Usuario_App/conf/routes
// @DATE:Wed Jan 06 01:18:33 CET 2021


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
