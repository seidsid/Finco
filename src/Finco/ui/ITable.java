package Finco.ui;

import Finco.domain.IAccount;
import Finco.domain.ICustomer;
import Finco.util.Tuple;

import javax.swing.*;
import java.util.Optional;

public interface ITable <T extends ICustomer> {
    void add(T customer);
    void update(T customer);//?
    JTable getTable();
    Optional<Tuple<T, IAccount>> getSelected();
}
