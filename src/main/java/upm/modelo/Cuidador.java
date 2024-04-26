package upm.modelo;

import Modelo.Enums.*;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cuidador extends Usuario {
    private File foto;
    private String descripcion;
    private Integer precio;
    private String IBAN;
    private Map<File> documentacion;
    private Integer panchoPuntos;
    private Set<Dueño> dueñosFavoritos;


    public Cuidador(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.IBAN = IBAN;
        this.dueñosFavoritos = new HashSet<>();
    }

    public Cuidador(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, Map<File> documentacion) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.IBAN = IBAN;
        this.documentacion = documentacion;
        this.dueñosFavoritos = new HashSet<>();
    }

    public void anadirMascotaFavorita(Mascota mascota) {
    }

    public Mascota buscarMascotaFavoritaPorId(Long id) {
        return null;
    }

    public void eliminarMascotaFavorita(Long id) {
    }

    public void anadirPremio(Premio premio) {
    }

    public Premio buscarPremioPorId(Long id) {
        return null;
    }

    public void anadirContratoCuidado(ContratoCuidado contratoCuidado) {
    }

    public ContratoCuidado buscarContratoCuidado(Long id) {
        return null;
    }

    public void anadirDueñoFavorito(Dueño dueño) {
        dueñosFavoritos.add(dueño);
    }

    public boolean esDueñoFavorito(Dueño dueño) {
        return dueñosFavoritos.contains(dueño);
    }

    public void eliminarDueñoFavorito(Dueño dueño) {
        dueñosFavoritos.remove(dueño);
    }

    public File getFoto() {
        return foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Map<File> getDocumentacion() {
        return documentacion;
    }

    public Integer getPanchoPuntos() {
        return panchoPuntos;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public void anadirMensajeEnviado(Mensaje mensaje) {

    }

    @Override
    public Mensaje buscarMensajeEnviadoPorId(Long id) {
        return null;
    }

    @Override
    public void anadirMensajeRecibido(Mensaje mensaje) {

    }

    @Override
    public Mensaje buscarMensajeRecibidoPorId(Long id) {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public String getApellidos() {
        return null;
    }

    @Override
    public String getCorreoElectronico() {
        return null;
    }

    @Override
    public Idioma getIdioma() {
        return null;
    }

    @Override
    public Plataforma getPlataformaRegistro() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {

    }

    @Override
    public void setApellidos(String apellidos) {

    }

    @Override
    public void setCorreoElectronico(String correo) {

    }

    @Override
    public void setDireccion(String direccion) {

    }

    @Override
    public void setIdioma(Idioma idioma) {

    }
}

