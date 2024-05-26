package upm.controlador;

import servidor.ExternalRRSS;
import upm.controlador.excepciones.DuplicateException;
import upm.controlador.excepciones.NotFoundException;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.controlador.excepciones.SecurityProhibitionException;
import upm.data.modelo.*;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class ControladorUsuario {
    private Long idsContratoCuidado;
    private final PersistenciaDueno persistenciaDueno;
    private final PersistenciaCuidador persistenciaCuidador;
    private final PersistenciaMascota persistenciaMascota;
    private final PersistenciaMascotaExotica persistenciaMascotaExotica;
    private final PersistenciaContratoCuidado persistenciaContratoCuidado;
    private Session session;

    public ControladorUsuario(PersistenciaDueno persistenciaDueno, PersistenciaCuidador persistenciaCuidador, PersistenciaMascota persistenciaMascota, PersistenciaMascotaExotica persistenciaMascotaExotica, PersistenciaContratoCuidado persistenciaContratoCuidado, Session session) {
        this.persistenciaDueno = persistenciaDueno;
        this.persistenciaCuidador = persistenciaCuidador;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaMascotaExotica = persistenciaMascotaExotica;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
        this.session = session;

        this.idsContratoCuidado = (long) persistenciaContratoCuidado.findAll().size();
    }

    public void registrarDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaDueno.findById(idUsuario).isPresent() || this.persistenciaCuidador.findById(idUsuario).isPresent()) {
            throw new DuplicateException("Usuario existe");
        }
        Dueno dueno = new Dueno(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaDueno.create(dueno);
    }

    public void registrarCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaDueno.findById(idUsuario).isPresent() || this.persistenciaCuidador.findById(idUsuario).isPresent()) {
            throw new DuplicateException("Usuario existe");
        }
        Cuidador cuidador = new Cuidador(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion);
        this.persistenciaCuidador.create(cuidador);
    }

    public void login(Plataforma plataforma) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Optional<Cuidador> cuidador = this.persistenciaCuidador.findById(idUsuario);
        if (!cuidador.isPresent()) {
            Optional<Dueno> dueno = this.persistenciaDueno.findById(idUsuario);
            if (!dueno.isPresent()) {
                throw new SecurityAuthorizationException("Usuario no existe");
            }
            if (!dueno.get().getPlataformaRegistro().equals(plataforma)) {
                throw new SecurityAuthorizationException("Plataforma incorrecta");
            }
            this.session.setUsuario(dueno.get());

        } else {
            if (!cuidador.get().getPlataformaRegistro().equals(plataforma)) {
                throw new SecurityAuthorizationException("Plataforma incorrecta");
            }
            this.session.setUsuario(cuidador.get());
        }
    }

    public void anadirMascota(Long idMascota) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estás logueado");
        }
        if (!this.session.esDueno()) {
            throw new SecurityProhibitionException("No tienes acceso a la funcionalidad");
        }
        Optional<Mascota> mascota = this.persistenciaMascota.findById(idMascota);
        Optional<MascotaExotica> mascotaExotica = this.persistenciaMascotaExotica.findById(idMascota);
        if (!mascota.isPresent()) {
            if (!mascotaExotica.isPresent()) {
                throw new  NotFoundException("Mascota no existe");
            }
        }
        Dueno dueno = (Dueno) this.session.getUsuario();
        mascota.ifPresent(dueno::anadirMascota);
        mascotaExotica.ifPresent(dueno::anadirMascota);
        this.persistenciaDueno.update(dueno);
    }

    public void contratarCuidador(Long idMascota, String idCuidador, String fechaInicioCuidado, String fechaFinCuidado) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estás logueado");
        }
        if (!this.session.esDueno()) {
            throw new SecurityProhibitionException("No tienes acceso a la funcionalidad");
        }
        Optional<Cuidador> cuidador = this.persistenciaCuidador.findById(idCuidador);
        if (!cuidador.isPresent()) {
            throw new NotFoundException("Cuidador no existe");
        }
        Dueno dueno = (Dueno) this.session.getUsuario();
        if (dueno.buscarMascota(idMascota) == null) {
            throw new NotFoundException("Mascota no existe");
        }
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm");
        LocalDateTime fechaFin = LocalDateTime.parse(fechaFinCuidado, dateTimeFormatter);
        LocalDateTime fechaIn = LocalDateTime.parse(fechaInicioCuidado, dateTimeFormatter);
        ContratoCuidado contratoCuidado = new ContratoCuidado(++this.idsContratoCuidado, fechaInicioCuidado, fechaFinCuidado, LocalDateTime.now().format(dateTimeFormatter), cuidador.get().getPrecio() * (fechaFin.getHour() - fechaIn.getHour()) * 2D, dueno.buscarMascota(idMascota));
        cuidador.get().anadirContratoCuidado(contratoCuidado);
        this.persistenciaContratoCuidado.create(contratoCuidado);
        this.persistenciaCuidador.update(cuidador.get());
    }
}
