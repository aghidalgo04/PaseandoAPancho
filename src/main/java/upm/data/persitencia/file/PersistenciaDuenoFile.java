package upm.data.persitencia.file;

import upm.data.modelo.Dueno;
import upm.data.persitencia.PersistenciaDueno;

import java.util.List;
import java.util.Optional;

public class PersistenciaDuenoFile extends PersistenciaFile<String, Dueno> implements PersistenciaDueno  {

    public PersistenciaDuenoFile(String fileName) {
        super(fileName);
    }

    @Override
    public void create(Dueno entidad) {

    }

    @Override
    public Optional<Dueno> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Dueno entidad) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Dueno> findAll() {
        return List.of();
    }
}
