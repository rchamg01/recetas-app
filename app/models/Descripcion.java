package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class Descripcion extends Model {

    public static final Finder<Long, Descripcion> find = new Finder<>(Descripcion.class);



    @Id
    private Long id;

    @OneToOne(mappedBy="descripcion")
    @Valid
    private Receta receta;

    @Constraints.Required
    @NotBlank
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String descripcion) {
        this.texto = descripcion;
    }

    @JsonBackReference
    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Descripcion findByNombre(String texto) {
        return find.query().where().icontains("texto", texto).findOne();
    }

    public static Descripcion findById(Long id) {
        return find.byId(id);
    }

}
