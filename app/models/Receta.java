package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receta extends Model {

    @Id
    Long id;

    private String nombre;
    private String tiempo;
    private String tipo; //tipo receta (vegano, vegetariano, omnivora?)

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    static public List<Receta> listaRecetas = new ArrayList<>();

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);


    public Receta() {}

    public static Receta findById(long id) {
        return find.byId(id);
    }

    public static Receta findByName(String nombre) {
        return find.query().where().contains("nombre", nombre).findOne();
    }

    public static List<Receta> findByTime(int time) {
        return find.query().where().contains("tiempo", String.valueOf(time)).findList();
    }

    public static List<Receta> findAll() {
        return find.all();
    }

    public Ingrediente getIngrediente(int index) {
        return this.ingredientes.get(index);
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Ingrediente> getIngredientes() { return this.ingredientes; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        ingrediente.getRecetas().add(this);
    }

}
