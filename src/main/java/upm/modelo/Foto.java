package upm.modelo;

import java.io.File;

public class Foto {
    private Long id;
    private File foto;

    public Foto(Long id, File foto) {
        this.id = id;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }
}
