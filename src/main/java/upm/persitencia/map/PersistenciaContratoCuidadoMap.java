package upm.persitencia.map;

import upm.modelo.ContratoCuidado;
import upm.persitencia.PersistenciaContratoCuidado;

import java.util.List;

public class PersistenciaContratoCuidadoMap extends PersistenciaMap<ContratoCuidado> implements PersistenciaContratoCuidado {

    @Override
    List<ContratoCuidado> getAll(){
        return null;
    }


    @Override
    public void create(ContratoCuidado contratoCuidado) {

    }

    @Override
    public ContratoCuidado findById(Long id) {
        return null;
    }

    @Override
    public void update(ContratoCuidado contratoCuidado) {

    }

    @Override
    public void delete(Long id) {

    }
}
