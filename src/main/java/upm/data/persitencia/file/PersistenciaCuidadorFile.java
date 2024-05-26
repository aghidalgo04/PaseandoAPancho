package upm.data.persitencia.file;

import com.fasterxml.jackson.core.type.TypeReference;
import upm.data.modelo.Cuidador;
import upm.data.persitencia.PersistenciaCuidador;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersistenciaCuidadorFile extends PersistenciaFile<String, Cuidador> implements PersistenciaCuidador {

    public PersistenciaCuidadorFile(String fileName) {
        super(fileName, new TypeReference<Map<String, Cuidador>>() {
        });
    }

    @Override
    public void create(Cuidador entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public Optional<Cuidador> findById(String id) {
        return Optional.ofNullable(this.objetos.get(id));
    }

    @Override
    public void update(Cuidador entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public void delete(String id) {
        this.objetos.remove(id);
        this.saveToFile();
    }

    @Override
    public List<Cuidador> findAll() {
        return new LinkedList<>(this.objetos.values());
    }
}