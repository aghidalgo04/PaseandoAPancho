package upm.data.persitencia.map;

import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;

public class PersistenciaUsuarioMap extends PersistenciaMap<Usuario> implements PersistenciaUsuario {
    public PersistenciaUsuarioMap(String fileName) {
        super(fileName);
    }
}
