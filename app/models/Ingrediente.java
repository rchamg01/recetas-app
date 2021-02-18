package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Ingrediente extends Model {

    @Id
    private Long id;

    @Constraints.Required
    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
    private List<Receta> listaRecetas; //relacion mn

    public static final Finder<Long, Ingrediente> find = new Finder<>(Ingrediente.class);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setListaIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return ingredientes;
    }*/

    public List<Receta> getRecetas() {
        return listaRecetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.listaRecetas = recetas;
    }

    /*public Ingrediente getIngrediente(int index){
        return ingredientes.get(index);
    }

    public void addIngrediente(Ingrediente ingrediente){
        ingredientes.add(ingrediente);
    }*/

    public static Ingrediente findByNombre(String nombreIngrediente) {
        return find.query().where().eq("nombre", nombreIngrediente).findOne();
    }

    public static Ingrediente findById(Long id) {
        return find.byId(id);
    }

}
