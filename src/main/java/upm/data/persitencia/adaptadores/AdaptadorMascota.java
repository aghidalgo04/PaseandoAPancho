package upm.data.persitencia.adaptadores;

import upm.data.modelo.Foto;
import upm.data.modelo.Mascota;

import java.util.List;

public class AdaptadorMascota {
    private Long id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String codigoRIAC;
    private String polizaSeguro;
    private List<Long> albums;
    private Foto fotoFavorita;

    public AdaptadorMascota(Mascota mascota) {
        this.id = mascota.getId();
        this.nombre = mascota.getNombre();
        this.direccion = mascota.getDireccion();
        this.descripcion = mascota.getDescripcion();
        this.codigoRIAC = mascota.getCodigoRIAC();
        this.polizaSeguro = mascota.getPolizaSeguro();
        this.albums = mascota.getIdAlbums();
        this.fotoFavorita = mascota.getFotoFavorita();
    }

    public Mascota getMascota() {
        return new Mascota(this.id, this.nombre, this.direccion, this.descripcion, this.codigoRIAC, this.polizaSeguro, this.fotoFavorita);
    }
}
