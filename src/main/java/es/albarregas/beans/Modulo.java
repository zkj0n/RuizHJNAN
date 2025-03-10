package es.albarregas.beans;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "modulosAnan")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idModulo")
    private Integer id;

    @Column(length = 60, nullable = false)
    private String titulo;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "modulos")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Profesor> profesores;

    /* constructores */
    public Modulo() {
    }

    public Modulo(Integer id, String titulo, Set<Profesor> profesores) {
        this.id = id;
        this.titulo = titulo;
        this.profesores = profesores;
    }

    /* getters y setters */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }


}