package upm.modelo;

import upm.modelo.enums.*;
import java.util.HashSet;
import java.util.Set;

public abstract class Usuario {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String direccion;
    private Idioma idioma;
    private Plataforma plataformaRegistro;
    private Set<Mensaje> recibidos;
    private Set<Mensaje> enviados;

    public Usuario(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.idioma = idioma;
        this.plataformaRegistro = plataformaRegistro;
        this.enviados = new HashSet<>();
        this.recibidos = new HashSet<>();
    }

    public abstract void anadirMensajeEnviado(Mensaje mensaje);

    public abstract Mensaje buscarMensajeEnviadoPorId(Long id);

    public abstract void anadirMensajeRecibido(Mensaje mensaje);

    public abstract Mensaje buscarMensajeRecibidoPorId(Long id);


    public abstract Long getId();

    public abstract String getNombre();

    public abstract String getApellidos();

    public abstract String getCorreoElectronico();

    public abstract Idioma getIdioma();

    public abstract Plataforma getPlataformaRegistro();

    public abstract void setNombre(String nombre);

    public abstract void setApellidos(String apellidos);

    public abstract void setCorreoElectronico(String correo);

    public abstract void setDireccion(String direccion);

    public abstract void setIdioma(Idioma idioma);
}

