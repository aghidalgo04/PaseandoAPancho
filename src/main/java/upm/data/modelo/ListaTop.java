package upm.data.modelo;

import java.time.LocalDateTime;

public class ListaTop extends Premio {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCaducidad;

    public ListaTop(Long id, Integer precio, LocalDateTime fechaCompra, LocalDateTime fechaInicio, LocalDateTime fechaCaducidad) {
        super(id, precio, fechaCompra);
        this.fechaInicio = fechaInicio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public LocalDateTime getFechaCaducidad() {
        return this.fechaCaducidad;
    }
}
