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

public class PersistenciaUsuarioMap  implements PersistenciaUsuario {
    private Map<String, AdaptadorDueno> persistenciaDueno;
    private Map<String, AdaptadorCuidador> persistenciaCuidador;
    private File file;

    public PersistenciaUsuarioMap(String fileName) {
        this.persistenciaDueno = new TreeMap<>();
        this.persistenciaCuidador = new TreeMap<>();
        this.file = new File("persistenciaFile/" + fileName);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el fichero");
            }
        } else {
            try (FileInputStream fileIn = new FileInputStream(this.file);
                 ObjectInput objectIn = new ObjectInputStream(fileIn)) {
                this.persistenciaDueno = (Map<String, AdaptadorDueno>) objectIn.readObject();
                this.persistenciaCuidador = (Map<String, AdaptadorCuidador>) objectIn.readObject();
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
        try (FileOutputStream fileOut = new FileOutputStream(this.file);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.persistenciaDueno);
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero Dueno");
        }
    }

    private void updateFileCuidador() {
        try (FileOutputStream fileOut = new FileOutputStream(this.file);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.persistenciaCuidador);
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el fichero Cuidador");
        }
    }
}
