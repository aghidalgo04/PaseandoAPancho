package upm.data.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Premio  implements Serializable {
    private final Long id;
    private Integer precio;
    private LocalDateTime fechaCompra;

    public Premio(Long id, Integer precio, LocalDateTime fechaCompra) {
        this.id = id;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
