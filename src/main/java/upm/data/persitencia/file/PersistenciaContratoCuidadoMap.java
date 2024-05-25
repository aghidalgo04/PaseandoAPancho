package upm.data.persitencia.file;

import upm.data.modelo.ContratoCuidado;
import upm.data.persitencia.PersistenciaContratoCuidado;

import java.util.List;
import java.util.Optional;

public class PersistenciaContratoCuidadoMap extends PersistenciaFile<Long, ContratoCuidado> implements PersistenciaContratoCuidado {

    public PersistenciaContratoCuidadoMap(String fileName) {
        super(fileName);
    }

    @Override
    public void create(ContratoCuidado entidad) {

    }

    @Override
    public Optional<ContratoCuidado> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(ContratoCuidado entidad) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ContratoCuidado> findAll() {
        return List.of();
    }
}
