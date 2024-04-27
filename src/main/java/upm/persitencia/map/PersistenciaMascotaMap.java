package upm.persitencia.map;

import upm.persitencia.PersistenciaMascota;

import java.util.List;

public class PersistenciaMascotaMap extends PersistenciaMap<Mascota> implements PersistenciaMascota {

    @Override
    List<Mascota> getAll(){
        return null;
    }


    @Override
    public void create(Mascota mascota) {

    }

    @Override
    public Mascota findById(Long id) {
        return null;
    }

    @Override
    public void update(Mascota mascota) {

    }

    @Override
    public void delete(Long id) {

    }
}
