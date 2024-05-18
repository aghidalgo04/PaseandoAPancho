package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.persitencia.PersistenciaUsuario;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersistenciaUsuarioMap  implements PersistenciaUsuario {
    private final Map<String, Dueno> persistenciaDueno;
    private final Map<String, Cuidador> persistenciaCuidador;
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
    public Optional<Dueno> findDueno(String id) {
        return null;
    }

    @Override
    public Optional<Cuidador> findCuidador(String id) {
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
