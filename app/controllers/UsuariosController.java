package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

public class UsuariosController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result getUsuarioNombre(Http.Request request, String nombre) {

        List<Usuario> usuarios = Usuario.findListaByNombre(nombre);
        ObjectNode res = Json.newObject();

        if(usuarios.isEmpty()) {
            res.put("success", false).put("message", "Usuario no encontrado");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml.usuarios.render(usuarios));

        }else if (request.accepts("application/json")) {

            JsonNode node = usuariosToJson(usuarios);
            return ok(node);

        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result getUsuarioId(Http.Request request, Long id) {

        Usuario usuario = Usuario.findById(id);
        ObjectNode res = Json.newObject();

        if(usuario == null) {
            res.put("success", false).put("message", "Usuario no encontrado");
            return status(404).sendJson(res); //not found
        }

        if (request.accepts("application/xml")) {

            return ok(views.xml._usuario.render(usuario));

        }else if (request.accepts("application/json")) {

            JsonNode node = toJson(usuario);
            return ok(node);

        }
        res.put("success", false).put("message", "Formato de respuesta no soportado.");
        return Results.status(415).sendJson(res); //Unsupported Media Type

    }

    public Result updateUsuario(Http.Request request) { //en el body es necesario pasarle la id de la receta original

        Form<Usuario> form = formFactory.form(Usuario.class).bindFromRequest(request);
        ObjectNode res = Json.newObject();

        if(form.hasErrors()){
            return Results.badRequest(form.errorsAsJson());
        }

        Usuario usuario = form.get();
        if(usuario.getId() == null){
            res.put("success", false).put("message", "Es necesario indicar el id del usuario");
            return status(409).sendJson(res); //conflicto
        }

        if(Usuario.findById(usuario.getId()) == null){ //si no existe en la bd
            res.put("success", false).put("message", "Usuario no encontrado");
            return status(404).sendJson(res); //not found
        }

        usuario.update(); //se actualiza usuario
        return ok(toJson(usuario));

    }

    public static JsonNode toJson(Usuario usuario) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode usuarioNode = mapper.valueToTree(usuario);
        return mapper.createObjectNode().set("usuario", usuarioNode);
    }

    public static JsonNode usuariosToJson(List<Usuario> usuarios) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = Json.newObject();
        ArrayNode usuariosNode = mapper.valueToTree(usuarios);
        result.putArray("usuarios").addAll(usuariosNode);
        return result;
    }


}
