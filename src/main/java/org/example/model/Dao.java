package org.example.model;

import java.util.List;

public interface Dao<T, K> {

    /**
     * Returns an object of type T that matches the specified ID.
     * @param id the ID of the object
     * @return an object of type T
     */
    T getById(K id);

    /**
     * Deletes the object that matches the specified ID.
     * @param id the ID of the object
     */
    void deleteById(K id);

    /**
     * Returns a list containing all objects of type T.
     * @return a list containing all objects of type T
     */
    List<T> getAll();

    /**
     * Saves an object of type T.
     * @param t the object to be saved
     */
    void save(T t);

    /**
     * Updates the data of the saved object that matches the given object ID using the data of the given object.
     * @param t the object to be updated
     */
    void update(T t);

    /**
     * Deletes the object that matches the given object ID.
     * @param t the object to be deleted
     */
    void delete(T t);
}
