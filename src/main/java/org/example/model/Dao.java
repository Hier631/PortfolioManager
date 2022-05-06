package org.example.model;

import java.util.List;

public interface Dao<T, K> {
    T getById(K id);
    void deleteById(K id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
