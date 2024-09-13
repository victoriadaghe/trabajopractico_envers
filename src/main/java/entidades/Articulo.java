package entidades;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited //con esto logramos crear las tablas _AUD
@Table(name = "Articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "denominacion", nullable = false, length = 100)
    private String denominacion;

    @Column(name = "precio", nullable = false)
    private int precio;

    // Relaciones
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DetalleFactura> detallesFacturas = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    // Constructor por defecto
    public Articulo() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(List<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
