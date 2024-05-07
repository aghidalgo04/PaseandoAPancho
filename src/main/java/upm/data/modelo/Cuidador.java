package upm.data.modelo;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.modelo.enums.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cuidador extends Usuario {
    private File foto;
    private String descripcion;
    private Integer precio;
    private String IBAN;
    private List<File> documentacion;
    private Integer panchoPuntos;
    private Map<Long, Mascota> mascotasFavoritas;
    private Map<Long, ContratoCuidado> contratos;
    private Map<Long, Premio> premios;


    public Cuidador(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.IBAN = IBAN;
        this.panchoPuntos = 0;
        this.mascotasFavoritas = new HashMap<>();
        this.contratos = new HashMap<>();
        this.premios = new HashMap<>();
    }

    public Cuidador(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.IBAN = IBAN;
        this.documentacion = documentacion;
        this.panchoPuntos = 0;
        this.mascotasFavoritas = new HashMap<>();
        this.contratos = new HashMap<>();
        this.premios = new HashMap<>();
    }

    public File getFoto() {
        return this.foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getIBAN() {
        return this.IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public List<File> getDocumentacion() {
        return this.documentacion;
    }

    public void setDocumentacion(List<File> documentacion) {
        this.documentacion = documentacion;
    }

    public void anadirMascotaFavorita(Mascota mascota) {
        this.mascotasFavoritas.put(mascota.getId(), mascota);
    }

    public Mascota buscarMascotaFavoritaPorId(Long id) {
        return this.mascotasFavoritas.get(id);
    }

    public void eliminarMascotaFavorita(Long id) {
        this.mascotasFavoritas.remove(id);
    }

    public void anadirPremio(Premio premio) {
        this.premios.put(premio.getId(), premio);
    }

    public Premio buscarPremioPorId(Long id) {
        return this.premios.get(id);
    }

    public void anadirContratoCuidado(ContratoCuidado contratoCuidado) {
        this.contratos.put(contratoCuidado.getId(), contratoCuidado);
    }

    public ContratoCuidado buscarContratoCuidado(Long id) {
        return this.contratos.get(id);
    }
}

