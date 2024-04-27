package upm.modelo;

import java.time.LocalDateTime;

public class Mensaje {
    private final Long id;
    private String cuerpo;
    private LocalDateTime fechaEnvio;

    public Mensaje(Long id, String cuerpo, LocalDateTime fechaEnvio) {
        this.id = id;
        this.cuerpo = cuerpo;
        this.fechaEnvio = fechaEnvio;
    }

    public Long getId() {
        return this.id;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public LocalDateTime getFechaEnvio() {
        return this.fechaEnvio;
    }
}
