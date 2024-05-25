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
    private final PersistenciaMascota persistenciaMascota;
    private final Session session;

    public ControladorMascota(PersistenciaMascota persistenciaMascota, Session session) {
        this.IDS = 1L;
        this.persistenciaMascota = persistenciaMascota;
        this.session = session;
    }

    public Long crearMascota(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new RuntimeException("Codigo RIAC no valido"); // @TODO cambiar por excepcion personal
        }
        this.persistenciaMascota.create(new Mascota(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita));
        this.IDS++;
        return this.IDS;
    }

    public Long crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new RuntimeException("Codigo RIAC no valido"); // @TODO cambiar por excepcion personal
        }
        this.persistenciaMascota.create(new MascotaExotica(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita, certificadoLegal, certificadoSalud, libreEnfermedadesTransmisibles));
        this.IDS++;
        return this.IDS;
    }

    // @TODO Listar mascotas que cuida
    public List<Mascota> listarMascotas() {
        if (!this.session.estaLogueado()) {
            throw new RuntimeException("No estas loguedo"); // @TODO cambiar por excepcion personal
        }
        if(!this.session.esCuidador()){
            throw new RuntimeException("No tienes acceso a esta fucnion");
        }
        return this.persistenciaMascota.findAll();
    }


}
