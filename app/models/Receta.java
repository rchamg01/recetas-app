package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receta extends Model {

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank
    private String nombre;

    @Digits(integer = 3, fraction = 0)
    @Constraints.Required
    private String tiempo; //en minutos

    @Constraints.Required
    private String tipo; //tipo receta (vegano, vegetariano, omnivora)

    @OneToOne(cascade = CascadeType.ALL)
    private Descripcion descripcion;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes = new ArrayList<>();


    public Receta() {
    }

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

    @JsonManagedReference
    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

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

    @JsonManagedReference(value = "usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonManagedReference(value = "descripcion")
    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        ingrediente.getRecetas().add(this);
    }

}
