package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersistenciaUsuarioMap  implements PersistenciaUsuario {
    private final Map<String, Dueno> persistenciaDueno;
    private final Map<String, Cuidador> persistenciaCuidador;
    private File file;

    public PersistenciaUsuarioMap(String fileName) {
        this.persistenciaDueno = new TreeMap<>();
        this.persistenciaCuidador = new TreeMap<>();
        this.file = new File("persistenciaFile/" + fileName);
    }

    @Override
    public void createDueno(Dueno dueno) {
        persistenciaDueno.put(dueno.getId(), dueno);
    }

    @Override
    public void createCuidador(Cuidador cuidador) {
        persistenciaCuidador.put(cuidador.getId(), cuidador);
    }

    @Override
    public Optional<Dueno> findDueno(String id) {
        return Optional.of(this.persistenciaDueno.get(id));
    }

    @Override
    public Optional<Cuidador> findCuidador(String id) {
        return Optional.of(this.persistenciaCuidador.get(id));
    }

    @Override
    public void updateDueno(Dueno dueno) {
        this.persistenciaDueno.replace(dueno.getId(), dueno);
    }

    @Override
    public void updateCuidador(Cuidador cuidador) {
        this.persistenciaCuidador.replace(cuidador.getId(), cuidador);
    }

    @Override
    public void delete(Usuario usuario) {
        if (this.persistenciaDueno.containsKey(usuario.getId())) {
            this.persistenciaDueno.remove(usuario.getId());
        } else if (this.persistenciaCuidador.containsKey(usuario.getId())) {
            this.persistenciaCuidador.remove(usuario.getId());
        } else {
            throw new IllegalArgumentException("No se ha podido borrar al usuario ya que no ha sido encontrado");
        }
    }
}
