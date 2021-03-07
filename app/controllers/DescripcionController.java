package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Descripcion;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;

public class DescripcionController extends Controller {

    @Inject
    FormFactory formFactory;

    public static JsonNode toJson(Descripcion descripcion) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode descNode = mapper.valueToTree(descripcion);
        return mapper.createObjectNode().set("descripcion", descNode);
    }

    public Result updateDescripcion(Http.Request request) {

        Form<Descripcion> form = formFactory.form(Descripcion.class).bindFromRequest(request);
        ObjectNode res = Json.newObject();

        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        Descripcion descripcion = form.get();
        if (descripcion.getId() == null) {
            res.put("success", false).put("message", "Es necesario indicar el id de la descripción");
            return status(409).sendJson(res); //conflicto
        }

        if (Descripcion.findById(descripcion.getId()) == null) { //si no existe en la bd
            res.put("success", false).put("message", "Descripción no encontrada");
            return status(404).sendJson(res); //conflicto
        }

        descripcion.update(); //se actualiza descripcion
        return ok(toJson(descripcion));

    }

}