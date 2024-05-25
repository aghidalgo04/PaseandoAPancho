package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;
import upm.data.persitencia.adaptadores.AdaptadorCuidador;
import upm.data.persitencia.adaptadores.AdaptadorDueno;

import java.io.*;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersistenciaUsuarioMap implements PersistenciaUsuario {
    private static String FOLDER_NAME = "persistenciaFile";

    private Map<String, AdaptadorDueno> persistenciaDueno;
    private Map<String, AdaptadorCuidador> persistenciaCuidador;
    private File fileDueno;
    private File fileCuidador;

    public PersistenciaUsuarioMap(String fileNameDueno, String fileNameCuidador) {
        this.persistenciaDueno = new TreeMap<>();
        this.persistenciaCuidador = new TreeMap<>();

        File folder = new File(FOLDER_NAME);
        if (!folder.exists()) {
            boolean folderCreated = folder.mkdir();
            if (!folderCreated) {
                throw new RuntimeException("No se ha podido crear la carpeta");
            }
        }
        this.fileDueno = new File("persistenciaFile/" + fileNameDueno);
        this.fileCuidador = new File("persistenciaFile/" + fileNameCuidador);
        if (!this.fileDueno.exists()) {
            try {
                this.fileDueno.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero" + fileNameDueno);
            }
        }
        if (!this.fileCuidador.exists()) {
            try {
                this.fileCuidador.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero" + fileNameCuidador);
            }
        } else {
            try {
                FileInputStream fileInDueno = new FileInputStream(this.fileDueno);
                ObjectInput objectInDueno = new ObjectInputStream(fileInDueno);
                FileInputStream fileInCuidador = new FileInputStream(this.fileCuidador);
                ObjectInput objectInCuidador = new ObjectInputStream(fileInCuidador);
                this.persistenciaDueno = (Map<String, AdaptadorDueno>) objectInDueno.readObject();
                this.persistenciaCuidador = (Map<String, AdaptadorCuidador>) objectInCuidador.readObject();
            } catch (IOException e) {
                throw new RuntimeException("Error al abrir el fichero");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void createDueno(Dueno dueno) {
        AdaptadorDueno aDueno = new AdaptadorDueno(dueno);
        persistenciaDueno.put(dueno.getId(), aDueno);
        updateFileDueno();
    }

    @Override
    public void createCuidador(Cuidador cuidador) {
        AdaptadorCuidador aCuidador = new AdaptadorCuidador(cuidador);
        persistenciaCuidador.put(cuidador.getId(), aCuidador);
        updateFileCuidador();
    }

    @Override
    public Optional<Dueno> findDueno(String id) {
        return Optional.of(this.persistenciaDueno.get(id).getDueno());
    }

    @Override
    public Optional<Cuidador> findCuidador(String id) {
        return Optional.of(this.persistenciaCuidador.get(id).getCuidador());
    }

    @Override
    public void updateDueno(Dueno dueno) {
        AdaptadorDueno aDueno = new AdaptadorDueno(dueno);
        this.persistenciaDueno.replace(dueno.getId(), aDueno);
        updateFileDueno();
    }

    @Override
    public void updateCuidador(Cuidador cuidador) {
        AdaptadorCuidador aCuidador = new AdaptadorCuidador(cuidador);
        this.persistenciaCuidador.replace(cuidador.getId(), aCuidador);
        updateFileCuidador();
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
        updateFileDueno();
        updateFileCuidador();
    }

    private void updateFileDueno() {
        try (FileOutputStream fileOut = new FileOutputStream(this.fileDueno);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.persistenciaDueno);
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero Dueno");
        }
    }

    private void updateFileCuidador() {
        try (FileOutputStream fileOut = new FileOutputStream(this.fileCuidador);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.persistenciaCuidador);
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero Cuidador");
        }
    }
}
