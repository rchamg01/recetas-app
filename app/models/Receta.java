package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receta extends Model {

    @Id
    long id;

    @Constraints.Required
    private String nombre;
    private String ingrediente;
    private int tiempoPreparacion; //en segundos

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);

    private ArrayList<String> listaIngredientes = new ArrayList<>();
    static public ArrayList<Receta> listaRecetas = new ArrayList<>();

    public Receta() {}

    public static Receta findById(long id) {
        return find.byId(id);
    }

    //el valor del nombre es unico por lo que solo devuelve una receta
    public static Receta findByName(String nombre) {
        return find.query().where().contains("nombre", nombre).findOne();
    }

    //aqui se usa lista porque probablemente aparezcan varias recetas con ese tiempo
    public static List<Receta> findByTime(int tiempo) {
        return null;
    }


    public String getIngrediente(int index) {
        return this.listaIngredientes.get(index);
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<String> getListaIngredientes() { return this.listaIngredientes; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void addIngrediente(String ingrediente) {
        listaIngredientes.add(ingrediente);
    }

    public String ingredientesToString(){
        String ingredientes = "";
        for (int i = 0; i < listaIngredientes.size(); i++) {
            ingredientes = ingredientes.concat(getIngrediente(i)+ ", ");
        }
        return ingredientes;
    }

    public String toString(){
        String receta = "Nombre: " + nombre + "\nTiempo (min): "+tiempoPreparacion+"\nIngredientes: ";
        for (int i = 0; i < listaIngredientes.size(); i++) {
            receta = receta.concat("\n"+getIngrediente(i));
        }
        return receta;
    }
}
