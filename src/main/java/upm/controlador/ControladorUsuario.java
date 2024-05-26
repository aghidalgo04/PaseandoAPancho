package upm.controlador;

import servidor.ExternalRRSS;
import upm.controlador.excepciones.DuplicateException;
import upm.controlador.excepciones.NotFoundException;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.controlador.excepciones.SecurityProhibitionException;
import upm.data.modelo.ContratoCuidado;
import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Mascota;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaCuidador;
import upm.data.persitencia.PersistenciaDueno;
import upm.data.persitencia.PersistenciaMascota;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ControladorUsuario {
    private Long idsContratoCuidado;
    private final PersistenciaDueno persistenciaDueno;
    private final PersistenciaCuidador persistenciaCuidador;
    private PersistenciaMascota persistenciaMascota;
    private PersistenciaContratoCuidado persistenciaContratoCuidado;
    private Session session;

    public ControladorUsuario(PersistenciaDueno persistenciaDueno, PersistenciaCuidador persistenciaCuidador, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado, Session session) {
        this.persistenciaDueno = persistenciaDueno;
        this.persistenciaCuidador = persistenciaCuidador;
        this.persistenciaMascota = persistenciaMascota;
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
        if (!mascota.isPresent()) {
            throw new NotFoundException("Mascota no existe");
        }
        Dueno dueno = (Dueno) this.session.getUsuario();
        dueno.anadirMascota(mascota.get());
        this.persistenciaDueno.update(dueno);
    }

    public void contratarCuidador(Long idMascota, String idCuidador, LocalDateTime fechaInicioCuidado, LocalDateTime fechaFinCuidado) {
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
        ContratoCuidado contratoCuidado = new ContratoCuidado(++this.idsContratoCuidado, fechaInicioCuidado, fechaFinCuidado, LocalDateTime.now(), cuidador.get().getPrecio() * (fechaFinCuidado.getHour() - fechaInicioCuidado.getHour()) * 2D, dueno.buscarMascota(idMascota), cuidador.get());
        cuidador.get().anadirContratoCuidado(contratoCuidado);
        this.persistenciaContratoCuidado.create(contratoCuidado);
        this.persistenciaCuidador.update(cuidador.get());
    }
}
