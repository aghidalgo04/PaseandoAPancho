package upm.controlador;

import upm.modelo.Cuidador;
import upm.modelo.Dueno;
import upm.modelo.Mascota;
import upm.modelo.Usuario;
import upm.modelo.enums.Idioma;
import upm.modelo.enums.Plataforma;
import upm.persitencia.PersistenciaContratoCuidado;
import upm.persitencia.PersistenciaMascota;
import upm.persitencia.PersistenciaUsuario;

import java.io.File;
import java.util.List;

public class ControladorUsuario {
    private Long IDS;
    private PersistenciaUsuario persistenciaUsuario;
    private PersistenciaMascota persistenciaMascota;
    private PersistenciaContratoCuidado persistenciaContratoCuidado;

    public ControladorUsuario(PersistenciaUsuario persistenciaUsuario, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado) {
        this.IDS = 0l;
        this.persistenciaUsuario = persistenciaUsuario;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
    }

    public void regsitrarUsuarioComoDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        this.IDS++;
        Usuario usuario = new Dueno(this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaUsuario.create(usuario);
    }

    public void regsitrarUsuarioComoCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        this.IDS++;
        Usuario usuario = new Cuidador(this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN);
        this.persistenciaUsuario.create(usuario);
    }

    public void regsitrarUsuarioComoCuidadorConDocs(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        this.IDS++;
        Usuario usuario = new Cuidador(this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion);
        this.persistenciaUsuario.create(usuario);
    }

    public void login(Plataforma plataforma) {
        System.out.println("Login: " + plataforma);
    }

    public void anadirMascota(Long idDueno, Long idMascota) {
        Dueno dueno = (Dueno) this.persistenciaUsuario.findById(idDueno);
        dueno.anadirMascota(this.persistenciaMascota.findById(idMascota));
    }

    public void contratarCuidador(Long idMascota, Long idCuidador) {
        System.out.println("Contratar: " + idCuidador);
    }
}
