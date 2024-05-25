package upm.data.persitencia.map;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;
import upm.data.persitencia.PersistenciaUsuario;

import java.io.*;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersistenciaUsuarioMap  implements PersistenciaUsuario {
    private static String FOLDER_NAME = "persistenciaFile";
    private Map<String, Dueno> persistenciaDueno;
    private Map<String, Cuidador> persistenciaCuidador;
    private File folder;
    private File fileDueno;
    private File fileCuidador;

    public PersistenciaUsuarioMap(String fileNameDueno, String fileNameCuidador) {
        this.persistenciaDueno = new TreeMap<>();
        this.persistenciaCuidador = new TreeMap<>();
        this.folder = new File("persistenciaFile");
        this.fileDueno = new File(FOLDER_NAME + "/" + fileNameDueno);
        this.fileCuidador = new File(FOLDER_NAME + "/" + fileNameCuidador);
        crearCarpeta();
        crearArchivos();
        leerYActualizarPersistenciaDueno();
        leerYActualizarPersistenciaCuidador();
    }

    private void crearCarpeta() {
        if (!this.folder.exists()) {
            boolean folderCreated = this.folder.mkdir();
            if (!folderCreated) {
                throw new RuntimeException("No se ha podido crear la carpeta");
            }
        }
    }

    private void crearArchivos() {
        if (!this.fileDueno.exists()) {
            try {
                this.fileDueno.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero");
            }
        }
        if (!this.fileCuidador.exists()) {
            try {
                this.fileCuidador.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero");
            }
        }
    }

    private void leerYActualizarPersistenciaDueno() {
        try {
                if (this.fileDueno.length() > 0) {
                    FileInputStream fileInDueno = new FileInputStream(this.fileDueno);
                    ObjectInputStream objectInDueno = new ObjectInputStream(fileInDueno);
                    while (objectInDueno.available() > 0) {
                        Dueno dueno = (Dueno)objectInDueno.readObject();
                        persistenciaDueno.put(dueno.getId(), dueno);
                    }
                    objectInDueno.close();
                }
        } catch (IOException e ) {
            throw new RuntimeException("Error al abrir el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Clase no encontrada");
        }
    }

    private void leerYActualizarPersistenciaCuidador() {
        try {
                if (this.fileCuidador.length() > 0) {
                    FileInputStream fileInCuidador = new FileInputStream(fileCuidador);
                    ObjectInputStream objectInCuidador = new ObjectInputStream(fileInCuidador);
                    while (objectInCuidador.available() > 0) {
                        Cuidador cuidador = (Cuidador)objectInCuidador.readObject();
                        persistenciaCuidador.put(cuidador.getId(), cuidador);
                    }
                    objectInCuidador.close();
                }
        } catch (IOException e ) {
            throw new RuntimeException("Error al abrir el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Clase no encontrada");
        }
    }

    private void addFileDueno(Dueno dueno) {
        try {
            FileOutputStream fileOutDueno = new FileOutputStream(this.fileDueno);
            ObjectOutputStream objectOutDueno = new AppendingObjectOutputStream(fileOutDueno);
            objectOutDueno.writeObject(dueno);
            objectOutDueno.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero");
        }
    }

    private void addFileCuidador(Cuidador cuidador) {
        try {
            FileOutputStream fileOutCuidador = new FileOutputStream(this.fileCuidador);
            ObjectOutputStream objectOutCuidador = new AppendingObjectOutputStream(fileOutCuidador);
            objectOutCuidador.writeObject(cuidador);
            objectOutCuidador.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero");
        }
    }

    @Override
    public void actualizarFichero() {
        this.fileDueno.delete();
        this.fileCuidador.delete();
        crearArchivos();
        for (Dueno dueno : persistenciaDueno.values()) {
            addFileDueno(dueno);
        }
        for (Cuidador cuidador : persistenciaCuidador.values()) {
            addFileCuidador(cuidador);
        }
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