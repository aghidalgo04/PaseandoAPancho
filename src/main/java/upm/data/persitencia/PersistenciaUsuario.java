package upm.data.persitencia;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;
import upm.data.persitencia.adaptadores.AdaptadorDueno;

import java.util.Optional;

public interface PersistenciaUsuario{
    void createDueno(Dueno dueno);

    void createCuidador(Cuidador cuidador);

    Optional<Dueno> findDueno(String id);

    Optional<Cuidador> findCuidador(String id);

    void updateDueno(Dueno dueno);

    void updateCuidador(Cuidador cuidador);

    void delete(Usuario usuario);

    void actualizarFichero();
}
