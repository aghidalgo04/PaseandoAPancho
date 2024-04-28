package upm.persitencia;

import upm.modelo.Mascota;

import java.util.List;

public interface PersistenciaMascota extends Persistencia<Mascota>{

    void delete(Long id);

    List<Mascota> findAll();
}
