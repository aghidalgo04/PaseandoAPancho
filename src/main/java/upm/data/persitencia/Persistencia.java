package upm.data.persitencia;

import java.util.List;
import java.util.Optional;

public interface Persistencia<K, T> {
    void create(T entidad);

    Optional<T> findById(K id);

    void update(T entidad);

    void delete(K id);

    List<T> findAll();
}
