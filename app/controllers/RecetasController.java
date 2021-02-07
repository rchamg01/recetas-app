package controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Ingrediente;
import models.Receta;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class RecetasController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result create(Http.Request request) {

        Optional<String> contenido = request.contentType();
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
        if(contenido.toString().contains("application/json")){
            System.out.println("Receta escrita en JSON");
            /////////////////form solo vale para json//////////////////////
            Form<Receta> form = formFactory.form(Receta.class).bindFromRequest(request);

            System.out.println(form.rawData());

            if(form.hasErrors()){
                return Results.badRequest(form.errorsAsJson());
            } else {

                Receta rAux = form.get(); //se crea una receta donde se recoge los datos de la request
                List<Ingrediente> iAux = rAux.getIngredientes(); //se copian a una lista los ingredientes de la request

                //System.out.println("numero ingredientes: "+rAux.getListaIngredients().size());

                //System.out.println(rAux.getListaIngredients());

                Receta rf = new Receta(); //se crea nueva receta vacia donde se guardaran los datos bien compuestos

                //se añaden los atributos "unicos" al objeto vacio
                rf.setNombre(rAux.getNombre());
                System.out.println("nombre rec: "+ rf.getNombre());
                rf.setTiempo(rAux.getTiempo());
                System.out.println("tiempo: "+ rf.getTiempo());
                rf.setTipo(rAux.getTipo());
                System.out.println("tipo: "+ rf.getTipo());


                rf.save(); //se guarda la receta en la base de datos



                ///////////YA NO VALE///////////////////////////////////
               /* Receta r = form.get();
                System.out.println("Nombre: " +r.getNombre());
                System.out.println("Tiempo: " + r.getTiempoPreparacion());
                System.out.println("ingredientes");
                for (int i = 0; i< r.getListaIngredientes().size(); i++){
                    System.out.println(r.getIngrediente(i));
                }*/
               // System.out.println(r.toString());
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

            Receta.listaRecetas.add(r);
            //ObjectNode node = Json.newObject();
            //node.put("success", false);
            //node.put("message", "El usuario ha sido creado");

            Result respuesta = null;
            for (int i = 0; i < r.getListaIngredientes().size(); i++) {
                respuesta = Results.ok(requestBodyJSON).withHeader("nombre", r.getNombre()).withHeader("tiempo", String.valueOf(r.getTiempoPreparacion())).withHeader("ingredientes", r.ingredientesToString());
            }
            return respuesta;*/
        }

        /*
        *
        *
        <?xml version="1.0" encoding="UTF-8" standalone="no" ?>
        <recetas>
            <receta>
                <nombre>Cocido de garbanzos</nombre>
                <ingrediente>garbanzos</ingrediente>
            </receta>
        </recetas>
        *
        * */
        else if(contenido.toString().contains("application/xml")){
            System.out.println("Receta escrita en XML");
            Document requestBodyXML = request.body().asXml(); //para pedirlo en xml
            Receta r = new Receta();
            NodeList nombre = requestBodyXML.getElementsByTagName("nombre");
            for (int i = 0; i < nombre.getLength(); i++) {
                String nombre_xml = requestBodyXML.getElementsByTagName("nombre").item(i).getTextContent();
                for (int j = 0; j < Receta.listaRecetas.size(); j++) {
                    if(Receta.listaRecetas.get(j).getNombre().equals(nombre_xml)){
                        return Results.badRequest("La receta a añadir ya existe en la base de datos");
                    }
                }

                r.setNombre(nombre_xml);
                System.out.println("Nombre: "+nombre_xml);
            }

            NodeList tiempo = requestBodyXML.getElementsByTagName("tiempo");
            String tiempo_xml = requestBodyXML.getElementsByTagName("tiempo").item(0).getTextContent();
           // r.setTiempoPreparacion(Integer.parseInt(tiempo_xml));
            System.out.println("Tiempo (min): "+tiempo_xml);

            NodeList ingredientes = requestBodyXML.getElementsByTagName("ingrediente");
            for (int i = 0; i < ingredientes.getLength(); i++) {
                String ingrediente_xml = requestBodyXML.getElementsByTagName("ingrediente").item(i).getTextContent();
                //r.addIngrediente(ingrediente_xml);
                System.out.println("Ingrediente: "+ingrediente_xml);
            }
            Receta.listaRecetas.add(r);

            Result respuesta = null;

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

            /*Receta rec = new Receta();
            rec.setNombre("cocido");
            rec.setTiempoPreparacion(45);
            rec.addIngrediente("garbanzos");

            Receta rec2 = new Receta();
            rec2.setNombre("cocido");
            rec2.setTiempoPreparacion(45);
            rec2.addIngrediente("garbanzos");

            List<Receta> recets = new ArrayList<>();
            recets.add(rec);
            recets.add(rec2);

            //Content content = recetas.render(recets);
            //Content content = receta.render(rec);

            //content = views.xml.usuario.render();
            */

            RespuestaCreacionUsuario res = new RespuestaCreacionUsuario(); //mejor forma
            res.setMessage("La receta ha sido creada");
            res.setSuccess(true);
            JsonNode json = Json.toJson(res);

            ////mejor manera////
           /* if(request.accepts("application/xml")){
                Content content = receta.render(r);
                return ok(content);
            }else if (request.accepts("application/json")){
                //ObjectNode result = Json.newObject();
                return ok(json);
            }else{
                return status(406);
            }*/

            /*for (int i = 0; i < r.getListaIngredientes().size(); i++) {
                respuesta = Results.ok().withHeader("nombre", r.getNombre()).withHeader("tiempo", String.valueOf(r.getTiempoPreparacion())).withHeader("ingredientes", r.ingredientesToString());
            }
            return respuesta;*/
            return Results.ok();

        }else{ //si no esta ni en json ni en xml
            return status(406);
        }


    }

    public Result getReceta(Http.Request request) {
        Optional<String> contenido = request.contentType();

        if(contenido.toString().contains("application/json")){
            JsonNode requestBodyJSON = request.body().asJson();
            int indice = requestBodyJSON.path("indice").asInt();
            System.out.println("indice: "+ indice +"   Tamaño lista: "+(Receta.listaRecetas.size()-1));

            if (Receta.listaRecetas.size() > indice) {
                Receta r = Receta.listaRecetas.get(indice);
                System.out.println(r.toString());
                return ok(r.toString());

            }else{
                return Results.notFound("No existe ninguna receta con ese índice");
            }
        }else if(contenido.toString().contains("application/xml")){
            Document requestBodyXML = request.body().asXml();
            int indice = Integer.parseInt(requestBodyXML.getElementsByTagName("indice").item(0).getTextContent());
            System.out.println("indice: "+ indice +"   Tamaño lista: "+(Receta.listaRecetas.size()-1));

            if (Receta.listaRecetas.size() > indice) {
                Receta r = Receta.listaRecetas.get(indice);
                System.out.println(r.toString());
                return ok(r.toString());
            }else{
                return Results.notFound("No existe ninguna receta con ese índice");
            }

        }else{
            System.out.println("El indice no está escrito en formato JSON o XML");
            return Results.status(415); //Unsupported Media Type
        }


    }

    //delete receta por ID FUNCIONA!!
    public Result deleteReceta(Http.Request request) {

        Optional<String> contenido = request.contentType();

        if(contenido.toString().contains("application/json")){
            JsonNode requestBodyJSON = request.body().asJson();
            long id = requestBodyJSON.path("id").asLong();

            Receta receta = Receta.findById(id);
            //Receta.listaRecetas.remove(id);

            if (receta == null) { //si no existe (la busqueda devolvio null)
                return Results.status(404); //not found
            }
            System.out.println("Receta " + id + " eliminada");
            receta.delete();
            return Results.ok();

        }else if(contenido.toString().contains("application/xml")) {
            Document requestBodyXML = request.body().asXml();
            long id = Long.parseLong(requestBodyXML.getElementsByTagName("id").item(0).getTextContent());
            Receta receta = Receta.findById(id);
            //Receta.listaRecetas.remove(id);

            if (receta == null) { //si no existe (la busqueda devolvio null)
                return Results.status(404);
            }
            System.out.println("Receta " + id + " eliminada");
            receta.delete();
            return Results.ok();

        }else{
            System.out.println("El indice no está escrito en formato JSON o XML");
            return Results.status(415); //Unsupported Media Type
        }

    }
    //no vale
    public Result updateReceta(Http.Request request) {
        JsonNode requestBodyJSON = request.body().asJson();
        int indice = requestBodyJSON.path("indice").asInt();
        Receta.listaRecetas.get(indice);
        System.out.println("Usuario " + indice + " actualizado");
        return ok("Usuario " + indice + " actualizado");
    }


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