// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/Usuario_App/conf/routes
// @DATE:Wed Jan 06 01:18:33 CET 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  RecetasController_0: controllers.RecetasController,
  // @LINE:14
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    RecetasController_0: controllers.RecetasController,
    // @LINE:14
    Assets_1: controllers.Assets
  ) = this(errorHandler, RecetasController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RecetasController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas""", """controllers.RecetasController.create(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/get""", """controllers.RecetasController.getReceta(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/list""", """controllers.RecetasController.getListaRecetas"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/update""", """controllers.RecetasController.updateReceta(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/delete""", """controllers.RecetasController.deleteReceta(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_RecetasController_create0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas")))
  )
  private[this] lazy val controllers_RecetasController_create0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """recetas""",
      """ An example controller showing a sample home page
POST    /recetas                   controllers.RecetasController.create(nombre: String, edad: Int)""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_RecetasController_getReceta1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/get")))
  )
  private[this] lazy val controllers_RecetasController_getReceta1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getReceta(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getReceta",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """recetas/get""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_RecetasController_getListaRecetas2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/list")))
  )
  private[this] lazy val controllers_RecetasController_getListaRecetas2_invoker = createInvoker(
    RecetasController_0.getListaRecetas,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getListaRecetas",
      Nil,
      "GET",
      this.prefix + """recetas/list""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_RecetasController_updateReceta3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/update")))
  )
  private[this] lazy val controllers_RecetasController_updateReceta3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.updateReceta(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "updateReceta",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """recetas/update""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_RecetasController_deleteReceta4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/delete")))
  )
  private[this] lazy val controllers_RecetasController_deleteReceta4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.deleteReceta(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "deleteReceta",
      Seq(classOf[play.mvc.Http.Request]),
      "DELETE",
      this.prefix + """recetas/delete""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_RecetasController_create0_route(params@_) =>
      call { 
        controllers_RecetasController_create0_invoker.call(
          req => RecetasController_0.create(req))
      }
  
    // @LINE:8
    case controllers_RecetasController_getReceta1_route(params@_) =>
      call { 
        controllers_RecetasController_getReceta1_invoker.call(
          req => RecetasController_0.getReceta(req))
      }
  
    // @LINE:9
    case controllers_RecetasController_getListaRecetas2_route(params@_) =>
      call { 
        controllers_RecetasController_getListaRecetas2_invoker.call(RecetasController_0.getListaRecetas)
      }
  
    // @LINE:10
    case controllers_RecetasController_updateReceta3_route(params@_) =>
      call { 
        controllers_RecetasController_updateReceta3_invoker.call(
          req => RecetasController_0.updateReceta(req))
      }
  
    // @LINE:11
    case controllers_RecetasController_deleteReceta4_route(params@_) =>
      call { 
        controllers_RecetasController_deleteReceta4_invoker.call(
          req => RecetasController_0.deleteReceta(req))
      }
  
    // @LINE:14
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
