package upm.data.persitencia;

import upm.data.modelo.Usuario;

import java.util.List;

public interface PersistenciaUsuario extends Persistencia<Usuario> {
    List<Usuario> getAll();
}
