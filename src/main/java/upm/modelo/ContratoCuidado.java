package upm.modelo;

import java.time.LocalDateTime;

public class ContratoCuidado {
    private Long id;
    private LocalDateTime fechaInicioDeCuidado;
    private LocalDateTime fechaFinDeCuidado;
    private LocalDateTime fechaFirma;
    private Integer panchoPuntosCuidado;
    private Boolean rescindido;
    private Double coste;
    private Mascota mascota;
    private MensajePeticion mensajePeticion;
    private Notificacion notificacion;

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascota, MensajePeticion mensajePeticion, Notificacion notificacion) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.coste = coste;
        this.mascota = mascota;
        this.mensajePeticion = mensajePeticion;
        this.notificacion = notificacion;
    }

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascota, Notificacion notificacion) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.coste = coste;
        this.mascota = mascota;
        this.notificacion = notificacion;
    }

    public Float calcularCoste() {
        return null;
    }

    public Integer calcularPanchoPuntosCuidado() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaInicioDeCuidado() {
        return fechaInicioDeCuidado;
    }

    public LocalDateTime getFechaFinDeCuidado() {
        return fechaFinDeCuidado;
    }

    public LocalDateTime getFechaFirma() {
        return fechaFirma;
    }

    public MensajePeticion getMensajePeticion() {
        return mensajePeticion;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public Cuidador getCuidador() {
        return null;
    }

    public Boolean isRescindido() {
        return rescindido;
    }

    public Double getCoste() {
        return coste;
    }

    public void setFechaFinDeCuidado(LocalDateTime fechaFinDeCuidado) {
        this.fechaFinDeCuidado = fechaFinDeCuidado;
    }

    public void setMensajePeticion(MensajePeticion mensajePeticion) {
        this.mensajePeticion = mensajePeticion;
    }

    public void setRescindido(Boolean rescindido) {
        this.rescindido = rescindido;
    }

}
