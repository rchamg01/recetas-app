package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Descripcion;
import models.Ingrediente;
import models.Receta;
import models.Usuario;

import play.data.Form;
import play.data.FormFactory;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

public class RecetasController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result create(Http.Request request) {

        /* ----JSON------

        {
            "nombre": "Cocido de garbanzos",
            "tiempo": "45",
            "tipo": "omnivoro",
            "usuario": {"nombre": "Raquel Ch"},
            "descripcion": {"texto": "Delicioso cocido de garbanzos madrileño con carne y sopa"},
            "ingredientes": [
                {"nombre": "garbanzos"},
                {"nombre": "carne"},
                {"nombre": "patata"},
                {"nombre": "zanahoria"}
            ]
        }

        */

            Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);

            if(form.hasErrors()){
                return Results.badRequest(form.errorsAsJson());
            } else {

                Receta rAux = form.get(); //se crea una receta donde se recoge los datos de la request
                List<Ingrediente> iAux = rAux.getIngredientes(); //se copian a una lista los ingredientes de la request
                Usuario usuario = rAux.getUsuario();
                Descripcion descripcion = rAux.getDescripcion();
                Receta rf = new Receta(); //se crea nueva receta vacia donde se guardaran los datos bien compuestos

                //se añaden los atributos "unicos" al objeto vacio
                rf.setNombre(rAux.getNombre());
                rf.setTiempo(rAux.getTiempo());
                rf.setTipo(rAux.getTipo());

                if(Usuario.findByNombre(usuario.getNombre()) == null){ //no esta en la bd
                    rf.setUsuario(rAux.getUsuario());
                    usuario.save();
                }else{ //está en la bd
                    Usuario uAux = Usuario.findByNombre(usuario.getNombre());
                    rf.setUsuario(uAux);
                }

                rf.setDescripcion(rAux.getDescripcion());
                descripcion.save();

                for(Ingrediente ingrediente: iAux){
                    if(Ingrediente.findByNombre(ingrediente.getNombre()) == null){ //no existe en la bd
                        ingrediente.save();
                        rf.addIngrediente(ingrediente);
                    }else{ //si esta
                        Ingrediente ingredienteAux = Ingrediente.findByNombre(ingrediente.getNombre());
                        rf.addIngrediente(ingredienteAux);
                    }
                }
                rf.save(); //se guarda la receta en la base de datos
            }

            return Results.ok();
        /*
        *
        *
        <?xml version="1.0" encoding="UTF-8" standalone="no" ?>
        <recetas>
            <receta>
                <nombre>Cocido de garbanzos</nombre>
                <tipo>omnivoro</tipo>
                <tiempo>45</tiempo>
                <usuario>
                    <nombre>Raquel Ch</nombre>
                </usuario>
                <descripcion>
                    <texto>Delicioso cocido de garbanzos madrileño con carne, verduras y sopa de fideos.</texto>
                </descripcion>
                <ingredientes>
                    <ingrediente>
                        <nombre>garbanzos</nombre>
                    </ingrediente>
                    <ingrediente>
                        <nombre>carne</nombre>
                    </ingrediente>
                    <ingrediente>
                        <nombre>patatas</nombre>
                    </ingrediente>
                </ingredientes>
            </receta>
        </recetas>
        *
        * */

        /////////////////////////////////////// IGNORAR: SON APUNTES ////////////////////////////////////////////////7

            //String res ="{\"success\": true, \"message\": \"El usuario ha sido añadido\"}"; //forma rudimentara e incorrecta de crear una respuesta json

            /*ObjectNode node = Json.newObject(); // {} forma adecuada pero no mejor de crear un objeto json de respuesta
            node.put("success", true);
            node.put("message", "La receta ha sido añadida");*/

           /* RespuestaCreacionUsuario res = new RespuestaCreacionUsuario(); //buena forma
            res.setMessage("La receta ha sido creada");
            res.setSuccess(true);
            JsonNode json = Json.toJson(res);*/


    }

    //terminado (no detecta usuario en json)
    public Result getRecetaNombre(Http.Request request, String nombre) {

        List<Receta> recetas = Receta.findByName(nombre);

        if(recetas.isEmpty()) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }

    //terminado
    public Result getRecetaId(Http.Request request, Long id) {

        Receta receta = Receta.findById(id);

        if(receta == null) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta));

        }else if (request.accepts("application/json")) {
            JsonNode node = toJson(receta);
            return ok(node);
        }
        return Results.status(415); //Unsupported Media Type

    }

    //terminado
    public Result getRecetaTiempo(Http.Request request, String tiempo) {

        List<Receta> recetas = Receta.findByTime(tiempo);

        if(recetas.isEmpty()) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }
    //terminado
    public Result getRecetaTipo(Http.Request request, String tipo) {

        List<Receta> recetas = Receta.findByTipo(tipo);

        if(recetas.isEmpty()) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }

    //terminado
    public Result getRecetaIngredienteId(Http.Request request, Long id) {

        Ingrediente ingrediente = Ingrediente.findById(id);

        if(ingrediente == null) {
            return status(404); //not found
        }

        List<Receta> recetas = ingrediente.getRecetas();

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {
            JsonNode node = toJson(recetas);
            return ok(node);
        }
        return Results.status(415); //Unsupported Media Type

    }

    //terminado
    public Result getRecetaUsuarioId(Http.Request request, Long id) {

        Usuario usuario = Usuario.findById(id);

        if(usuario == null) {
            return status(404); //not found
        }

        List<Receta> recetas = usuario.getRecetas();

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {
            JsonNode node = toJson(recetas);
            return ok(node);
        }
        return Results.status(415); //Unsupported Media Type

    }

    //terminado
    public Result getListaRecetas(Http.Request request) {

        List<Receta> recetas = Receta.findAll();

        if(recetas.isEmpty()) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }

    public Result deleteReceta(Long id) {

        Receta receta = Receta.findById(id);

        if (receta == null) { //si no existe (la busqueda devolvio null)
            return Results.status(404); //not found
        }else{
            System.out.println("Receta " + id + " eliminada");
            receta.delete();
            return Results.ok();
        }

    }

    //error en la respuesta json
    public Result updateReceta(Http.Request request) { //en el body es necesario pasarle la id de la receta original

        Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);

        if(form.hasErrors()){
            return Results.badRequest(form.errorsAsJson());
        }

        Receta rAux = form.get();
        if(rAux.getId() == null){
            return Results.status(409);
        }

        if(Receta.findById(rAux.getId()) == null){ //si no existe en la bd
            return Results.status(404);
        }

        List<Ingrediente> ingredientes = rAux.getIngredientes();
        Usuario usuario = rAux.getUsuario();
        Receta rf =  new Receta();

        rf.setNombre(rAux.getNombre());
        rf.setTiempo(rAux.getTiempo());
        rf.setTipo(rAux.getTipo());

        if(Usuario.findByNombre(usuario.getNombre()) != null){ //si el usuario que se quiere añadir está en la bd
            Usuario uAux = Usuario.findByNombre(usuario.getNombre()); //se guarda
            usuario.setId(uAux.getId()); //se guarda la id
            rf.setUsuario(usuario); //se añade a la receta
        }else{ //si no esta en la bd
            rf.setUsuario(usuario); //se añade a la receta
            usuario.save(); //se guarda
        }

        for(Ingrediente ingrediente: ingredientes){
            if(Ingrediente.findByNombre(ingrediente.getNombre()) != null){ //si el ingrediente que se quiere añadir está en la bd

                Ingrediente iAux = Ingrediente.findByNombre(ingrediente.getNombre()); //se guarda
                ingrediente.setId(iAux.getId()); //se guarda la id
                rf.addIngrediente(ingrediente); //se añade a la receta
            }else{ //si no esta en la bd
                rf.addIngrediente(ingrediente); //se añade a la receta
                ingrediente.save(); //se guarda
            }
        }

        rf.setId(rAux.getId()); //se guarda id de receta
        rf.update(); //se actualiza receta
        return Results.ok(toJson(rf));
    }

    public static JsonNode toJson(Receta receta) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode recetaNode = mapper.valueToTree(receta);
        return mapper.createObjectNode().set("receta", recetaNode);
    }

    public static JsonNode toJson(List<Receta> recetas) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = Json.newObject();
        ArrayNode recetasNode = mapper.valueToTree(recetas);
        result.putArray("recetas").addAll(recetasNode);
        return result;
    }

}

class RespuestaCreacionUsuario {
    //@JsonProperty("is_success") //para que aparezca otro nombre en vez de success
    private boolean success;

    //@JsonIgnore para ignorar atributos
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}