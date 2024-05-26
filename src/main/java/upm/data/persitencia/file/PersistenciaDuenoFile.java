package upm.data.persitencia.file;

import com.fasterxml.jackson.core.type.TypeReference;
import upm.data.modelo.Dueno;
import upm.data.persitencia.PersistenciaDueno;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersistenciaDuenoFile extends PersistenciaFile<String, Dueno> implements PersistenciaDueno {

    public PersistenciaDuenoFile(String fileName) {
        super(fileName, new TypeReference<Map<String, Dueno>>() {
        });
    }

    @Override
    public void create(Dueno entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public Optional<Dueno> findById(String id) {
        return Optional.ofNullable(this.objetos.get(id));
    }

    @Override
    public void update(Dueno entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public void delete(String id) {
        this.objetos.remove(id);
        this.saveToFile();
    }

    @Override
    public List<Dueno> findAll() {
        return new LinkedList<>(this.objetos.values());
    }
}
