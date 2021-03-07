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

public class RecetasController extends Controller {

    @Inject
    FormFactory formFactory;

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


        Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);
        ObjectNode res = Json.newObject();

        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        } else {

            Receta rAux = form.get(); //se crea una receta donde se recoge los datos de la request
            List<Ingrediente> ingredientes = rAux.getIngredientes(); //se copian a una lista los ingredientes de la request
            Usuario usuario = rAux.getUsuario();
            Descripcion descripcion = rAux.getDescripcion();
            Receta receta = new Receta(); //se crea nueva receta vacia donde se guardaran los datos bien compuestos

            //se añaden los atributos "unicos" al objeto vacio
            receta.setNombre(rAux.getNombre());
            receta.setTiempo(rAux.getTiempo());
            receta.setTipo(rAux.getTipo());

            if (Usuario.findByNombre(usuario.getNombre()) == null) { //no esta en la bd
                receta.setUsuario(rAux.getUsuario());
                usuario.save();
            } else { //está en la bd
                Usuario uAux = Usuario.findByNombre(usuario.getNombre());
                receta.setUsuario(uAux);
            }

            if (Descripcion.findByNombre(descripcion.getTexto()) == null) { //no esta en la bd
                receta.setDescripcion(rAux.getDescripcion());
                descripcion.save();
            } else { //está en la bd
                res.put("success", false).put("message", "La descripción ya existe en la BD, debe ser única.");
                return status(409).sendJson(res); //conflicto
            }

            for (Ingrediente ingrediente : ingredientes) { //se recorre la lista de ingredientes
                if (Ingrediente.findByNombre(ingrediente.getNombre()) == null) { //no existe en la bd
                    ingrediente.save();
                    receta.addIngrediente(ingrediente);
                } else { //si esta
                    Ingrediente iAux = Ingrediente.findByNombre(ingrediente.getNombre());
                    receta.addIngrediente(iAux);
                }
            }
            receta.save(); //se guarda la receta en la base de datos
        }


        res.put("success", true).put("message", "La receta ha sido añadida");

        return Results.ok(res);

    }

    public Result getRecetaNombre(Http.Request request, String nombre) {

        List<Receta> recetas = Receta.findByName(nombre);
        ObjectNode res = Json.newObject();

        if (recetas.isEmpty()) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }

        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getRecetaId(Http.Request request, Long id) {

        Receta receta = Receta.findById(id);
        ObjectNode res = Json.newObject();

        if (receta == null) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta));

        } else if (request.accepts("application/json")) {
            JsonNode node = toJson(receta);
            return ok(node);
        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getRecetaTiempo(Http.Request request, String tiempo) {

        List<Receta> recetas = Receta.findByTime(tiempo);
        ObjectNode res = Json.newObject();

        if (recetas.isEmpty()) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getRecetaTipo(Http.Request request, String tipo) {

        List<Receta> recetas = Receta.findByTipo(tipo);
        ObjectNode res = Json.newObject();

        if (recetas.isEmpty()) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }

        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getRecetaIngredienteId(Http.Request request, Long id) {

        Ingrediente ingrediente = Ingrediente.findById(id);
        ObjectNode res = Json.newObject();

        if (ingrediente == null) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        List<Receta> recetas = ingrediente.getRecetas();

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {
            JsonNode node = toJson(recetas);
            return ok(node);
        }

        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getRecetaUsuarioId(Http.Request request, Long id) {

        Usuario usuario = Usuario.findById(id);
        ObjectNode res = Json.newObject();

        if (usuario == null) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        List<Receta> recetas = usuario.getRecetas();

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {
            JsonNode node = toJson(recetas);
            return ok(node);
        }

        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getListaRecetas(Http.Request request) {

        List<Receta> recetas = Receta.findAll();
        ObjectNode res = Json.newObject();

        if (recetas.isEmpty()) {
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.recetas.render(recetas));

        } else if (request.accepts("application/json")) {

            JsonNode node = toJson(recetas);
            return ok(node);

        }

        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result deleteReceta(Long id) {

        Receta receta = Receta.findById(id);
        ObjectNode res = Json.newObject();

        if (receta == null) { //si no existe (la busqueda devolvio null)
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        } else {
            System.out.println("Receta " + id + " eliminada");
            receta.delete();
            res.put("success", true).put("message", "Receta eliminada correctamente.");
            return Results.ok(res);
        }

    }

    public Result updateReceta(Http.Request request) { //en el body es necesario pasarle la id de la receta original

        Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);
        ObjectNode res = Json.newObject();

        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        Receta rAux = form.get();
        if (rAux.getId() == null) {
            res.put("success", false).put("message", "Es necesario indicar el id de la receta");
            return status(409).sendJson(res); //conflicto
        }

        if (Receta.findById(rAux.getId()) == null) { //si no existe en la bd
            res.put("success", false).put("message", "Receta no encontrada");
            return status(404).sendJson(res); //not found
        }

        List<Ingrediente> ingredientes = rAux.getIngredientes();
        Usuario usuario = rAux.getUsuario();
        Descripcion descripcion = rAux.getDescripcion();
        Receta receta = new Receta();

        receta.setNombre(rAux.getNombre());
        receta.setTiempo(rAux.getTiempo());
        receta.setTipo(rAux.getTipo());

        if (Usuario.findByNombreE(usuario.getNombre()) != null) { //si el usuario que se quiere añadir está en la bd
            Usuario uAux = Usuario.findByNombreE(usuario.getNombre()); //se guarda
            usuario.setId(uAux.getId()); //se guarda la id
            receta.setUsuario(usuario); //se añade a la receta
        } else { //si no esta en la bd
            receta.setUsuario(usuario); //se añade a la receta
            usuario.save(); //se guarda
        }

        if (Descripcion.findByNombre(descripcion.getTexto()) != null) { //si la descripcion que se quiere añadir está en la bd
            Descripcion dAux = Descripcion.findByNombre(descripcion.getTexto());
            receta.setDescripcion(dAux);
        } else { //si no esta en la bd
            receta.setDescripcion(descripcion); //se añade a la receta
            descripcion.save(); //se guarda
        }

        for (Ingrediente ingrediente : ingredientes) {
            if (Ingrediente.findByNombre(ingrediente.getNombre()) != null) { //si el ingrediente que se quiere añadir está en la bd
                Ingrediente iAux = Ingrediente.findByNombre(ingrediente.getNombre()); //se guarda
                ingrediente.setId(iAux.getId()); //se guarda la id
                receta.addIngrediente(ingrediente); //se añade a la receta
            } else { //si no esta en la bd
                ingrediente.save(); //se guarda
                receta.addIngrediente(ingrediente); //se añade a la receta
            }
        }

        receta.setId(rAux.getId()); //se guarda id de receta
        receta.update(); //se actualiza receta
        return Results.ok(toJson(receta));
    }

}