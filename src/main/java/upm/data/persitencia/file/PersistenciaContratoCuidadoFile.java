package upm.data.persitencia.file;

import upm.data.modelo.ContratoCuidado;
import upm.data.persitencia.PersistenciaContratoCuidado;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PersistenciaContratoCuidadoFile extends PersistenciaFile<Long, ContratoCuidado> implements PersistenciaContratoCuidado {

    public PersistenciaContratoCuidadoFile(String fileName) {
        super(fileName);
    }

    @Override
    public void create(ContratoCuidado entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public Optional<ContratoCuidado> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(ContratoCuidado entidad) {
        this.objetos.put(entidad.getId(), entidad);
        this.saveToFile();
    }

    @Override
    public void delete(Long id) {
        this.objetos.remove(id);
        this.saveToFile();
    }

    @Override
    public List<ContratoCuidado> findAll() {
        return new LinkedList<>(this.objetos.values());
    }
}
