package es.albarregas.beans;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "profesoresAnan")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idProfesor")
    private Integer id;

    @Column(length = 30, nullable = false)
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "profesormodulo",
            joinColumns = @JoinColumn(name = "idProfesor"),
            foreignKey = @ForeignKey(name = "FK_profesormodulo_profesor"),
            inverseJoinColumns = @JoinColumn(name = "idModulo"),
            inverseForeignKey = @ForeignKey(name = "FK_profesormodulo_modulos")
    )
    private Set<Modulo> modulos;

    /* constructores */
    public Profesor() {
    }

    public Profesor(Integer id, String nombre, Set<Modulo> modulos) {
        this.id = id;
        this.nombre = nombre;
        this.modulos = modulos;
    }

    /* getters y setters */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }


}