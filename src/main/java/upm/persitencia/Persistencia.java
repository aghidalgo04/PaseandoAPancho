package upm.persitencia;

public interface Persistencia<T> {
    void create(T t);

    T findById(Long id);

    void update(T t);
}
