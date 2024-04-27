package upm.persitencia.map;

import upm.modelo.Usuario;
import upm.persitencia.PersistenciaUsuario;

import java.util.List;

public class PersistenciaUsuarioMap extends PersistenciaMap<Usuario> implements PersistenciaUsuario {

    @Override
    public void delete(Long id) {

    }

    @Override
    List<Usuario> getAll(){
        return null;
    }
}
