package upm.data.persitencia.map;

import upm.data.modelo.Mascota;
import upm.data.persitencia.PersistenciaMascota;

public class PersistenciaMascotaMap extends PersistenciaMap<Mascota> implements PersistenciaMascota {

    public PersistenciaMascotaMap(String fileName) {
        super(fileName);
    }
}
