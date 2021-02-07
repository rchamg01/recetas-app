// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sun Feb 07 13:20:56 CET 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseRecetasController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def updateReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.updateReceta",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/update"})
        }
      """
    )
  
    // @LINE:13
    def deleteReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.deleteReceta",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/delete"})
        }
      """
    )
  
    // @LINE:8
    def getReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getReceta",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/get"})
        }
      """
    )
  
    // @LINE:7
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas"})
        }
      """
    )
  
    // @LINE:11
    def getListaRecetas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getListaRecetas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/list"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
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
