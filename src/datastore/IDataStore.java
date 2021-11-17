package datastore;

import domain.ICustomer;

import java.util.Optional;

public interface IDataStore<T extends ICustomer> {
    void persist(T customer);

    Iterable<T> load();

    void update(T customer);

    Optional<T> findByEmail(String email);

    boolean exists(String email);
}
