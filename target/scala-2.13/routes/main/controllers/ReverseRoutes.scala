// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sat Feb 20 01:41:47 CET 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseRecetasController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getRecetaNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:14
    def getListaRecetas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/list")
    }
  
    // @LINE:17
    def updateReceta(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "recetas/")
    }
  
    // @LINE:11
    def getRecetaId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:16
    def getIngredienteNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes/search/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:18
    def updateIngrediente(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ingredientes/")
    }
  
    // @LINE:19
    def deleteReceta(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:9
    def getRecetaTiempo(tiempo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/tiempo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tiempo", tiempo)))
    }
  
    // @LINE:8
    def getRecetaTipo(tipo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/search/tipo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tipo", tipo)))
    }
  
    // @LINE:7
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recetas")
    }
  
    // @LINE:15
    def getIngredienteId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes/search/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:23
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
