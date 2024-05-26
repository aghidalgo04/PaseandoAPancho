package upm.data.persitencia.file;

import com.fasterxml.jackson.core.type.TypeReference;
import upm.data.modelo.Mascota;
import upm.data.persitencia.PersistenciaMascota;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersistenciaMascotaFile extends PersistenciaFile<Long, Mascota> implements PersistenciaMascota {

    public PersistenciaMascotaFile(String fileName) {
        super(fileName, new TypeReference<Map<Long, Mascota>>() {
        });
    }

    @Override
    public void create(Mascota entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.ofNullable(this.objetos.get(id));
    }

    @Override
    public void update(Mascota entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public void delete(Long id) {
        this.objetos.remove(id);
        this.saveToFile();
    }

    @Override
    public List<Mascota> findAll() {
        return new LinkedList<>(this.objetos.values());
    }
}
