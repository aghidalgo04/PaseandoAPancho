package upm.data.modelo;

import java.time.LocalDateTime;

public class ProductoMascota extends Premio {
    private String nombre;
    private String descripcion;

    public ProductoMascota(Long id, Integer precio, LocalDateTime fechaCompra, String nombre, String descripcion) {
        super(id, precio, fechaCompra);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
