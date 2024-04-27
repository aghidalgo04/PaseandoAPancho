package upm.persitencia.map;

import upm.modelo.Usuario;
import upm.persitencia.Persistencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class PersistenciaMap<T> implements Persistencia<T> {
    private final Map<Long, T> map;
    private File file;

    PersistenciaMap() {
        this.map = new TreeMap<>();
    }

    @Override
    public void create(T t) {

    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public void update(T t) {

    }

    abstract List<T> getAll();
}
