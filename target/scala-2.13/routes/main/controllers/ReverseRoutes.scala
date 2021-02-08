// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Mon Feb 08 18:28:58 CET 2021

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
    def getRecetaId(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:16
    def deleteIngrediente(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ingredientes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:13
    def updateReceta(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "recetas/")
    }
  
    // @LINE:15
    def deleteReceta(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:9
    def getRecetaNombre(nombre:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/nombre/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:8
    def getRecetaTipo(tipo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/tipo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tipo", tipo)))
    }
  
    // @LINE:7
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recetas")
    }
  
    // @LINE:12
    def getListaRecetas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/list")
    }
  
  }

  // @LINE:19
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
