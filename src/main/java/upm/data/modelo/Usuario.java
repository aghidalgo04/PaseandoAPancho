package upm.data.modelo;

import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Serializable {
    private final String id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String direccion;
    private Idioma idioma;
    private Plataforma plataformaRegistro;
    private List<Mensaje> recibe;
    private List<Mensaje> envia;

    public Usuario(String id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.idioma = idioma;
        this.plataformaRegistro = plataformaRegistro;
        this.recibe = new ArrayList<>();
        this.envia = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Idioma getIdioma() {
        return this.idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Plataforma getPlataformaRegistro() {
        return this.plataformaRegistro;
    }

    public void setPlataformaRegistro(Plataforma plataformaRegistro) {
        this.plataformaRegistro = plataformaRegistro;
    }

    public void anadirMensajeEnviado(Long id, Mensaje mensaje) {
        this.envia.add(mensaje);
    }

    public Mensaje buscarMensajeEnviadoPorId(Long id) {
        return null;
    }

    public void anadirMensajeRecibido(Long id, Mensaje mensaje) {
        this.recibe.add(mensaje);
    }

    public Mensaje buscarMensajeRecibidoPorId(Long id) {
        return null;
    }

    public List<Long> getIdRecibe() {
        List<Long> lista = new ArrayList<>();
        this.recibe.forEach(mensaje -> lista.add(mensaje.getId()));
        return lista;
    }

    public List<Long> getIdEnvia() {
        List<Long> lista = new ArrayList<>();
        this.envia.forEach(mensaje -> lista.add(mensaje.getId()));
        return lista;
    }
}

