package upm.persitencia;

import upm.modelo.Mascota;

public interface PersistenciaMascota extends Persistencia<Mascota>{

    void delete(Long id);
}
