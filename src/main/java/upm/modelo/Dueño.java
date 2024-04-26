package upm.modelo;

import upm.modelo.enums.*;

import java.util.Set;
import java.util.HashSet;

public class Dueño extends Usuario {
    private Set<Cuidador> cuidadoresFavoritos;
    public Dueño(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.cuidadoresFavoritos = new HashSet<>();
    }

    public void anadirMascota(Mascota mascota) {
    }

    public Mascota buscarMascotaPorId(Long id) {
        return null;
    }

    public void eliminarMascota(Long id) {
    }

    public Cuidador buscarCuidadorFavoritoPorId(Long id) {
        return null;
    }

    public void eliminarCuidadorFavorito(Long id) {
    }

    @Override
    public void anadirMensajeEnviado(Mensaje mensaje) {

    }

    @Override
    public Mensaje buscarMensajeEnviadoPorId(Long id) {
        return null;
    }

    @Override
    public void anadirMensajeRecibido(Mensaje mensaje) {

    }

    @Override
    public Mensaje buscarMensajeRecibidoPorId(Long id) {
        return null;
    }

    public void anadirCuidadorFavorito(Cuidador cuidador) {
        cuidadoresFavoritos.add(cuidador);
    }

    public boolean esCuidadorFavorito(Cuidador cuidador) {
        return cuidadoresFavoritos.contains(cuidador);
    }

    public void eliminarCuidadorFavorito(Cuidador cuidador) {
        cuidadoresFavoritos.remove(cuidador);
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public String getApellidos() {
        return null;
    }

    @Override
    public String getCorreoElectronico() {
        return null;
    }

    @Override
    public Idioma getIdioma() {
        return null;
    }

    @Override
    public Plataforma getPlataformaRegistro() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {

    }

    @Override
    public void setApellidos(String apellidos) {

    }

    @Override
    public void setCorreoElectronico(String correo) {

    }

    @Override
    public void setDireccion(String direccion) {

    }

    @Override
    public void setIdioma(Idioma idioma) {

    }
}
