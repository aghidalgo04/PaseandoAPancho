package upm.persitencia;

import upm.modelo.Usuario;

public interface PersistenciaUsuario extends Persistencia<Usuario>{

    void delete(Long id);
}
