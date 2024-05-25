package upm.data.persitencia.adaptadores;

import upm.data.modelo.Mensaje;
import upm.data.modelo.Usuario;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.util.ArrayList;
import java.util.List;

public abstract class AdaptadorUsuario {
    private final String id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String direccion;
    private Idioma idioma;
    private Plataforma plataformaRegistro;
    private List<Long> recibe;
    private List<Long> envia;

    public AdaptadorUsuario(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.correoElectronico = usuario.getCorreoElectronico();
        this.direccion = usuario.getDireccion();
        this.idioma = usuario.getIdioma();
        this.plataformaRegistro = usuario.getPlataformaRegistro();
        this.recibe = usuario.getIdRecibe();
        this.envia = usuario.getIdEnvia();
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public Idioma getIdioma() {
        return this.idioma;
    }

    public Plataforma getPlataformaRegistro() {
        return this.plataformaRegistro;
    }

    public List<Long> getRecibe() {
        return this.recibe;
    }

    public List<Long> getEnvia() {
        return this.envia;
    }
}
