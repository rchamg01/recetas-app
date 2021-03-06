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

public class DescripcionController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result updateDescripcion(Http.Request request) { //en el body es necesario pasarle la id de la receta original

        Form<Descripcion> form = formFactory.form(Descripcion.class).bindFromRequest(request);

        if(form.hasErrors()){
            return Results.badRequest(form.errorsAsJson());
        }

        Descripcion descripcion = form.get();
        if(descripcion.getId() == null){
            return Results.status(409);
        }

        if(Descripcion.findById(descripcion.getId()) == null){ //si no existe en la bd
            return Results.status(404);
        }

        descripcion.update(); //se actualiza ingrdiente
        return ok(toJson(descripcion));

    }

    public static JsonNode toJson(Descripcion descripcion) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode descNode = mapper.valueToTree(descripcion);
        return mapper.createObjectNode().set("descripcion", descNode);
    }

}