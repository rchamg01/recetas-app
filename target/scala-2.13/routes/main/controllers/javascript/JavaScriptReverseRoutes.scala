// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sat Mar 06 01:21:08 CET 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:30
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseUsuariosController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getUsuarioId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuariosController.getUsuarioId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuarios/search/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:23
    def updateUsuario: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuariosController.updateUsuario",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "usuarios/"})
        }
      """
    )
  
    // @LINE:19
    def getUsuarioNombre: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuariosController.getUsuarioNombre",
      """
        function(nombre0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuarios/search/nombre/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre0))})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseDescripcionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def updateDescripcion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DescripcionController.updateDescripcion",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "descripcion/"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseRecetasController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getRecetaIngredienteId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaIngredienteId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/ingrediente/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def getRecetaNombre: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaNombre",
      """
        function(nombre0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/nombre/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre0))})
        }
      """
    )
  
    // @LINE:13
    def getListaRecetas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getListaRecetas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/list"})
        }
      """
    )
  
    // @LINE:21
    def updateReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.updateReceta",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/"})
        }
      """
    )
  
    // @LINE:10
    def getRecetaId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def deleteReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.deleteReceta",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def getRecetaUsuarioId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaUsuarioId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/usuario/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:8
    def getRecetaTiempo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaTiempo",
      """
        function(tiempo0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/tiempo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tiempo", tiempo0))})
        }
      """
    )
  
    // @LINE:7
    def getRecetaTipo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.getRecetaTipo",
      """
        function(tipo0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/search/tipo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tipo", tipo0))})
        }
      """
    )
  
    // @LINE:5
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetasController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseIngredientesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getIngredienteNombre: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientesController.getIngredienteNombre",
      """
        function(nombre0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/search/nombre/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre0))})
        }
      """
    )
  
    // @LINE:22
    def updateIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientesController.updateIngrediente",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/"})
        }
      """
    )
  
    // @LINE:15
    def getIngredienteId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientesController.getIngredienteId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/search/id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
