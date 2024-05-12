package upm.data.persitencia;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;

import javax.swing.text.html.parser.Entity;

public interface PersistenciaUsuario{
    void createDueno(Dueno dueno);

    void createCuidador(Cuidador cuidador);

    Dueno findDueno(String id);

    Cuidador findCuidador(String id);

    void updateDueno(Dueno dueno);

    void updateCuidador(Cuidador cuidador);

    void delete(Entity entity);
}
