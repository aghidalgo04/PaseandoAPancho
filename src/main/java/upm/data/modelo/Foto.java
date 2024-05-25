package upm.data.modelo;

import java.io.File;
import java.io.Serializable;

public class Foto implements Serializable {
    private final Long id;
    private File foto;

    public Foto(Long id, File foto) {
        this.id = id;
        this.foto = foto;
    }

    public Long getId() {
        return this.id;
    }

    public File getFoto() {
        return this.foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }
}
