package upm.controlador;

import servidor.ExternalRRSS;
import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;

import java.io.File;
import java.util.List;

public class ControladorUsuario {
    private Long IDS;
    private PersistenciaUsuario persistenciaUsuario;
    private PersistenciaMascota persistenciaMascota;
    private PersistenciaContratoCuidado persistenciaContratoCuidado;

    public ControladorUsuario(PersistenciaUsuario persistenciaUsuario, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado) {
        this.IDS = 0L;
        this.persistenciaUsuario = persistenciaUsuario;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
    }

    public void regsitrarUsuarioComoDueno(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Dueno dueno = new Dueno(++this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.persistenciaUsuario.createDueno(dueno);
    }

    public void regsitrarUsuarioComoCuidador(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Cuidador cuidador = new Cuidador(++this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN);
        this.persistenciaUsuario.createCuidador(cuidador);
    }

    public void regsitrarUsuarioComoCuidadorConDocs(String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro, File foto, String descripcion, Integer precio, String IBAN, List<File> documentacion) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        Cuidador cuidador = new Cuidador(++this.IDS, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion);
        this.persistenciaUsuario.createCuidador(cuidador);
    }

    public void login(Plataforma plataforma) {
        String idUsuario = ExternalRRSS.LoginRRSS();
        // this.persistenciaUsuario.findDueno(idUsuario)
    }

    public void anadirMascota(Long idDueno, Long idMascota) {
        this.persistenciaUsuario.findDueno(idDueno).anadirMascota(this.persistenciaMascota.findById(idMascota));
    }

    public void contratarCuidador(Long idMascota, Long idCuidador) {
        System.out.println("Contratar: " + idCuidador); // @TODO temp
    }
}
