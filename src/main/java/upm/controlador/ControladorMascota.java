package upm.controlador;

import upm.modelo.Album;
import upm.modelo.Foto;
import upm.modelo.Mascota;
import upm.modelo.MascotaExotica;
import upm.persitencia.PersistenciaMascota;

import java.io.File;
import java.util.List;

public class ControladorMascota {
    private Long IDS;
    private PersistenciaMascota persistenciaMascota;

    public ControladorMascota(PersistenciaMascota persistenciaMascota) {
        this.IDS = 0l;
        this.persistenciaMascota = persistenciaMascota;
    }

    public void crearMascota(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
        this.IDS++;
        Mascota mascota = new Mascota(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita);
    }

    public void crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        this.IDS++;
        Mascota mascota = new MascotaExotica(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita, certificadoLegal, certificadoSalud, libreEnfermedadesTransmisibles);
    }

    public List<Mascota> listarMascotas() {
        return this.persistenciaMascota.findAll();
    }
}
