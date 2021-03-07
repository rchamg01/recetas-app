package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Ingrediente;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;

public class IngredientesController extends Controller {

    @Inject
    FormFactory formFactory;

    public static JsonNode toJson(Ingrediente ingrediente) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode ingredienteNode = mapper.valueToTree(ingrediente);
        return mapper.createObjectNode().set("ingrediente", ingredienteNode);
    }

    public static JsonNode ingredientesToJson(List<Ingrediente> ingredientes) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = Json.newObject();
        ArrayNode ingredientesNode = mapper.valueToTree(ingredientes);
        result.putArray("ingredientes").addAll(ingredientesNode);
        return result;
    }

    public Result getIngredienteId(Http.Request request, Long id) {

        Ingrediente ingrediente = Ingrediente.findById(id);
        ObjectNode res = Json.newObject();

        if (ingrediente == null) {
            res.put("success", false).put("message", "Ingrediente no encontrado");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.ingrediente.render(ingrediente));

        } else if (request.accepts("application/json")) {

            JsonNode node = toJson(ingrediente);
            return ok(node);

        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getIngredienteNombre(Http.Request request, String nombre) {

        List<Ingrediente> ingredientes = Ingrediente.findListaByNombre(nombre);
        ObjectNode res = Json.newObject();

        if (ingredientes.isEmpty()) {
            res.put("success", false).put("message", "Ingrediente no encontrado");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.ingredientes.render(ingredientes));

        } else if (request.accepts("application/json")) {

            JsonNode node = ingredientesToJson(ingredientes);
            return ok(node);

        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result updateIngrediente(Http.Request request) { //en el body es necesario pasarle la id del ingrediente original

        Form<Ingrediente> form = formFactory.form(Ingrediente.class).bindFromRequest(request);
        ObjectNode res = Json.newObject();

        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        Ingrediente ingrediente = form.get();
        if (ingrediente.getId() == null) {
            res.put("success", false).put("message", "Es necesario indicar el id del ingrediente");
            return status(409).sendJson(res); //conflicto
        }

        if (Ingrediente.findById(ingrediente.getId()) == null) { //si no existe en la bd
            res.put("success", false).put("message", "Ingrediente no encontrado");
            return status(404).sendJson(res); //not found
        }

        ingrediente.update(); //se actualiza ingrediente
        return ok(toJson(ingrediente));

    }

}

