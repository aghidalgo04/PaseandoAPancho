package upm.data.persitencia.map;

import upm.data.modelo.Mascota;
import upm.data.persitencia.PersistenciaMascota;

import java.util.List;

public class PersistenciaMascotaMap extends PersistenciaMap<Mascota> implements PersistenciaMascota {

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Mascota> findAll() {
        return this.getAll();
    }

    @Override
    List<Mascota> getAll(){
        return null;
    }

}
