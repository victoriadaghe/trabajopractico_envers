package entidades;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Audited //con esto logramos crear las tablas _AUD
//@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal", nullable = false)
    private int subtotal;

    // Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura", referencedColumnName = "id", nullable = false)
    private Factura factura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo", referencedColumnName = "id", nullable = false)
    private Articulo articulo;

    // Constructor por defecto
    public DetalleFactura() {
        // Constructor vacío
    }

    // Constructor con parámetros (sin factura)
    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Constructor con parámetros (con artículo)
    public DetalleFactura(int cantidad, int subtotal, Articulo articulo) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.articulo = articulo;
    }

    // Constructor con parámetros (con artículo y factura)
    public DetalleFactura(int cantidad, int subtotal, Articulo articulo, Factura factura) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.articulo = articulo;
        this.factura = factura;
    }


public Factura getFactura() {
    return factura;
}

public void setFactura(Factura factura) {
    this.factura = factura;
}

public Articulo getArticulo() {
    return articulo;
}

public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
}

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

public int getSubtotal() {
    return subtotal;
}

public void setSubtotal(int subtotal) {
    this.subtotal = subtotal;
}
}

