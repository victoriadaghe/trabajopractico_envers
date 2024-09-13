package entidades;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited //con esto logramos crear las tablas _AUD
@Table(name = "Categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion", nullable = false, length = 100)
    private String denominacion;

    @ManyToMany(mappedBy = "categorias", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Articulo> articulos = new ArrayList<>();

    // Constructor por defecto
    public Categoria() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
