// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sat Mar 06 01:21:08 CET 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:30
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:18
  class ReverseUsuariosController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getUsuarioId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "usuarios/search/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:23
    def updateUsuario(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "usuarios/")
    }
  
    // @LINE:19
    def getUsuarioNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "usuarios/search/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
  }

  // @LINE:24
  class ReverseDescripcionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def updateDescripcion(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "descripcion/")
    }
  
  }

  // @LINE:5
  class ReverseRecetasController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getRecetaIngredienteId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/ingrediente/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:9
    def getRecetaNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:13
    def getListaRecetas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/list")
    }
  
    // @LINE:21
    def updateReceta(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "recetas/")
    }
  
    // @LINE:10
    def getRecetaId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:26
    def deleteReceta(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:12
    def getRecetaUsuarioId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/usuario/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:8
    def getRecetaTiempo(tiempo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/tiempo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tiempo", tiempo)))
    }
  
    // @LINE:7
    def getRecetaTipo(tipo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/tipo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tipo", tipo)))
    }
  
    // @LINE:5
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recetas")
    }
  
  }

  // @LINE:15
  class ReverseIngredientesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getIngredienteNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes/search/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:22
    def updateIngrediente(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ingredientes/")
    }
  
    // @LINE:15
    def getIngredienteId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes/search/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
