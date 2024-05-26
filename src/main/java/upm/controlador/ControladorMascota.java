package upm.controlador;

import servidor.ExternalRIAC;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.data.modelo.*;
import upm.data.modelo.excepciones.InvalidAttributeException;
import upm.data.persitencia.PersistenciaMascota;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorMascota {
    private Long IDS;
    private final PersistenciaMascota persistenciaMascota;
    private final Session session;

    public ControladorMascota(PersistenciaMascota persistenciaMascota, Session session) {
        this.IDS = 0L;
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

        Mascota.Builder builder = new Mascota.Builder()
                .id(++this.IDS)
                .nombre(nombre)
                .direccion(direccion)
                .descripcion(descripcion)
                .codigoRIAC(codigoRIAC);

        if (!polizaSeguro.isEmpty()) {
            builder.polizaSeguro(polizaSeguro);
        }

        if (albums != null) {
            builder.albums(albums);
        }

        if (fotoFavorita != null) {
            builder.fotoFavorita(fotoFavorita);
        }

        this.persistenciaMascota.create(builder.build());
        return this.IDS;
    }

    public Long crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new InvalidAttributeException("Codigo RIAC no valido");
        }

        MascotaExotica.Builder builder = (MascotaExotica.Builder) new MascotaExotica.Builder()
                .certificadoLegal(certificadoLegal)
                .libreEnfermedadesTransmisibles(libreEnfermedadesTransmisibles)
                .certificadoSalud(certificadoSalud)
                .id(++this.IDS)
                .nombre(nombre)
                .direccion(direccion)
                .descripcion(descripcion)
                .codigoRIAC(codigoRIAC);

        if (!polizaSeguro.isEmpty()) {
            builder.polizaSeguro(polizaSeguro);
        }

        if (albums != null && !albums.isEmpty()) {
            builder.albums(albums);
        }

        if (fotoFavorita != null) {
            builder.fotoFavorita(fotoFavorita);
        }

        this.persistenciaMascota.create(builder.build());
        return this.IDS;
    }

    public List<Mascota> listarMascotas() {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (this.session.esCuidador()) {
            Cuidador cuidador = (Cuidador) this.session.getUsuario();
            return cuidador.getContratos().stream().map(ContratoCuidado::getMascotaAsociada).collect(Collectors.toList());
        } else {
            Dueno dueno = (Dueno) this.session.getUsuario();
            return dueno.getMascotas();
        }
    }
}
