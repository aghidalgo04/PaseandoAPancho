package upm.data.persitencia.map;

import upm.data.modelo.ContratoCuidado;
import upm.data.persitencia.PersistenciaContratoCuidado;

public class PersistenciaContratoCuidadoMap extends PersistenciaMap<ContratoCuidado> implements PersistenciaContratoCuidado {
    public PersistenciaContratoCuidadoMap(String fileName) {
        super(fileName);
    }

    @Override
    protected Long getId(ContratoCuidado contratoCuidado) {
        return contratoCuidado.getId();
    }
}
