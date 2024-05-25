package upm.data.modelo;

import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dueno extends Usuario {
    private final List<Cuidador> cuidadoresFavoritos;
    private final List<Mascota> mascotas;

    public Dueno(String id, String nombre, String apellidos, String correoElectronico, String direccion, Idioma idioma, Plataforma plataformaRegistro) {
        super(id, nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro);
        this.cuidadoresFavoritos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
    }

    public List<Mascota> getMascotas() {
        return this.mascotas;
    }

    public void anadirMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    public Mascota buscarMascota(Long id) {
        return null;
    }

    public void eliminarMascota(Mascota mascota) {
        this.mascotas.remove(mascota);
    }

    public void anadirCuidadorFavorito(Cuidador cuidador) {
        this.cuidadoresFavoritos.add(cuidador);
    }

    public Cuidador buscarCuidadorFavorito(Long id) {
        return null;
    }

    public void eliminarCuidadorFavorito(Cuidador cuidadorFavorito) {
        this.cuidadoresFavoritos.remove(cuidadorFavorito);
    }

    public List<String> getIdCuidadoresFavoritos() {
        List<String> idCuidadoresFavoritos = new ArrayList<>();
        this.cuidadoresFavoritos.forEach(cuidador -> idCuidadoresFavoritos.add(cuidador.getId()));
        return idCuidadoresFavoritos;
    }

    public List<Long> getIdMascotas() {
        List<Long> idMascotas = new ArrayList<>();
        this.mascotas.forEach(mascota -> idMascotas.add(mascota.getId()));
        return idMascotas;

    }
}
