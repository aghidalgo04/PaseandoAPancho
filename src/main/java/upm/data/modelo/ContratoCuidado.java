package upm.data.modelo;

import java.time.LocalDateTime;

public class ContratoCuidado{
    private Long id;
    private LocalDateTime fechaInicioDeCuidado;
    private LocalDateTime fechaFinDeCuidado;
    private LocalDateTime fechaFirma;
    private Integer panchoPuntosCuidado;
    private Boolean rescindido;
    private Double coste;
    private Mascota mascotaAsociada;
    private Cuidador cuidador;
    private MensajePeticion mensajePeticion;
    private Notificacion notificacion;

    public ContratoCuidado(){
    }

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascotaAsociada, Cuidador cuidador) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.panchoPuntosCuidado = calcularPanchoPuntosCuidado();
        this.rescindido = false;
        this.coste = coste;
        this.mascotaAsociada = mascotaAsociada;
        this.cuidador = cuidador;
        this.notificacion = new Notificacion(id);
    }

    public ContratoCuidado(Long id, LocalDateTime fechaInicioDeCuidado, LocalDateTime fechaFinDeCuidado, LocalDateTime fechaFirma, Double coste, Mascota mascotaAsociada, Cuidador cuidador, MensajePeticion mensajePeticion) {
        this(id, fechaInicioDeCuidado, fechaFinDeCuidado, fechaFirma, coste, mascotaAsociada, cuidador);
        this.mensajePeticion = mensajePeticion;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getFechaInicioDeCuidado() {
        return this.fechaInicioDeCuidado;
    }

    public LocalDateTime getFechaFinDeCuidado() {
        return this.fechaFinDeCuidado;
    }

    public void setFechaFinDeCuidado(LocalDateTime fechaFinDeCuidado) {
        this.fechaFinDeCuidado = fechaFinDeCuidado;
    }

    public LocalDateTime getFechaFirma() {
        return this.fechaFirma;
    }

    public boolean isRescindido() {
        return this.rescindido;
    }

    public void setRescindido(Boolean rescindido) {
        this.rescindido = rescindido;
    }

    public Double getCoste() {
        return this.coste;
    }

    public Mascota getMascotaAsociada() {
        return this.mascotaAsociada;
    }

    public Cuidador getCuidador() {
        return this.cuidador;
    }

    public MensajePeticion getMensajePeticion() {
        return this.mensajePeticion;
    }

    public void setMensajePeticion(MensajePeticion mensajePeticion) {
        this.mensajePeticion = mensajePeticion;
    }

    public Notificacion getNotificacion() {
        return this.notificacion;
    }

    public Double calcularCoste() {
        int dias = fechaFinDeCuidado.getDayOfMonth() - fechaInicioDeCuidado.getDayOfMonth();
        int horas = fechaFinDeCuidado.getHour() - fechaInicioDeCuidado.getHour();
        return (dias * coste) + (horas * coste);
    }

    public Integer calcularPanchoPuntosCuidado() {
        return null;
    }
}
