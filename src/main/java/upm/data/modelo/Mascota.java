package upm.data.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mascota  implements Serializable {
    private final Long id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String codigoRIAC;
    private String polizaSeguro;
    private List<Album> albums;
    private Foto fotoFavorita;

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro) {
        this(id, nombre, direccion, descripcion, codigoRIAC);
        this.polizaSeguro = polizaSeguro;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, Foto fotoFavorita) {
        this(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro);
        this.fotoFavorita = fotoFavorita;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums) {
        this(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro);
        this.albums = albums;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
        this(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums);
        this.fotoFavorita = fotoFavorita;
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoRIAC() {
        return this.codigoRIAC;
    }

    public void setCodigoRIAC(String codigoRIAC) {
        this.codigoRIAC = codigoRIAC;
    }

    public String getPolizaSeguro() {
        return this.polizaSeguro;
    }

    public void setPolizaSeguro(String polizaSeguro) {
        this.polizaSeguro = polizaSeguro;
    }

    public Foto getFotoFavorita() {
        return this.fotoFavorita;
    }

    public void setFotoFavorita(Foto fotoFavorita) {
        this.fotoFavorita = fotoFavorita;
    }

    public void anadirAlbum(Album album) {
        this.albums.add(album);
    }

    public Album buscarAlbumPorId(Long id) {
        return this.albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminarAlbum(Long id) {
        this.albums.removeIf(album -> album.getId().equals(id));
    }

    public List<Long> getIdAlbums() {
        List<Long> idAlbums = new ArrayList<>();
        this.albums.forEach(album -> idAlbums.add(album.getId()));
        return idAlbums;
    }
}
