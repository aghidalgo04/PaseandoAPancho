package upm.controlador;

import servidor.ExternalRRSS;
import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Mascota;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class ControladorUsuario {
    private PersistenciaUsuario persistenciaUsuario;
    private PersistenciaMascota persistenciaMascota;
    private PersistenciaContratoCuidado persistenciaContratoCuidado;

    public ControladorUsuario(PersistenciaUsuario persistenciaUsuario, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado) {
        this.persistenciaUsuario = persistenciaUsuario;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
    }

    public void regsitrarUsuarioComoDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Dueno dueno = new Dueno(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaUsuario.createDueno(dueno);
    }

    public void regsitrarUsuarioComoCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Cuidador cuidador = new Cuidador(idUsuario, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN);
        this.persistenciaUsuario.createCuidador(cuidador);
    }

    public void regsitrarUsuarioComoCuidadorConDocs(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        String idUsuario = ExternalRRSS.LoginRRSS();
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
                // guardar usuario a seccion
            }
        } else {
            //  guardar usuario a seccion
        }

    }

    public void anadirMascota(Long idMascota) {
        // Comporbar esta loguedo Dueno y cocojer objeto
        Optional<Mascota> mascota = this.persistenciaMascota.findById(idMascota);
        if (!mascota.isPresent()) {
            throw new RuntimeException("Mascota no existe"); // @TODO cambiar por exception personal
        }
        dueno.get().anadirMascota(mascota.get());
        this.persistenciaUsuario.updateDueno(dueno.get());
    }

    public void contratarCuidador(Long idMascota, Long idCuidador) {
        System.out.println("Contratar: " + idCuidador); // @TODO temp
    }
}
