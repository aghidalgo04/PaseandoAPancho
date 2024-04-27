package upm.modelo;

import java.util.Iterator;
import java.util.List;

public class Album {
    private Long id;
    private List<Foto> fotos;
    private String titulo;

    public Album(Long id, List<Foto> fotos, String titulo) {
        this.id = id;
        this.fotos = fotos;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void anadirFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public Foto buscarFotoPorId(Long id) {
        Iterator<Foto> fotosIterator = this.fotos.iterator();
        while (fotosIterator.hasNext()) {
            if (fotosIterator.next().getId().equals(id)) {
                return fotosIterator.next();
            }
        }
        return null;
    }

    public void eliminarFoto(Foto foto) {
        this.fotos.remove(foto);
    }
}
