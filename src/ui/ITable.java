package ui;

import domain.IAccount;
import domain.ICustomer;
import util.Tuple;

import javax.swing.*;
import java.util.Optional;

public interface ITable <T extends ICustomer> {
    void add(T customer);
    void update(T customer);//?
    JTable getTable();
    Optional<Tuple<T, IAccount>> getSelected();
}
