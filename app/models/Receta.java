package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import play.libs.Json;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties
public class Receta extends Model {

    @Id
    private Long id;

    @Constraints.Required
    private String nombre;

    @Constraints.Required
    private String tiempo;

    @Constraints.Required
    private String tipo; //tipo receta (vegano, vegetariano, omnivora?)

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);


    public Receta() {}

    public static Receta findById(long id) {
        return find.byId(id);
    }

    public static List<Receta> findByName(String nombre) {
        return find.query().where().icontains("nombre", nombre).findList();
    }

    public static List<Receta> findByTime(String tiempo) {
        return find.query().where().contains("tiempo", tiempo).findList();
    }

    public static List<Receta> findByTipo(String tipo) {
        return find.query().where().icontains("tipo", tipo).findList();
    }

    public static List<Receta> findAll() {
        return find.all();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente(int index) {
        return this.ingredientes.get(index);
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngredientes() { return this.ingredientes; }

    public String getNombre() {
        return this.nombre;
    }

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
