package upm.persitencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class PersistenciaMap<T> implements Persistencia<T>{
    private final Map<Long, T> map;
    private File file;

    PersistenciaMap() {
        this.map = new TreeMap<>();
    }

    abstract List<T> getAll();
}
