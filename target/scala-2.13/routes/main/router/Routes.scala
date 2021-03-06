// @GENERATOR:play-routes-compiler
// @SOURCE:E:/universidad/MASTER/cloud/recetas-app/conf/routes
// @DATE:Sat Mar 06 01:21:08 CET 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  RecetasController_0: controllers.RecetasController,
  // @LINE:15
  IngredientesController_1: controllers.IngredientesController,
  // @LINE:18
  UsuariosController_4: controllers.UsuariosController,
  // @LINE:24
  DescripcionController_3: controllers.DescripcionController,
  // @LINE:30
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    RecetasController_0: controllers.RecetasController,
    // @LINE:15
    IngredientesController_1: controllers.IngredientesController,
    // @LINE:18
    UsuariosController_4: controllers.UsuariosController,
    // @LINE:24
    DescripcionController_3: controllers.DescripcionController,
    // @LINE:30
    Assets_2: controllers.Assets
  ) = this(errorHandler, RecetasController_0, IngredientesController_1, UsuariosController_4, DescripcionController_3, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RecetasController_0, IngredientesController_1, UsuariosController_4, DescripcionController_3, Assets_2, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/ingrediente/id/""" + "$" + """id<[^/]+>""", """controllers.RecetasController.getRecetaIngredienteId(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/search/usuario/id/""" + "$" + """id<[^/]+>""", """controllers.RecetasController.getRecetaUsuarioId(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/list""", """controllers.RecetasController.getListaRecetas(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes/search/id/""" + "$" + """id<[^/]+>""", """controllers.IngredientesController.getIngredienteId(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes/search/nombre/""" + "$" + """nombre<[^/]+>""", """controllers.IngredientesController.getIngredienteNombre(request:Request, nombre:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios/search/id/""" + "$" + """id<[^/]+>""", """controllers.UsuariosController.getUsuarioId(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios/search/nombre/""" + "$" + """nombre<[^/]+>""", """controllers.UsuariosController.getUsuarioNombre(request:Request, nombre:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""", """controllers.RecetasController.updateReceta(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes/""", """controllers.IngredientesController.updateIngrediente(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios/""", """controllers.UsuariosController.updateUsuario(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """descripcion/""", """controllers.DescripcionController.updateDescripcion(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""" + "$" + """id<[^/]+>""", """controllers.RecetasController.deleteReceta(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
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

  // @LINE:7
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

  // @LINE:8
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

  // @LINE:9
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

  // @LINE:10
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

  // @LINE:11
  private[this] lazy val controllers_RecetasController_getRecetaIngredienteId5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/ingrediente/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaIngredienteId5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaIngredienteId(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaIngredienteId",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """recetas/search/ingrediente/id/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_RecetasController_getRecetaUsuarioId6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/search/usuario/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_getRecetaUsuarioId6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getRecetaUsuarioId(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getRecetaUsuarioId",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """recetas/search/usuario/id/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_RecetasController_getListaRecetas7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/list")))
  )
  private[this] lazy val controllers_RecetasController_getListaRecetas7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.getListaRecetas(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "getListaRecetas",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """recetas/list""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_IngredientesController_getIngredienteId8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes/search/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientesController_getIngredienteId8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientesController_1.getIngredienteId(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientesController",
      "getIngredienteId",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """ingredientes/search/id/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_IngredientesController_getIngredienteNombre9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes/search/nombre/"), DynamicPart("nombre", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientesController_getIngredienteNombre9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientesController_1.getIngredienteNombre(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientesController",
      "getIngredienteNombre",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """ingredientes/search/nombre/""" + "$" + """nombre<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UsuariosController_getUsuarioId10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuarios/search/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuariosController_getUsuarioId10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UsuariosController_4.getUsuarioId(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuariosController",
      "getUsuarioId",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """usuarios/search/id/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UsuariosController_getUsuarioNombre11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuarios/search/nombre/"), DynamicPart("nombre", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuariosController_getUsuarioNombre11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UsuariosController_4.getUsuarioNombre(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuariosController",
      "getUsuarioNombre",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """usuarios/search/nombre/""" + "$" + """nombre<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_RecetasController_updateReceta12_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/")))
  )
  private[this] lazy val controllers_RecetasController_updateReceta12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecetasController_0.updateReceta(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "updateReceta",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """recetas/""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_IngredientesController_updateIngrediente13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes/")))
  )
  private[this] lazy val controllers_IngredientesController_updateIngrediente13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientesController_1.updateIngrediente(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientesController",
      "updateIngrediente",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """ingredientes/""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UsuariosController_updateUsuario14_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuarios/")))
  )
  private[this] lazy val controllers_UsuariosController_updateUsuario14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UsuariosController_4.updateUsuario(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuariosController",
      "updateUsuario",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """usuarios/""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_DescripcionController_updateDescripcion15_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("descripcion/")))
  )
  private[this] lazy val controllers_DescripcionController_updateDescripcion15_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DescripcionController_3.updateDescripcion(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DescripcionController",
      "updateDescripcion",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """descripcion/""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_RecetasController_deleteReceta16_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetasController_deleteReceta16_invoker = createInvoker(
    RecetasController_0.deleteReceta(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetasController",
      "deleteReceta",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """recetas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned17_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
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
  
    // @LINE:5
    case controllers_RecetasController_create0_route(params@_) =>
      call { 
        controllers_RecetasController_create0_invoker.call(
          req => RecetasController_0.create(req))
      }
  
    // @LINE:7
    case controllers_RecetasController_getRecetaTipo1_route(params@_) =>
      call(params.fromPath[String]("tipo", None)) { (tipo) =>
        controllers_RecetasController_getRecetaTipo1_invoker.call(
          req => RecetasController_0.getRecetaTipo(req, tipo))
      }
  
    // @LINE:8
    case controllers_RecetasController_getRecetaTiempo2_route(params@_) =>
      call(params.fromPath[String]("tiempo", None)) { (tiempo) =>
        controllers_RecetasController_getRecetaTiempo2_invoker.call(
          req => RecetasController_0.getRecetaTiempo(req, tiempo))
      }
  
    // @LINE:9
    case controllers_RecetasController_getRecetaNombre3_route(params@_) =>
      call(params.fromPath[String]("nombre", None)) { (nombre) =>
        controllers_RecetasController_getRecetaNombre3_invoker.call(
          req => RecetasController_0.getRecetaNombre(req, nombre))
      }
  
    // @LINE:10
    case controllers_RecetasController_getRecetaId4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_getRecetaId4_invoker.call(
          req => RecetasController_0.getRecetaId(req, id))
      }
  
    // @LINE:11
    case controllers_RecetasController_getRecetaIngredienteId5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_getRecetaIngredienteId5_invoker.call(
          req => RecetasController_0.getRecetaIngredienteId(req, id))
      }
  
    // @LINE:12
    case controllers_RecetasController_getRecetaUsuarioId6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_getRecetaUsuarioId6_invoker.call(
          req => RecetasController_0.getRecetaUsuarioId(req, id))
      }
  
    // @LINE:13
    case controllers_RecetasController_getListaRecetas7_route(params@_) =>
      call { 
        controllers_RecetasController_getListaRecetas7_invoker.call(
          req => RecetasController_0.getListaRecetas(req))
      }
  
    // @LINE:15
    case controllers_IngredientesController_getIngredienteId8_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_IngredientesController_getIngredienteId8_invoker.call(
          req => IngredientesController_1.getIngredienteId(req, id))
      }
  
    // @LINE:16
    case controllers_IngredientesController_getIngredienteNombre9_route(params@_) =>
      call(params.fromPath[String]("nombre", None)) { (nombre) =>
        controllers_IngredientesController_getIngredienteNombre9_invoker.call(
          req => IngredientesController_1.getIngredienteNombre(req, nombre))
      }
  
    // @LINE:18
    case controllers_UsuariosController_getUsuarioId10_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsuariosController_getUsuarioId10_invoker.call(
          req => UsuariosController_4.getUsuarioId(req, id))
      }
  
    // @LINE:19
    case controllers_UsuariosController_getUsuarioNombre11_route(params@_) =>
      call(params.fromPath[String]("nombre", None)) { (nombre) =>
        controllers_UsuariosController_getUsuarioNombre11_invoker.call(
          req => UsuariosController_4.getUsuarioNombre(req, nombre))
      }
  
    // @LINE:21
    case controllers_RecetasController_updateReceta12_route(params@_) =>
      call { 
        controllers_RecetasController_updateReceta12_invoker.call(
          req => RecetasController_0.updateReceta(req))
      }
  
    // @LINE:22
    case controllers_IngredientesController_updateIngrediente13_route(params@_) =>
      call { 
        controllers_IngredientesController_updateIngrediente13_invoker.call(
          req => IngredientesController_1.updateIngrediente(req))
      }
  
    // @LINE:23
    case controllers_UsuariosController_updateUsuario14_route(params@_) =>
      call { 
        controllers_UsuariosController_updateUsuario14_invoker.call(
          req => UsuariosController_4.updateUsuario(req))
      }
  
    // @LINE:24
    case controllers_DescripcionController_updateDescripcion15_route(params@_) =>
      call { 
        controllers_DescripcionController_updateDescripcion15_invoker.call(
          req => DescripcionController_3.updateDescripcion(req))
      }
  
    // @LINE:26
    case controllers_RecetasController_deleteReceta16_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetasController_deleteReceta16_invoker.call(RecetasController_0.deleteReceta(id))
      }
  
    // @LINE:30
    case controllers_Assets_versioned17_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned17_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
