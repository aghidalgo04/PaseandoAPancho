package upm.modelo;

import java.util.Iterator;
import java.util.List;

public class Mascota {
    private Long id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String codigoRIAC;
    private String polizaSeguro;
    private List<Album> albums;
    private Foto fotoFavorita;

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.codigoRIAC = codigoRIAC;
        this.polizaSeguro = polizaSeguro;
        this.albums = albums;
        this.fotoFavorita = fotoFavorita;
    }

    public Mascota(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoRIAC() {
        return codigoRIAC;
    }

    public void setCodigoRIAC(String codigoRIAC) {
        this.codigoRIAC = codigoRIAC;
    }

    public String getPolizaSeguro() {
        return polizaSeguro;
    }

    public void setPolizaSeguro(String polizaSeguro) {
        this.polizaSeguro = polizaSeguro;
    }

    public Foto getFotoFavorita() {
        return fotoFavorita;
    }

    public void setFotoFavorita(Foto fotoFavorita) {
        this.fotoFavorita = fotoFavorita;
    }

    public void anadirAlbum(Album album) {
        this.albums.add(album);
    }

    public Album buscarAlbumPorId(Long id) {
        Iterator<Album> albumIterator = albums.iterator();
        while (albumIterator.hasNext()) {
            if (albumIterator.next().getId().equals(id)) {
                return albumIterator.next();
            }
        }
        return null;
    }

    public void eliminarAlbum(Long id) {
        Iterator<Album> albumIterator = albums.iterator();
        while (albumIterator.hasNext()) {
            if (albumIterator.next().getId().equals(id)) {
                albums.remove(albumIterator.next());
            }
        }
    }
}
