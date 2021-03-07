package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Usuario extends Model {

    public static final Finder<Long, Usuario> find = new Finder<>(Usuario.class);

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "usuario")
    @Valid
    private List<Receta> listaRecetas;

    public static Usuario findByNombreE(String nombreUsuario) {
        return find.query().where().eq("nombre", nombreUsuario).findOne();
    }

    public static Usuario findByNombre(String nombreUsuario) {
        return find.query().where().icontains("nombre", nombreUsuario).findOne();
    }

    public static List<Usuario> findListaByNombre(String nombreUsuario) {
        return find.query().where().icontains("nombre", nombreUsuario).findList();
    }

    public static Usuario findById(Long id) {
        return find.byId(id);
    }

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

}
