package upm.persitencia.map;

import upm.modelo.Mascota;
import upm.persitencia.PersistenciaMascota;

import java.util.List;

public class PersistenciaMascotaMap extends PersistenciaMap<Mascota> implements PersistenciaMascota {

    @Override
    public void delete(Long id) {

    }

    @Override
    List<Mascota> getAll(){
        return null;
    }

}
