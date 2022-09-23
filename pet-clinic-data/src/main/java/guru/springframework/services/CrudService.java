package guru.springframework.services;

import java.util.Set;

public interface CrudService <T, ID>{
    T findById(ID id);
    Set<T> findAll();
    T save(T obj);
    void delete(T obj);
    void deleteById(ID id);
}
