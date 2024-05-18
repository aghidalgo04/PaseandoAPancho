package upm.data.persitencia.map;

import upm.data.persitencia.Persistencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersistenciaMap<T> implements Persistencia<T> {
    private final Map<Long, T> persistencia;
    private File file;

    public PersistenciaMap(String fileName) {
        this.persistencia = new TreeMap<>();
        this.file = new File("persistenciaFile/" + fileName);
    }

    @Override
    public void create(T entidad) {

    }

    @Override
    public Optional<T> findById(Long id) {
        return null;
    }

    @Override
    public void update(T entidad) {

    }

    @Override
    public void delete(Long id) {

    }

    public List<T> findAll() {
        return null;
    }
}
