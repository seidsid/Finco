package Finco.datastore;

import Finco.domain.ICustomer;

import java.util.*;

public class InMemoryDataStore<T extends ICustomer> implements IDataStore<T>{

    private HashMap<String,T> db;

    public InMemoryDataStore() {
        db=new HashMap<>();
    }

    @Override
    public void persist(T customer) {
        if (!exists(customer.getEmail())) {
            db.put(customer.getEmail().toLowerCase(), customer);
        }
    }

    @Override
    public Iterable<T> load() {
        return db.values();
    }

    @Override
    public void update(T customer) {
        if(exists(customer.getEmail()))
            db.replace(customer.getEmail().toLowerCase(),customer);
    }

    @Override
    public Optional<T> findByEmail(String email) {
        if(exists(email)){
            T c=db.get(email.toLowerCase());
            return Optional.of(c);
        }
        return Optional.empty();
    }

    @Override
    public boolean exists(String email) {
        if(db.containsKey(email.toLowerCase())) return true;
        else return false;
    }
}