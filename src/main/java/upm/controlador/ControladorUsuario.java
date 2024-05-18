package upm.controlador;

import jdk.vm.ci.meta.Local;
import servidor.ExternalRRSS;
import upm.cli.comandos.Session;
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

    public void regsitrarDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaUsuario.findDueno(idUsuario).isPresent() || this.persistenciaUsuario.findCuidador(idUsuario).isPresent()) {
            throw new RuntimeException("Usuario existe"); // @TODO cambiar por exception personal
        }
        Dueno dueno = new Dueno(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaUsuario.createDueno(dueno);
    }

    public void regsitrarCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        if (this.persistenciaUsuario.findDueno(idUsuario).isPresent() || this.persistenciaUsuario.findCuidador(idUsuario).isPresent()) {
            throw new RuntimeException("Usuario existe"); // @TODO cambiar por exception personal
        }
        Cuidador cuidador = new Cuidador(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion);
        this.persistenciaUsuario.createCuidador(cuidador);
    }

    public void login() {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Optional<Cuidador> cuidador = this.persistenciaUsuario.findCuidador(idUsuario);
        if (!cuidador.isPresent()) {
            Optional<Dueno> dueno = this.persistenciaUsuario.findDueno(idUsuario);
            if (!dueno.isPresent()) {
                throw new RuntimeException("Usuario no existe"); // @TODO cambiar por exception personal
            } else {
                this.session.setUsuarioLogueado(dueno.get());
            }
        } else {
            this.session.setUsuarioLogueado(cuidador.get());
        }

    }

    public void anadirMascota(Long idMascota, String idDueno) {
        if (!this.session.getUsuario().getId().equals(idDueno)) {
            throw new RuntimeException("Dueno no está logueado"); // @TODO cambiar por exception personal
        }
        Optional<Mascota> mascota = this.persistenciaMascota.findById(idMascota);
        if (!mascota.isPresent()) {
            throw new RuntimeException("Mascota no existe"); // @TODO cambiar por exception personal
        }
        Optional<Dueno> dueno = this.persistenciaUsuario.findDueno(session.getUsuario().getId());
        if(!dueno.isPresent()){
            throw new RuntimeException("Dueno no existe");
        }
        dueno.get().anadirMascota(mascota.get());
        this.persistenciaUsuario.updateDueno(dueno.get());
    }

    public void contratarCuidador(Long idMascota, String idDueno, String idCuidador, LocalDateTime fechaInicioCuidado, LocalDateTime fechaFinCuidado) {
        if (!this.session.getUsuario().getId().equals(idDueno)) {
            throw new RuntimeException("Dueno no está logueado"); // @TODO cambiar por exception personal
        }
        if (!this.persistenciaUsuario.findCuidador(idCuidador).isPresent()) {
            throw new RuntimeException("Cuidador no existe"); // @TODO cambiar por exception personal
        }
        if (this.persistenciaUsuario.findDueno(idDueno).get().buscarMascota(idMascota) == null) {
            throw new RuntimeException("Mascota no existe o es del dueno"); // @TODO cambiar por exception personal
        }
        int horas = fechaFinCuidado.getHour() - fechaInicioCuidado.getHour();
        this.persistenciaContratoCuidado.create(new ContratoCuidado(this.IDS, fechaInicioCuidado, fechaFinCuidado, LocalDateTime.now(), this.persistenciaUsuario.findCuidador(idCuidador).get().getPrecio() * horas * 2D, this.persistenciaMascota.findById(idMascota).get(), this.persistenciaUsuario.findCuidador(idCuidador).get(), new Notificacion(this.IDS + 1)));
        this.persistenciaUsuario.findCuidador(idCuidador).get().anadirContratoCuidado(this.persistenciaContratoCuidado.findById(this.IDS).get());
        this.IDS += 2;
    }

    public void regsitrarUsuarioComoCuidador(String parametro, String parametro1, String parametro2, String parametro3, Object o, Object o1, Object o2, String parametro4, int i, String parametro5) {
        // @TODO hacer metodo ¿No es repetido?
    }

    public void regsitrarUsuarioComoCuidadorConDocs(String parametro, String parametro1, String parametro2, String parametro3, Object o, Object o1, Object o2, String parametro4, int i, String parametro5, Object o3) {
        // @TODO hacer metodo ¿No es repetido?
    }


    public void regsitrarUsuarioComoDueno(String parametro, String parametro1, String parametro2, String parametro3, Object o, Object o1) {
        // @TODO hacer metodo ¿No es repetido?
    }
}
