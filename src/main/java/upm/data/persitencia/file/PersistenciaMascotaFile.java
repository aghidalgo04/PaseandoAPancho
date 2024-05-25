package upm.data.persitencia.file;

import upm.data.modelo.Mascota;
import upm.data.persitencia.PersistenciaMascota;

import java.util.List;
import java.util.Optional;

public class PersistenciaMascotaFile extends PersistenciaFile<Long, Mascota> implements PersistenciaMascota {

    public PersistenciaMascotaFile(String fileName) {
        super(fileName);
    }

    @Override
    public void create(Mascota entidad) {

    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Mascota entidad) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Mascota> findAll() {
        return List.of();
    }
}
