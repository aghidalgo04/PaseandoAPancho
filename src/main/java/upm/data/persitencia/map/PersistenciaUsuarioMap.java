package upm.data.persitencia.map;

import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;

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
