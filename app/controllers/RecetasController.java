package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Ingrediente;
import models.Receta;
import org.w3c.dom.Document;

import play.data.Form;
import play.data.FormFactory;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.twirl.api.Content;
import views.xml.receta;
import views.xml.recetas;

import javax.inject.Inject;
import javax.swing.text.AbstractDocument;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class RecetasController extends Controller {

    @Inject
    FormFactory formFactory;

    //metodo funciona si no se utiliza el findbyId en la busqueda de ingredientes
    public Result create(Http.Request request) {

        //Optional<String> contenido = request.contentType();
        /* ----JSON------
        [
            {
                "nombre": "Cocido de garbanzos",
                "tiempo": "45",
                "ingredientes": [
                    {"nombre": "garbanzos"},
                    {"nombre": "carne"},
                    {"nombre": "patata"},
                    {"nombre": "zanahoria"}
                ]
            }
        ]
        */

            Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);

            System.out.println(form.rawData());

            if(form.hasErrors()){
                return Results.badRequest(form.errorsAsJson());
            } else {

                Receta rAux = form.get(); //se crea una receta donde se recoge los datos de la request
                List<Ingrediente> iAux = rAux.getIngredientes(); //se copian a una lista los ingredientes de la request

                Receta rf = new Receta(); //se crea nueva receta vacia donde se guardaran los datos bien compuestos

                //se añaden los atributos "unicos" al objeto vacio
                rf.setNombre(rAux.getNombre());
                System.out.println("nombre rec: "+ rf.getNombre());
                rf.setTiempo(rAux.getTiempo());
                System.out.println("tiempo: "+ rf.getTiempo());
                rf.setTipo(rAux.getTipo());
                System.out.println("tipo: "+ rf.getTipo());


                for(Ingrediente ingrediente: iAux){
                    System.out.println("id: "+ingrediente.getId()); //sale nulo siempre con id???
                    if(Ingrediente.findByNombre(ingrediente.getNombre()) == null){ //no existe en la bd //con getId no funciona, da null pointer exception
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


            /*JsonNode requestBodyJSON = request.body().asJson(); //para pedirlo en formato json
            System.out.println(contenido);
            Receta r = new Receta();
            //HELPFUL EXAMPLE: https://mkyong.com/java/jackson-tree-model-example/
            for (JsonNode root : requestBodyJSON) {
                String nombre = root.path("nombre").asText();
                int tiempo = root.path("tiempo").asInt();
                //para saber si esta repetida la receta
                for (int i = 0; i < Receta.listaRecetas.size(); i++) {
                    if(Receta.listaRecetas.get(i).getNombre().equals(nombre)){
                        return Results.badRequest("La receta a añadir ya existe en la base de datos");
                    }
                }
                System.out.println("Nombre receta : " + nombre);
                r.setNombre(nombre);
                System.out.println("Tiempo de preparación (min): " + tiempo);
                r.setTiempoPreparacion(tiempo);*/
                // Get Name
           /* JsonNode nameNode = root.path("name");
            if (!nameNode.isMissingNode()) {        // if "name" node is exist
                System.out.println("firstName : " + nameNode.path("first").asText());
                System.out.println("middleName : " + nameNode.path("middle").asText());
                System.out.println("lastName : " + nameNode.path("last").asText());
            }*/
                /*JsonNode ingredienteNode = root.path("ingredientes");
                for (JsonNode node : ingredienteNode) {
                    String ingrediente = node.path("ingrediente").asText();
                    r.addIngrediente(ingrediente);
                    System.out.println("Ingrediente : " + ingrediente);
                }
            }

        /*
        *
        *
        <?xml version="1.0" encoding="UTF-8" standalone="no" ?>
        <recetas>
            <receta>
                <nombre>Cocido de garbanzos</nombre>
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

            //Content content = recetas.render(Receta.listaRecetas); YA FUNCIONA (PARECE)

            //String res ="{\"success\": true, \"message\": \"El usuario ha sido añadido\"}"; //forma rudimentara e incorrecta de crear una respuesta json

            /*ObjectNode node = Json.newObject(); // {} forma adecuada pero no mejor de crear un objeto json de respuesta
            node.put("success", true);
            node.put("message", "La receta ha sido añadida");*/

            /*EJemplo de arry con json
            ArrayNode arr = Json.newArray();
            arr.add(1);
            arr.add(2);
            node.put("numbers", arr);*/


            //Content content = recetas.render(recets);


            //content = views.xml.usuario.render();


           /* RespuestaCreacionUsuario res = new RespuestaCreacionUsuario(); //buena forma
            res.setMessage("La receta ha sido creada");
            res.setSuccess(true);
            JsonNode json = Json.toJson(res);*/


            ////mejor manera////

        /*if(request.accepts("application/xml")){
                Content content = receta.render(r);
                return ok(content);
            }else if (request.accepts("application/json")){
                //ObjectNode result = Json.newObject();
                return ok(json);
            }else{
                return status(406);
            }*/
    }

    //falta terminar
    public Result getRecetaNombre(String nombre) { //añadir parámetro de http request??

        Receta receta = Receta.findByName(nombre);

        if(receta == null) {
            return status(404); //not found
        }

        List<Ingrediente> ingredientes = receta.getIngredientes();

        /* ---REQUEST? COMO HACERLO SIN PASAR EL PARÁMETRO DE HTTP REQUEST?
        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta,ingredientes));

        }else if (request.accepts("application/json")) {

            JsonNode node = Json.toJson(receta);
            return ok(node);

        }*/
        return Results.status(415); //Unsupported Media Type

    }

    //falta terminar, mismo que con nombre
    public Result getRecetaId(Long id) { //añadir parámetro de http request??

        Receta receta = Receta.findById(id);

        if(receta == null) {
            return status(404); //not found
        }

        List<Ingrediente> ingredientes = receta.getIngredientes();

        /* ---REQUEST? COMO HACERLO SIN PASAR EL PARÁMETRO DE HTTP REQUEST?
        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta,ingredientes));

        }else if (request.accepts("application/json")) {

            JsonNode node = Json.toJson(receta);
            return ok(node);

        }*/
        return Results.status(415); //Unsupported Media Type

    }

    //falta implementar para crear lista json
    public Result getRecetaTiempo(String tiempo) { //añadir parámetro de http request??

        List<Receta> recetas = Receta.findByTime(tiempo);

        if(recetas == null) {
            return status(404); //not found
        }

        //List<Ingrediente> ingredientes = receta.getIngredientes();

        /* ---REQUEST? COMO HACERLO SIN PASAR EL PARÁMETRO DE HTTP REQUEST?
        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta,ingredientes));

        }else if (request.accepts("application/json")) {

            JsonNode node = Json.toJson(receta);
            return ok(node);

        }*/
        return Results.status(415); //Unsupported Media Type

    }
 //falta implementar para crear lista json
    public Result getRecetaTipo(String tipo) { //añadir parámetro de http request??

        List<Receta> recetas = Receta.findByTipo(tipo);

        if(recetas == null) {
            return status(404); //not found
        }

        //List<Ingrediente> ingredientes = receta.getIngredientes();

        /* ---REQUEST? COMO HACERLO SIN PASAR EL PARÁMETRO DE HTTP REQUEST?
        if (request.accepts("application/xml")) {

            return ok(views.xml.receta.render(receta,ingredientes));

        }else if (request.accepts("application/json")) {

            JsonNode node = Json.toJson(receta);
            return ok(node);

        }*/
        return Results.status(415); //Unsupported Media Type

    }

    //delete receta por ID FUNCIONA!!
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

    //delete ingrediente por ID FUNCIONA!!
    public Result deleteIngrediente(Long id) {

        Ingrediente ingrediente = Ingrediente.findById(id);

        if (ingrediente == null) { //si no existe (la busqueda devolvio null)
            return Results.status(404); //not found
        }else{
            System.out.println("Ingrediente " + id + " eliminado");
            ingrediente.delete();
            return Results.ok();
        }

    }

    //pendiente de hacer
    public Result updateReceta() {
        return ok("Usuario actualizado");
    }

    //rehacer entero NO VALE
    public Result getListaRecetas() {
        String listado = "";

        if(Receta.listaRecetas.size() > 0) {
            System.out.println("Lista de recetas: ");

            for (int i = 0; i < Receta.listaRecetas.size(); i++) {
                System.out.println(Receta.listaRecetas.get(i).toString());
                listado = listado.concat("\n" + Receta.listaRecetas.get(i).toString());
            }
            return ok("Lista de recetas:\n" + listado);
        } else {
            return Results.notFound("No hay ninguna receta añadida");
        }
    }

    public String getStringFromDocument(Document doc)
    {
        try
        {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch(TransformerException ex)
        {
            ex.printStackTrace();
            return null;
        }
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