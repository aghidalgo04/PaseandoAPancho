package upm.modelo;

import upm.modelo.enums.*;

import java.util.HashMap;
import java.util.Map;

public class Dueno extends Usuario {
    private final Map<Long, Cuidador> cuidadoresFavoritos;
    private final Map<Long, Mascota> mascotas;

    public Dueno(Long id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.cuidadoresFavoritos = new HashMap<>();
        this.mascotas = new HashMap<>();
    }

    public void anadirMascota(Mascota mascota) {
        this.mascotas.put(mascota.getId(), mascota);
    }

    public Mascota buscarMascota(Long id) {
        return this.mascotas.get(id);
    }

    public void eliminarMascota(Long id) {
        this.mascotas.remove(id);
    }

    public void anadirCuidadorFavorito(Cuidador cuidador) {
        this.cuidadoresFavoritos.put(cuidador.getId(), cuidador);
    }

    public Cuidador buscarCuidadorFavorito(Long id) {
        return this.cuidadoresFavoritos.get(id);
    }

    public void eliminarCuidadorFavorito(Long id) {
        this.cuidadoresFavoritos.remove(id);
    }
}
