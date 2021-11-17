package ui.impl;

import domain.IAccount;
import domain.impl.DefaultCustomer;
import ui.ITable;
import util.Tuple;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class DefaultTable implements ITable<DefaultCustomer>, Observer {
    private JTable jTable;
    private final String[] columnNames={"Email","AccNo","State","Zip","Street","city","Balance"};
    private DefaultTableModel model;

    private Map<String,DefaultCustomer> customers;
    public DefaultTable() {
        customers=new HashMap<>();
        model=new DefaultTableModel();
        jTable=new JTable(model);
        Arrays.stream(columnNames).forEach(model::addColumn);
    }

    @Override
    public void add(DefaultCustomer customer) {
        customer.addObserver(this);
        customer.doAll(account -> addAccount(customer,account),account -> true);
        customers.put(customer.getEmail(),customer);
    }
    private void addAccount(DefaultCustomer customer,IAccount account){
        model.addRow(new String[]{customer.getEmail(),account.getAccountNumber(),customer.getAddress().getState(),Integer.toString(customer.getAddress().getZip()),customer.getAddress().getStreet(),customer.getAddress().getCity(),account.getBalance().toString()});
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
        int rowNo=jTable.getSelectedRow();
        if(rowNo>=0){
            String email=(String)jTable.getModel().getValueAt(rowNo,0);
            String accountNumber=(String)jTable.getModel().getValueAt(rowNo,1);
            DefaultCustomer customer=customers.get(email);
            return Optional.of(new Tuple<>(customer,customer.findAccount(accountNumber).get()));
        }
        return Optional.empty();
    }

    @Override
    public void update(Observable o, Object arg) {
        model.setRowCount(0);
        customers.values().forEach(this::add);
    }
}
