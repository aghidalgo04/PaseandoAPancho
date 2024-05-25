package upm.data.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Notificacion implements Serializable {
    private final Long id;
    private LocalDateTime fechaLectura;

    public Notificacion(Long id) {
        this.id = id;
        this.fechaLectura = null;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getFechaLectura() {
        return this.fechaLectura;
    }

    public void setFechaLectura(LocalDateTime fechaLectura) {
        this.fechaLectura = fechaLectura;
    }
}

