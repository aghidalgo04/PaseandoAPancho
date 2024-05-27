package upm.data.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContratoCuidado{
    public static final String FORMATO_FECHA = "dd-MM-yyyy HH.mm";

    private Long id;
    private String fechaInicioDeCuidado;
    private String fechaFinDeCuidado;
    private String fechaFirma;
    private Integer panchoPuntosCuidado;
    private Boolean rescindido;
    private Double coste;
    private Mascota mascotaAsociada;
    private MensajePeticion mensajePeticion;
    private Notificacion notificacion;

    public ContratoCuidado(){
    }

    public ContratoCuidado(Long id, String fechaInicioDeCuidado, String fechaFinDeCuidado, String fechaFirma, Double coste, Mascota mascotaAsociada) {
        this.id = id;
        this.fechaInicioDeCuidado = fechaInicioDeCuidado;
        this.fechaFinDeCuidado = fechaFinDeCuidado;
        this.fechaFirma = fechaFirma;
        this.panchoPuntosCuidado = calcularPanchoPuntosCuidado();
        this.rescindido = false;
        this.coste = coste;
        this.mascotaAsociada = mascotaAsociada;
        this.notificacion = new Notificacion(id);
    }

    public ContratoCuidado(Long id, String fechaInicioDeCuidado, String fechaFinDeCuidado, String fechaFirma, Double coste, Mascota mascotaAsociada, Cuidador cuidador, MensajePeticion mensajePeticion) {
        this(id, fechaInicioDeCuidado, fechaFinDeCuidado, fechaFirma, coste, mascotaAsociada);
        this.mensajePeticion = mensajePeticion;
    }

    public Long getId() {
        return this.id;
    }

    public String getFechaInicioDeCuidado() {
        return this.fechaInicioDeCuidado;
    }

    public String getFechaFinDeCuidado() {
        return this.fechaFinDeCuidado;
    }

    public void setFechaFinDeCuidado(String fechaFinDeCuidado) {
        this.fechaFinDeCuidado = fechaFinDeCuidado;
    }

    public String getFechaFirma() {
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
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm");
        LocalDateTime fechaFin = LocalDateTime.parse(fechaFinDeCuidado, dateTimeFormatter);
        LocalDateTime fechaIn = LocalDateTime.parse(fechaInicioDeCuidado, dateTimeFormatter);
        int dias = fechaFin.getDayOfMonth() - fechaIn.getDayOfMonth();
        int horas = fechaFin.getHour() - fechaIn.getHour();
        return (dias * coste) + (horas * coste);
    }

    public Integer calcularPanchoPuntosCuidado() {
        return null;
    }
}
