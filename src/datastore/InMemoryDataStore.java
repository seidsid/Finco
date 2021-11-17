package datastore;

import domain.ICustomer;
import domain.impl.Customer;

import java.util.*;

public class InMemoryDataStore<T extends ICustomer> implements IDataStore<T>{

    private HashMap<String,T> db;

    public InMemoryDataStore() {
        db=new HashMap();
    }

    @Override
    public void persist(T customer) {
        db.put(customer.getEmail(),customer);
    }

    @Override
    public Iterable<T> load() {
        return db.values();
    }

    @Override
    public void update(T customer) {
        for(String c:db.keySet()) {
            if (customer.getEmail().equalsIgnoreCase(c)) db.put(c,customer);
        }
    }

    @Override
    public Optional<T> findByEmail(String email) {
        for(String c:db.keySet()){
            if(email.equalsIgnoreCase(c)) return Optional.of(db.get(c));
        }
         return Optional.empty();
    }

    @Override
    public boolean exists(String email) {
        for(String c:db.keySet()){
        if(email.equalsIgnoreCase(c)) return true;
        }
         return false;
    }
}
