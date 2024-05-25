package upm.controlador;

import servidor.ExternalRRSS;
import upm.controlador.excepciones.DuplicateException;
import upm.controlador.excepciones.NotFoundException;
import upm.controlador.excepciones.SecurityAuthorizationException;
import upm.controlador.excepciones.SecurityProhibitionException;
import upm.data.modelo.*;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ControladorUsuario {
    private Long IDS;
    private PersistenciaUsuario persistenciaUsuario;
    private PersistenciaMascota persistenciaMascota;
    private PersistenciaContratoCuidado persistenciaContratoCuidado;
    private Session session;

    public ControladorUsuario(PersistenciaUsuario persistenciaUsuario, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado, Session session) {
        this.IDS = 0L;
        this.persistenciaUsuario = persistenciaUsuario;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
        this.session = session;
    }

    public void registrarDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaUsuario.findDueno(idUsuario).isPresent() || this.persistenciaUsuario.findCuidador(idUsuario).isPresent()) {
            throw new DuplicateException("Usuario existe");
        }
        Dueno dueno = new Dueno(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaUsuario.createDueno(dueno);
    }

    public void registrarCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaUsuario.findDueno(idUsuario).isPresent() || this.persistenciaUsuario.findCuidador(idUsuario).isPresent()) {
            throw new DuplicateException("Usuario existe");
        }
        Cuidador cuidador = new Cuidador(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion);
        this.persistenciaUsuario.createCuidador(cuidador);
    }

    public void login(Plataforma plataforma) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Optional<Cuidador> cuidador = this.persistenciaUsuario.findCuidador(idUsuario);
        if (cuidador.isEmpty()) {
            Optional<Dueno> dueno = this.persistenciaUsuario.findDueno(idUsuario);
            if (dueno.isEmpty()) {
                throw new SecurityAuthorizationException("Usuario no existe");
            } else {
                this.session.setUsuario(dueno.get());
            }
        } else {
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
        if (mascota.isEmpty()) {
            throw new NotFoundException("Mascota no existe");
        }
        Dueno dueno = (Dueno) this.session.getUsuario();
        dueno.anadirMascota(mascota.get());
        this.persistenciaUsuario.updateDueno(dueno);
    }

    public void contratarCuidador(Long idMascota, String idCuidador, LocalDateTime fechaInicioCuidado, LocalDateTime fechaFinCuidado) {
        if (!this.session.estaLogueado()) {
            throw new SecurityAuthorizationException("No estás logueado");
        }
        if (!this.session.esDueno()) {
            throw new SecurityProhibitionException("No tienes acceso a la funcionalidad");
        }
        if (this.persistenciaUsuario.findCuidador(idCuidador).isEmpty()) {
            throw new NotFoundException("Cuidador no existe");
        }
        Dueno dueno = (Dueno) this.session.getUsuario();
        if (dueno.buscarMascota(idMascota) == null) {
            throw new NotFoundException("Mascota no existe");
        }
        int horas = fechaFinCuidado.getHour() - fechaInicioCuidado.getHour();
        this.persistenciaContratoCuidado.create(new ContratoCuidado(this.IDS, fechaInicioCuidado, fechaFinCuidado, LocalDateTime.now(), this.persistenciaUsuario.findCuidador(idCuidador).get().getPrecio() * horas * 2D, this.persistenciaMascota.findById(idMascota).get(), this.persistenciaUsuario.findCuidador(idCuidador).get()));
        this.persistenciaUsuario.findCuidador(idCuidador).get().anadirContratoCuidado(this.persistenciaContratoCuidado.findById(this.IDS).get());
        this.IDS++;
    }
}
