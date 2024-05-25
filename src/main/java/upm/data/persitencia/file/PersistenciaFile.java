package upm.data.persitencia.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public abstract class PersistenciaFile<K, T> {
    private static final String FOLDER = "persistenciaFile";
    private final String FILE_PATH;
    private ObjectMapper objectMapper;
    protected Map<K, T> objetos;

    protected PersistenciaFile(String fileName) {
        this.FILE_PATH = FOLDER + "/" + fileName + ".json";
        this.objectMapper = new ObjectMapper();
        this.objetos = new TreeMap<>();

        File folder = new File(FOLDER);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new RuntimeException("No se ha podido crear carpeta " + FOLDER);
            }
        }
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                this.objetos = this.objectMapper.readValue(file, new TypeReference<Map<K, T>>() {
                });
            } else {
                if (!file.createNewFile()) {
                    throw new RuntimeException("No se ha podido crear fichero en ruta " + FILE_PATH);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void saveToFile() {
        try {
            this.objectMapper.writeValue(new File(FILE_PATH), this.objetos);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
