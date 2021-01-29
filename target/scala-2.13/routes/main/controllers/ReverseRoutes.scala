// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Thu Jan 28 18:57:09 CET 2021

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
    def updateReceta(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "recetas/update")
    }
  
    // @LINE:11
    def deleteReceta(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "recetas/delete")
    }
  
    // @LINE:8
    def getReceta(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/get")
    }
  
    // @LINE:7
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recetas")
    }
  
    // @LINE:9
    def getListaRecetas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/list")
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
