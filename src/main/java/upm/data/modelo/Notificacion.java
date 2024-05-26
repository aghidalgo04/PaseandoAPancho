package upm.data.modelo;

import java.time.LocalDateTime;

public class Notificacion {
    private Long id;
    private LocalDateTime fechaLectura;

    public Notificacion() {}

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

