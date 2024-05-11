package upm.data.persitencia;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface PersistenciaUsuario{
    void createDueno(Dueno dueno);

    void createCuidador(Cuidador cuidador);

    Dueno findDueno(Long id);

    Cuidador findCuidador(Long id);

    void updateDueno(Dueno dueno);

    void updateCuidador(Cuidador cuidador);

    void delete(Entity entity);
}
