package upm.data.modelo;

import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dueno extends Usuario {
    private final List<Cuidador> cuidadoresFavoritos;
    private final List<Mascota> mascotas;

    public Dueno(){
        super();
        this.cuidadoresFavoritos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
    }

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
        return this.mascotas.stream().filter(m -> Objects.equals(m.getId(), id)).findFirst().orElse(null);
    }

    public void eliminarMascota(Mascota mascota) {
        this.mascotas.remove(mascota);
    }

    public void anadirCuidadorFavorito(Cuidador cuidador) {
        this.cuidadoresFavoritos.add(cuidador);
    }

    public Cuidador buscarCuidadorFavorito(String id) {
        return null;
    }

    public void eliminarCuidadorFavorito(Cuidador cuidadorFavorito) {
        this.cuidadoresFavoritos.remove(cuidadorFavorito);
    }
}
