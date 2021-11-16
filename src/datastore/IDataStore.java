package datastore;

import domain.ICustomer;
import java.util.List;

public interface IDataStore <T extends ICustomer>{
    void persist (T customer);
    List<T> load();
    void update(T customer);
    T findByEmail(String email);
    boolean exists(String email);
}
