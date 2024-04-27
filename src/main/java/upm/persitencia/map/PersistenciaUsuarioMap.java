package upm.persitencia.map;

import upm.modelo.Usuario;
import upm.persitencia.PersistenciaUsuario;

import java.util.List;

public class PersistenciaUsuarioMap extends PersistenciaMap<Usuario> implements PersistenciaUsuario {

    @Override
    List<Usuario> getAll(){
        return null;
    }


    @Override
    public void create(Usuario usuario) {

    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Long id) {

    }
}
