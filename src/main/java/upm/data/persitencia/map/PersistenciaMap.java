package upm.data.persitencia.map;

import upm.data.modelo.Mascota;
import upm.data.persitencia.Persistencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

abstract public class PersistenciaMap<T> implements Persistencia<T> {
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
        return Optional.of(this.persistencia.get(id));
    }

    @Override
    public void update(T entidad) {
        persistencia.put(this.getId(entidad),entidad);
    }

    @Override
    public void delete(Long id) {

    }

    public List<T> findAll() {
        return null;
    }

    abstract protected Long getId(T entidad);
}
