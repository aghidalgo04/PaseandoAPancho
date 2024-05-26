package upm.data.persitencia.file;

import upm.data.modelo.Mascota;
import upm.data.modelo.MascotaExotica;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaMascotaExotica;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PersistenciaMascotaExoticaFile extends PersistenciaFile<Long, MascotaExotica> implements PersistenciaMascotaExotica {

    public PersistenciaMascotaExoticaFile(String fileName) {
        super(fileName);
    }

    @Override
    public void create(MascotaExotica entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public Optional<MascotaExotica> findById(Long id) {
        return Optional.ofNullable(this.objetos.get(id));
    }

    @Override
    public void update(MascotaExotica entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public void delete(Long id) {
        this.objetos.remove(id);
        this.saveToFile();
    }

    @Override
    public List<MascotaExotica> findAll() {
        return new LinkedList<>(this.objetos.values());
    }
}
