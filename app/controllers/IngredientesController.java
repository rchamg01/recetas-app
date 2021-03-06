package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Ingrediente;
import models.Receta;
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

public class IngredientesController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result getIngredienteId(Http.Request request, Long id) {

        Ingrediente ingrediente = Ingrediente.findById(id);

        if(ingrediente == null) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.ingrediente.render(ingrediente));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(ingrediente);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }

    public Result getIngredienteNombre(Http.Request request, String nombre) {

        List<Ingrediente> ingredientes = Ingrediente.findListaByNombre(nombre);

        if(ingredientes.isEmpty()) {
            return status(404); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.ingredientes.render(ingredientes));

        }else if (request.accepts("application/json")) {

            JsonNode node = ingredientesToJson(ingredientes);
            return ok(node);

        }
        return Results.status(415); //Unsupported Media Type

    }

    public Result updateIngrediente(Http.Request request) { //en el body es necesario pasarle la id de la receta original

        Form<Ingrediente> form = formFactory.form(Ingrediente.class).bindFromRequest(request);

        if(form.hasErrors()){
            return Results.badRequest(form.errorsAsJson());
        }

        Ingrediente ingrediente = form.get();
        if(ingrediente.getId() == null){
            return Results.status(409);
        }

        if(Ingrediente.findById(ingrediente.getId()) == null){ //si no existe en la bd
            return Results.status(404);
        }

        ingrediente.update(); //se actualiza ingrdiente
        return ok(toJson(ingrediente));

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

}

