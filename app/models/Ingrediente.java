package models;

import com.fasterxml.jackson.annotation.*;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Ingrediente extends Model {

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank
    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
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

    @JsonBackReference
    public List<Receta> getRecetas() {
        return listaRecetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.listaRecetas = recetas;
    }

    public static Ingrediente findByNombre(String nombreIngrediente) {
        return find.query().where().icontains("nombre", nombreIngrediente).findOne();
    }
    public static List<Ingrediente> findListaByNombre(String nombreIngrediente) {
        return find.query().where().icontains("nombre", nombreIngrediente).findList();
    }

    public static Ingrediente findById(Long id) {
        return find.byId(id);
    }

}
