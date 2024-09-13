package entidades;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Audited //con esto logramos crear las tablas _AUD
@Table(name = "Domicilio")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_calle", nullable = false, length = 100)
    private String nombreCalle;

    @Column(name = "numero", nullable = false)
    private int numero;

    @OneToOne(mappedBy = "domicilio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    // Constructor por defecto
    public Domicilio() {
        // Constructor vacío
    }

    // Constructor con parámetros (sin cliente)
    public Domicilio(String nombreCalle, int numero) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

    // Constructor con parámetros (con cliente)
    public Domicilio(String nombreCalle, int numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
