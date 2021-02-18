// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Wed Feb 17 17:47:29 CET 2021

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
  // @LINE:20
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    RecetasController_0: controllers.RecetasController,
    // @LINE:20
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/tipo/""" + "$" + """tipo<[^/]+>""", """controllers.RecetasController.getRecetaTipo(request:Request, tipo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/tiempo/""" + "$" + """tiempo<[^/]+>""", """controllers.RecetasController.getRecetaTiempo(request:Request, tiempo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/nombre/""" + "$" + """nombre<[^/]+>""", """controllers.RecetasController.getRecetaNombre(request:Request, nombre:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/id/""" + "$" + """id<[^/]+>""", """controllers.RecetasController.getRecetaId(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/list""", """controllers.RecetasController.getListaRecetas(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""", """controllers.RecetasController.updateReceta"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""" + "$" + """id<[^/]+>""", """controllers.RecetasController.deleteReceta(id:Long)"""),
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
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_RecetasController_getRecetaTipo1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/tipo/"), DynamicPart("tipo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaTipo1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaTipo(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaTipo",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/search/tipo/""" + "$" + """tipo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_RecetasController_getRecetaTiempo2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/tiempo/"), DynamicPart("tiempo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaTiempo2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaTiempo(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaTiempo",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/search/tiempo/""" + "$" + """tiempo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_RecetasController_getRecetaNombre3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/nombre/"), DynamicPart("nombre", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaNombre3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaNombre(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaNombre",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/search/nombre/""" + "$" + """nombre<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_RecetasController_getRecetaId4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaId4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaId(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaId",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """recetas/search/id/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_RecetasController_getListaRecetas5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/list")))
  )
  private[this] lazy val controllers_RecetasController_getListaRecetas5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getListaRecetas(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getListaRecetas",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """recetas/list""",
      """falta hacer get recetas con x ingrediente""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_RecetasController_updateReceta6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/")))
  )
  private[this] lazy val controllers_RecetasController_updateReceta6_invoker = createInvoker(
    RecetasController_0.updateReceta,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "updateReceta",
      Nil,
      "PUT",
      this.prefix + """recetas/""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_RecetasController_deleteReceta7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_deleteReceta7_invoker = createInvoker(
    RecetasController_0.deleteReceta(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "deleteReceta",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """recetas/""" + "$" + """id<[^/]+>""",
      """falta hacer put de ingrediente""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
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
    case controllers_RecetasController_getRecetaTipo1_route(params@_) =>
      call(params.fromPath[String]("tipo", None)) { (tipo) =>
        controllers_RecetasController_getRecetaTipo1_invoker.call(
          req => RecetasController_0.getRecetaTipo(req, tipo))
      }
  
    // @LINE:9
    case controllers_RecetasController_getRecetaTiempo2_route(params@_) =>
      call(params.fromPath[String]("tiempo", None)) { (tiempo) =>
        controllers_RecetasController_getRecetaTiempo2_invoker.call(
          req => RecetasController_0.getRecetaTiempo(req, tiempo))
      }
  
    // @LINE:10
    case controllers_RecetasController_getRecetaNombre3_route(params@_) =>
      call(params.fromPath[String]("nombre", None)) { (nombre) =>
        controllers_RecetasController_getRecetaNombre3_invoker.call(
          req => RecetasController_0.getRecetaNombre(req, nombre))
      }
  
    // @LINE:11
    case controllers_RecetasController_getRecetaId4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_getRecetaId4_invoker.call(
          req => RecetasController_0.getRecetaId(req, id))
      }
  
    // @LINE:13
    case controllers_RecetasController_getListaRecetas5_route(params@_) =>
      call { 
        controllers_RecetasController_getListaRecetas5_invoker.call(
          req => RecetasController_0.getListaRecetas(req))
      }
  
    // @LINE:14
    case controllers_RecetasController_updateReceta6_route(params@_) =>
      call { 
        controllers_RecetasController_updateReceta6_invoker.call(RecetasController_0.updateReceta)
      }
  
    // @LINE:16
    case controllers_RecetasController_deleteReceta7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_deleteReceta7_invoker.call(RecetasController_0.deleteReceta(id))
      }
  
    // @LINE:20
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
