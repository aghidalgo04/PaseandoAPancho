package upm.data.modelo;

import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Cuidador extends Usuario {
    private File foto;
    private String descripcion;
    private Integer precio;
    private String IBAN;
    private List<File> documentacion;
    private Integer panchoPuntos;
    private List<Mascota> mascotasFavoritas;
    private List<ContratoCuidado> contratos;
    private List<Premio> premios;

    public Cuidador() {
        super();
        this.mascotasFavoritas = new ArrayList<>();
        this.premios = new ArrayList<>();
        this.contratos = new ArrayList<>();
    }

    public Cuidador(String id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.IBAN = IBAN;
        this.panchoPuntos = 0;
        this.mascotasFavoritas = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.premios = new ArrayList<>();
    }

    public Cuidador(String id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        this(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN);
        this.documentacion = documentacion;
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

    public Integer getPanchoPuntos() {
        return this.panchoPuntos;
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

    public List<ContratoCuidado> getContratos() {
        return this.contratos;
    }

    public void anadirMascotaFavorita(Mascota mascota) {
        this.mascotasFavoritas.add(mascota);
    }

    public Mascota buscarMascotaFavoritaPorId(Long id) {
        return null;
    }

    public void eliminarMascotaFavorita(Mascota mascotaFavorita) {
        this.mascotasFavoritas.remove(mascotaFavorita);
    }

    public void anadirPremio(Premio premio) {
        this.premios.add(premio);
    }

    public Premio buscarPremioPorId(Long id) {
        return null;
    }

    public void anadirContratoCuidado(ContratoCuidado contratoCuidado) {
        this.contratos.add(contratoCuidado);
    }

    public ContratoCuidado buscarContratoCuidado(Long id) {
        return null;
    }

    public List<Long> getIdMascotasFavoritas() {
        List<Long> idMascotasFavoritas = new ArrayList<>();
        this.mascotasFavoritas.forEach(mascotaFavorita -> {
            idMascotasFavoritas.add(mascotaFavorita.getId());
        });
        return idMascotasFavoritas;
    }

    public List<Long> getIdContratos() {
        List<Long> idContratos = new ArrayList<>();
        this.contratos.forEach(contrato -> {
            idContratos.add(contrato.getId());
        });
        return idContratos;
    }

    public List<Long> getIdPremios() {
        List<Long> idPremios = new ArrayList<>();
        this.premios.forEach(mascotaFavorita -> {
            idPremios.add(mascotaFavorita.getId());
        });
        return idPremios;
    }
}

