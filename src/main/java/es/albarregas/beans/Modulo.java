package es.albarregas.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "modulosA1an")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private int idModulo;

    @Column(name = "denominacion")
    private String denominacion;

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modulo)) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(getDenominacion(), modulo.getDenominacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDenominacion());
    }
}
