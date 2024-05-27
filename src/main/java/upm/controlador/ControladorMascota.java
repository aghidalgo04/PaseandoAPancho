package upm.controlador;

import servidor.ExternalRIAC;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.data.modelo.*;
import upm.data.modelo.excepciones.InvalidAttributeException;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaMascotaExotica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorMascota {
    private Long idsMascota;
    private final PersistenciaMascota persistenciaMascota;
    private final PersistenciaMascotaExotica persistenciaMascotaExotica;
    private final Session session;

    public ControladorMascota(PersistenciaMascota persistenciaMascota, PersistenciaMascotaExotica persistenciaMascotaExotica, Session session) {
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaMascotaExotica = persistenciaMascotaExotica;
        this.session = session;

        this.idsMascota = (long) persistenciaMascota.findAll().size() + (long) persistenciaMascotaExotica.findAll().size();
    }


    public Long crearMascota(String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (!ExternalRIAC.RIAC(codigoRIAC)) {
            throw new InvalidAttributeException("Codigo RIAC no valido");
        }

        Mascota.Builder builder = new Mascota.Builder()
                .id(++this.idsMascota)
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
        return this.idsMascota;
    }

    public Long crearMascotaExotica(String nombre, String direccion, String descripcion, String codigoRIAC, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles, String polizaSeguro, List<Album> albums, Foto fotoFavorita) {
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
                .id(++this.idsMascota)
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

        this.persistenciaMascotaExotica.create(builder.build());
        return this.idsMascota;
    }

    public List<Mascota> listarMascotas() {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estas loguedo");
        }
        if (this.session.esCuidador()) {
            Cuidador cuidador = (Cuidador) this.session.getUsuario();
            DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern(ContratoCuidado.FORMATO_FECHA);
            return cuidador.getContratos().stream()
                    .filter(contratoCuidado -> LocalDateTime.parse(contratoCuidado.getFechaInicioDeCuidado(),dateTimeFormatter).isBefore(LocalDateTime.now()) && LocalDateTime.parse(contratoCuidado.getFechaFinDeCuidado(),dateTimeFormatter).isAfter(LocalDateTime.now()))
                    .map(ContratoCuidado::getMascotaAsociada)
                    .collect(Collectors.toList());
        } else {
            Dueno dueno = (Dueno) this.session.getUsuario();
            return dueno.getMascotas();
        }
    }
}
