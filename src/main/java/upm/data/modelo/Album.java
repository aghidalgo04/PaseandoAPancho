package upm.data.modelo;

import java.util.List;

public class Album {
    private final Long id;
    private String titulo;
    private List<Foto> fotos;

    public Album(Long id, List<Foto> fotos, String titulo) {
        this.id = id;
        this.fotos = fotos;
        this.titulo = titulo;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Foto> getFotos() {
        return this.fotos;
    }

    public void anadirFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public Foto buscarFotoPorId(Long id) {
        return this.fotos.stream()
                .filter(foto -> foto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public void eliminarFoto(Foto foto) {
        this.fotos.remove(foto);
    }
}
