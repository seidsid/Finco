package Bank.ui;

import Finco.domain.IAccount;
import Finco.domain.impl.DefaultCustomer;
import Finco.ui.ITable;
import Finco.util.Tuple;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class BankTable implements ITable<DefaultCustomer>, Observer {
    private JTable jTable;
    private final String[] columnNames = {"Email", "AccNo", "State", "Zip", "Street", "city", "Balance", "P/C", "Ch/S"};
    private DefaultTableModel model;

    private Map<String, DefaultCustomer> customers;

    public BankTable() {
        customers = new HashMap<>();
        model = new DefaultTableModel();
        jTable = new JTable(model);
        Arrays.stream(columnNames).forEach(model::addColumn);
    }

    @Override
    public void add(DefaultCustomer customer) {
        customer.addObserver(this);
        customer.doAll(account -> addAccount(customer, account), account -> true);
        customers.put(customer.getEmail(), customer);
    }

    private void addAccount(DefaultCustomer customer, IAccount account) {
        model.addRow(new String[]{customer.getEmail(), account.getAccountNumber(), customer.getAddress().getState(),
                Integer.toString(customer.getAddress().getZip()), customer.getAddress().getStreet(),
                customer.getAddress().getCity(), account.getBalance().toString(),
                getTypeName(customer.getClass().getName()), getTypeName(account.getClass().getName())});
    }

    @Override
    public void update(DefaultCustomer customer) {
        //todo
    }

    @Override
    public JTable getTable() {
        return jTable;
    }

    @Override
    public Optional<Tuple<DefaultCustomer, IAccount>> getSelected() {
        int rowNo = jTable.getSelectedRow();
        if (rowNo >= 0) {
            String email = (String) jTable.getModel().getValueAt(rowNo, 0);
            String accountNumber = (String) jTable.getModel().getValueAt(rowNo, 1);
            DefaultCustomer customer = customers.get(email);
            return Optional.of(new Tuple<>(customer, customer.findAccount(accountNumber).get()));
        }
        return Optional.empty();
    }

    @Override
    public void update(Observable o, Object arg) {
        model.setRowCount(0);
        customers.values().forEach(this::add);
    }

    private String getTypeName(String name) {
        String result = "";
        if (name.equals("Bank.domain.Person")) result = "P";
        else if (name.equals("Bank.domain.Company")) result = "C";
        else if (name.equals("Bank.domain.Saving")) result = "S";
        else if (name.equals("Bank.domain.Checking")) result = "Ch";
        return result;
    }
}
