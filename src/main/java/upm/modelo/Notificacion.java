package upm.modelo;

import java.time.LocalDateTime;

public class Notificacion {
    private final Long id;
    private final LocalDateTime fechaLectura;

    public Notificacion(Long id) {
        this.id = id;
        this.fechaLectura = null;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(LocalDateTime fechaLectura) {
    }
}

