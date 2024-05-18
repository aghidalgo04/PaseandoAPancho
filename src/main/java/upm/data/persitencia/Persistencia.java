package upm.data.persitencia;

import java.util.List;
import java.util.Optional;

public interface Persistencia<T> {
    void create(T entidad);

    Optional<T> findById(Long id);

    void update(T entidad);

    void delete(Long id);

    List<T> findAll();
}
