package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PersistenciaUsuarioMap  implements PersistenciaUsuario {
    private final Map<Long, Dueno> persistenciaDueno;
    private final Map<Long, Cuidador> persistenciaCuidador;
    private File file;

    public PersistenciaUsuarioMap() {
        this.persistenciaDueno = new TreeMap<>();
        this.persistenciaCuidador = new TreeMap<>();
        this.file = null; // @TODO temp
    }

    @Override
    public void createDueno(Dueno dueno) {

    }

    @Override
    public void createCuidador(Cuidador cuidador) {

    }

    @Override
    public Dueno findDueno(String id) {
        return null;
    }

    @Override
    public Cuidador findCuidador(String id) {
        return null;
    }

    @Override
    public void updateDueno(Dueno dueno) {

    }

    @Override
    public void updateCuidador(Cuidador cuidador) {

    }

    @Override
    public void delete(Entity entity) {

    }
}
