package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Receta;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Optional;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class RecetasController extends Controller {

    public Result create(Http.Request request) {

        ///////////////////////////////////////
        /*Form<Usuario> form = formFactory.form(Usuario.class).bindFromRequest(request);

        if(form.hasErrors()){

        } else {
            Usuario r = form.get();
            System.out.println(r.getNombre());
            System.out.println(r.getEdad());
        }
        //Map<String>
        //System.out.println(form.rawData());
        ///////////////////////////////////////
        */

        //String bodyTXT = request.body().asText(); //para pedirlo como texto
        //Document requestBodyXML = request.body().asXml(); //para pedirlo en xml

        Optional<String> contenido = request.contentType();
        /* ----JSON------
        [
            {
                "nombre": "Cocido de garbanzos",
                "ingredientes": [
                    {"ingrediente": "garbanzos"},
                    {"ingrediente": "carne"},
                    {"ingrediente": "patata"},
                    {"ingrediente": "zanahoria"}
                ]
            }
        ]
        */
        if(contenido.toString().contains("application/json")){
            System.out.println("Receta escrita en JSON");
            JsonNode requestBodyJSON = request.body().asJson(); //para pedirlo en formato json
            System.out.println(contenido);
            Receta r = new Receta();
            //HELPFUL EXAMPLE: https://mkyong.com/java/jackson-tree-model-example/
            for (JsonNode root : requestBodyJSON) {
                String nombre = root.path("nombre").asText();
                for (int i = 0; i < Receta.listaRecetas.size(); i++) {
                    if(Receta.listaRecetas.get(i).getNombre().equals(nombre)){
                        return Results.badRequest("La receta a añadir ya existe en la base de datos");
                    }
                }
                System.out.println("Nombre receta : " + nombre);
                r.setNombre(nombre);
                // Get Name
           /* JsonNode nameNode = root.path("name");
            if (!nameNode.isMissingNode()) {        // if "name" node is exist
                System.out.println("firstName : " + nameNode.path("first").asText());
                System.out.println("middleName : " + nameNode.path("middle").asText());
                System.out.println("lastName : " + nameNode.path("last").asText());
            }*/
                JsonNode ingredienteNode = root.path("ingredientes");
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
                respuesta = Results.ok(requestBodyJSON).withHeader("nombre", r.getNombre()).withHeader("ingredientes", r.ingredientesToString());
            }
            return respuesta;
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


            NodeList ingredientes = requestBodyXML.getElementsByTagName("ingrediente");
            for (int i = 0; i < ingredientes.getLength(); i++) {
                String ingrediente_xml = requestBodyXML.getElementsByTagName("ingrediente").item(i).getTextContent();
                r.addIngrediente(ingrediente_xml);
                System.out.println("Ingrediente: "+ingrediente_xml);
            }
            Receta.listaRecetas.add(r);

            Result respuesta = null;
            for (int i = 0; i < r.getListaIngredientes().size(); i++) {
                respuesta = Results.ok(getStringFromDocument(requestBodyXML)).withHeader("nombre", r.getNombre()).withHeader("ingredientes", r.ingredientesToString());
            }

            return Results.ok(getStringFromDocument(requestBodyXML));
        }else{
            System.out.println("La receta no está escrita en formato JSON o XML");
            return Results.badRequest("La receta no está escrita en formato JSON o XML");
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
            return Results.badRequest("El indice no está escrito en formato JSON o XML");
        }


    }

    public Result deleteReceta(Http.Request request) {
        Optional<String> contenido = request.contentType();

        if(contenido.toString().contains("application/json")){
            JsonNode requestBodyJSON = request.body().asJson();
            int indice = requestBodyJSON.path("indice").asInt();
            Receta.listaRecetas.remove(indice); //Cuando se elimina un usuario el resto de usuarios se cambian de indice ocupando el hueco
            System.out.println("Usuario " + indice + " eliminado");
            return ok("Usuario " + indice + " eliminado");
        }else if(contenido.toString().contains("application/xml")) {
            Document requestBodyXML = request.body().asXml();
            int indice = Integer.parseInt(requestBodyXML.getElementsByTagName("indice").item(0).getTextContent());
            Receta.listaRecetas.remove(indice); //Cuando se elimina un usuario el resto de usuarios se cambian de indice ocupando el hueco
            System.out.println("Usuario " + indice + " eliminado");
            return ok("Usuario " + indice + " eliminado");
        }else{
            System.out.println("El indice no está escrito en formato JSON o XML");
            return Results.badRequest("El indice no está escrito en formato JSON o XML");
        }

    }

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
