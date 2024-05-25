package upm.data.persitencia.map;

import upm.data.persitencia.Persistencia;

import java.io.*;
import java.util.*;

abstract public class PersistenciaMap<T> implements Persistencia<T> {
    private static String FOLDER_NAME = "persistenciaFile";

    private Map<Long, T> persistencia;
    private File file;

    public PersistenciaMap(String fileName) {
        this.persistencia = new TreeMap<>();
        File folder = new File(FOLDER_NAME);
        if (!folder.exists()) {
            boolean folderCreated = folder.mkdir();
            if (!folderCreated) {
                throw new RuntimeException("No se ha podido crear la carpeta");
            }
        }
        this.file = new File(FOLDER_NAME + "/" + fileName);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero");
            }
        } else {
            try (FileInputStream fileIn = new FileInputStream(this.file);
                 ObjectInput objectIn = new ObjectInputStream(fileIn)) {
                this.persistencia = (Map<Long, T>) objectIn.readObject();
            } catch (IOException e) {
                throw new RuntimeException("Error al abrir el fichero");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void create(T entidad) {
        persistencia.put(this.getId(entidad), entidad);
        updateFile();
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.of(this.persistencia.get(id));
    }

    @Override
    public void update(T entidad) {
        persistencia.put(this.getId(entidad), entidad);
        updateFile();
    }

    @Override
    public void delete(Long id) {
        persistencia.remove(id);
        updateFile();
    }

    @Override
    public List<T> findAll() {
        return new LinkedList<>(persistencia.values());
    }

    abstract protected Long getId(T entidad);

    private void updateFile() {
        try (FileOutputStream fileOut = new FileOutputStream(this.file);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.persistencia);
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero");
        }
    }
}
