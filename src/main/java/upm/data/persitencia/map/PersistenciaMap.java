package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.persitencia.Persistencia;

import java.io.*;
import java.util.*;

abstract public class PersistenciaMap<T> implements Persistencia<T> {
    private static String FOLDER_NAME = "persistenciaFile";

    private Map<Long, T> persistencia;
    protected File folder;
    private File file;

    public PersistenciaMap(String fileName) {
        this.persistencia = new TreeMap<>();
        this.folder = new File(FOLDER_NAME);
        this.file = new File(FOLDER_NAME + "/" + fileName);
        crearCarpeta();
        crearArchivo();
        leerYActualizarPersistencia();
    }

    private void crearCarpeta() {
        if (!this.folder.exists()) {
            boolean folderCreated = this.folder.mkdir();
            if (!folderCreated) {
                throw new RuntimeException("No se ha podido crear la carpeta");
            }
        }
    }

    private void crearArchivo() {
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero");
            }
        }
    }

    private void leerYActualizarPersistencia() {
        try {
            if (this.file.length() > 0) {
                FileInputStream fileIn = new FileInputStream(this.file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                while (objectIn.available() > 0) {
                    T t = (T) objectIn.readObject();
                    persistencia.put(this.getId(t), t);
                }
                objectIn.close();
            }
        } catch (IOException e ) {
            throw new RuntimeException("Error al abrir el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Clase no encontrada");
        }
    }

    private void addFile(T t) {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.file);
            ObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
            objectOut.writeObject(t);
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero");
        }
    }

    @Override
    public void actualizarFichero() {
        this.file.delete();
        crearArchivo();
        for (T t : persistencia.values()) {
            addFile(t);
        }
    }

    @Override
    public void create(T entidad) {
        this.persistencia.put(this.getId(entidad), entidad);
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.of(this.persistencia.get(id));
    }

    @Override
    public void update(T entidad) {
        this.persistencia.put(this.getId(entidad), entidad);
    }

    @Override
    public void delete(Long id) {
        this.persistencia.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new LinkedList<>(persistencia.values());
    }

    abstract protected Long getId(T entidad);

    static class AppendingObjectOutputStream extends ObjectOutputStream {
        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}
