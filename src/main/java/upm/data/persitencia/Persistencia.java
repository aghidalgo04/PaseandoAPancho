package upm.data.persitencia;

public interface Persistencia<T> {
    void create(T entidad);

    T findById(Long id);

    void update(T entidad);

    void delete(Long id);
}
