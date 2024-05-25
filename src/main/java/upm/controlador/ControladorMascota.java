package upm.controlador;

import servidor.ExternalRIAC;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.data.modelo.*;
import upm.data.modelo.excepciones.InvalidAttributeException;
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
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new InvalidAttributeException("Codigo RIAC no valido");
        }
        this.persistenciaMascota.create(new Mascota(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita));
        this.IDS++;
        return this.IDS;
    }

    public Long crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new InvalidAttributeException("Codigo RIAC no valido");
        }
        this.persistenciaMascota.create(new MascotaExotica(this.IDS, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita, certificadoLegal, certificadoSalud, libreEnfermedadesTransmisibles));
        this.IDS++;
        return this.IDS;
    }

    public List<Mascota> listarMascotas() {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (this.session.esCuidador()) {
            Cuidador cuidador = (Cuidador) this.session.getUsuario();
            return cuidador.getContratos().stream().map(ContratoCuidado::getMascotaAsociada).toList();
        } else {
            Dueno dueno = (Dueno) this.session.getUsuario();
            return dueno.getMascotas();
        }
    }
}
