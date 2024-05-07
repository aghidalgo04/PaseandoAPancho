package upm.data.persitencia;

import upm.data.modelo.Mascota;

import java.util.List;

public interface PersistenciaMascota extends Persistencia<Mascota>{
    List<Mascota> findAll();
}
