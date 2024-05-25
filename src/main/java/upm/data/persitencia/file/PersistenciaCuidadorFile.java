package upm.data.persitencia.file;

import upm.data.modelo.Cuidador;
import upm.data.persitencia.PersistenciaCuidador;

import java.util.List;
import java.util.Optional;

public class PersistenciaCuidadorFile extends PersistenciaFile<String, Cuidador> implements PersistenciaCuidador {

    public PersistenciaCuidadorFile(String fileName) {
        super(fileName);
    }

    @Override
    public void create(Cuidador entidad) {

    }

    @Override
    public Optional<Cuidador> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Cuidador entidad) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Cuidador> findAll() {
        return List.of();
    }
}
