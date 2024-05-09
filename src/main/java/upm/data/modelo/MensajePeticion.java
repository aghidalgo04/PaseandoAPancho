package upm.data.modelo;

import upm.data.modelo.enums.Estado;

import java.time.LocalDateTime;

public class MensajePeticion extends Mensaje {
    private Estado estado;

    public MensajePeticion(Long id, String cuerpo, LocalDateTime fechaEnvio, Estado estado) {
        super(id, cuerpo, fechaEnvio);
        this.estado = estado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
