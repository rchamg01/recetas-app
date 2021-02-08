// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Mon Feb 08 18:28:58 CET 2021

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

  
    // @LINE:10
    def getRecetaId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def deleteIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.deleteIngrediente",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:13
    def updateReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.updateReceta",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/"})
        }
      """
    )
  
    // @LINE:15
    def deleteReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.deleteReceta",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def getRecetaNombre: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaNombre",
      """
        function(nombre0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/nombre/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre0))})
        }
      """
    )
  
    // @LINE:8
    def getRecetaTipo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaTipo",
      """
        function(tipo0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/tipo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tipo", tipo0))})
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
  
    // @LINE:12
    def getListaRecetas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getListaRecetas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/list"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
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
