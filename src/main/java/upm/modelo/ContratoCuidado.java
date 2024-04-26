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
    private Cuidador cuidador;
    private MensajePeticion mensajePeticion;
    private Notificacion notificacion;

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascota, MensajePeticion mensajePeticion, Notificacion notificacion, Cuidador cuidador) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.coste = coste;
        this.mascota = mascota;
        this.mensajePeticion = mensajePeticion;
        this.notificacion = new Notificacion(id);
        this.cuidador = cuidador;
        this.panchoPuntosCuidado = calcularPanchoPuntosCuidado();
    }

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascota, Notificacion notificacion, Cuidador cuidador) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.coste = coste;
        this.mascota = mascota;
        this.notificacion = new Notificacion(id);
        this.cuidador = cuidador;
        this.panchoPuntosCuidado = calcularPanchoPuntosCuidado();
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
        return this.fechaInicioDeCuidado;
    }

    public LocalDateTime getFechaFinDeCuidado() {
        return this.fechaFinDeCuidado;
    }

    public LocalDateTime getFechaFirma() {
        return this.fechaFirma;
    }

    public MensajePeticion getMensajePeticion() {
        return this.mensajePeticion;
    }

    public Notificacion getNotificacion() {
        return this.notificacion;
    }

    public Mascota getMascota() {return this.mascota;}

    public Cuidador getCuidador() {
        return this.cuidador;
    }

    public Boolean isRescindido() {
        return this.rescindido;
    }

    public Double getCoste() {
        return this.coste;
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
