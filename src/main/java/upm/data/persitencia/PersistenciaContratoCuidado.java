package upm.data.persitencia;

import upm.data.modelo.ContratoCuidado;

import java.util.List;

public interface PersistenciaContratoCuidado extends Persistencia<ContratoCuidado> {
    List<ContratoCuidado> findAll();
}
