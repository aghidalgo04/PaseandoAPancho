package upm.controlador;

import servidor.ExternalRIAC;
import upm.data.modelo.Album;
import upm.data.modelo.Foto;
import upm.data.modelo.Mascota;
import upm.data.modelo.MascotaExotica;
import upm.data.persitencia.PersistenciaMascota;

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
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new RuntimeException("Codigo RIAC no valido");    // @TODO habra que cambiar por excepciones personales
        }
        if(persistenciaMascota.findByCodigoRIAC(codigoRIAC).isPresent()){
            throw new RuntimeException("Codigo RIAC ya existe");    // @TODO habra que cambiar por excepciones personales
        }else{
            persistenciaMascota.create(new Mascota(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita));
            this.IDS++;
        }
    }

    public void crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        this.IDS++;
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new RuntimeException("Codigo RIAC no valido");    // @TODO habra que cambiar por excepciones personales
        }
        Mascota mascota = new MascotaExotica(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita, certificadoLegal, certificadoSalud, libreEnfermedadesTransmisibles);
    }

    public List<Mascota> listarMascotas() {
        return this.persistenciaMascota.findAll();
    }
}
