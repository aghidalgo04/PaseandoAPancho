package upm.data.modelo;

import java.util.ArrayList;
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

    public Mascota() {
        this.albums = new ArrayList<>();
    }

    protected Mascota(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.descripcion = builder.descripcion;
        this.codigoRIAC = builder.codigoRIAC;
        this.polizaSeguro = builder.polizaSeguro;
        this.albums = builder.albums;
        this.fotoFavorita = builder.fotoFavorita;
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

    public void eliminarAlbum(Long id) {
        this.albums.removeIf(album -> album.getId().equals(id));
    }

    public Album buscarAlbum(Long id) {
        return this.albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private String direccion;
        private String descripcion;
        private String codigoRIAC;
        private String polizaSeguro;
        private List<Album> albums = new ArrayList<>();
        private Foto fotoFavorita;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder codigoRIAC(String codigoRIAC) {
            this.codigoRIAC = codigoRIAC;
            return this;
        }

        public Builder polizaSeguro(String polizaSeguro) {
            this.polizaSeguro = polizaSeguro;
            return this;
        }

        public Builder albums(List<Album> albums) {
            this.albums = albums;
            return this;
        }

        public Builder fotoFavorita(Foto fotoFavorita) {
            this.fotoFavorita = fotoFavorita;
            return this;
        }

        public Mascota build() {
            return new Mascota(this);
        }
    }
}
