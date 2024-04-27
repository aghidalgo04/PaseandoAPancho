package upm.modelo;

import upm.modelo.enums.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Usuario {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String direccion;
    private Idioma idioma;
    private Plataforma plataformaRegistro;
    private Map<Long, Mensaje> recibe;
    private Map<Long, Mensaje> envia;

    public Usuario(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.idioma = idioma;
        this.plataformaRegistro = plataformaRegistro;
        this.recibe = new HashMap<>();
        this.envia = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Plataforma getPlataformaRegistro() {
        return plataformaRegistro;
    }

    public void setPlataformaRegistro(Plataforma plataformaRegistro) {
        this.plataformaRegistro = plataformaRegistro;
    }

    public void anadirMensajeEnviado(Long id, Mensaje mensaje) {
        this.envia.put(id, mensaje);
    }

    public Mensaje buscarMensajeEnviadoPorId(Long id) {
        return this.envia.get(id);
    }

    public void anadirMensajeRecibido(Long id, Mensaje mensaje) {
        this.recibe.put(id, mensaje);
    }

    public Mensaje buscarMensajeRecibidoPorId(Long id) {
        return this.recibe.get(id);
    }
}

