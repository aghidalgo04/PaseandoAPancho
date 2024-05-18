package upm.data.persitencia;

import upm.data.modelo.Mascota;

import java.util.Optional;

public interface PersistenciaMascota extends Persistencia<Mascota> {
    Optional<Mascota> findByCodigoRIAC(String codigoRIAC);
}
