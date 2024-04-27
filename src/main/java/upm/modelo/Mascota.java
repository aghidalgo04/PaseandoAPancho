package upm.modelo;

import java.util.List;

public class Mascota {
    private Long id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String codigoRIAC;
    private String polizaSeguro;
    private List albums;
    private Foto fotoFavorita;

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List albums, Foto fotoFavorita) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
        this.polizaSeguro = polizaSeguro;
        this.albums = albums;
        this.fotoFavorita = fotoFavorita;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List albums) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
        this.polizaSeguro = polizaSeguro;
        this.albums = albums;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, Foto fotoFavorita) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
        this.polizaSeguro = polizaSeguro;
        this.fotoFavorita = fotoFavorita;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
        this.polizaSeguro = polizaSeguro;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigoRIAC() {
        return codigoRIAC;
    }

    public String getPolizaSeguro() {
        return polizaSeguro;
    }

    public Foto getFotoFavorita() {
        return fotoFavorita;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigoRIAC(String codigoRIAC) {
        this.codigoRIAC = codigoRIAC;
    }

    public void setPolizaSeguro(String polizaSeguro) {
        this.polizaSeguro = polizaSeguro;
    }

    public void setFotoFavorita(Foto fotoFavorita) {
        this.fotoFavorita = fotoFavorita;
    }

    public void anadirAlbum(Album album) {
    }

    public Album buscarAlbumPorId(Long id) {
        return null;
    }

    public void eliminarAlbum(Long id) {
    }
}
