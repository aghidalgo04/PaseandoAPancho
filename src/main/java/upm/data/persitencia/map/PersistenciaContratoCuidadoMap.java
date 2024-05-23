package upm.data.persitencia.map;

import upm.data.modelo.ContratoCuidado;
import upm.data.persitencia.PersistenciaContratoCuidado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistenciaContratoCuidadoMap extends PersistenciaMap<ContratoCuidado> implements PersistenciaContratoCuidado {
    public PersistenciaContratoCuidadoMap(String fileName) {
        super(fileName);
    }

    @Override
    protected Long getId(ContratoCuidado contratoCuidado) {
        return contratoCuidado.getId();
    }

    /*@Override
    void create(ContratoCuidado entidad){
        try (FileOutputStream fileOut = new FileOutputStream("PersistenciaContratoCuidado.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(entidad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
