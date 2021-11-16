package ui;

import ui.dialog.GenerateBillDialog;
import ui.dialog.NewAccountDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGUI extends JFrame {

    String clientName, street, city, zip, state, accountType, amountDeposit, expdate, ccnumber;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private Object rowdata[];

    private final JPanel jPanel = new JPanel();
    private final JButton btnCreateAcc = new JButton();
    private final JButton btnGenerateBill = new JButton();
    private final JButton btnDeposit = new JButton();
    private final JButton btnWithdraw = new JButton();
    private final JButton btnExit = new JButton();

    public MainPageGUI() {
        jPanel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, jPanel);
        jPanel.setBounds(0, 0, 575, 310);

        addPanel();
        addBtnDeposit();
        addBtnWithdraw();
        addBtnExit();
        addBtnCreateAccount();
        addGenerateBill();

        SymAction symAction = new SymAction();
        btnExit.addActionListener(symAction);
        btnCreateAcc.addActionListener(symAction);
        btnGenerateBill.addActionListener(symAction);
        btnDeposit.addActionListener(symAction);
        btnWithdraw.addActionListener(symAction);
    }

    private void addPanel() {
        jScrollPane = new JScrollPane();
        model = new DefaultTableModel();
        jTable = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount = false;

        jPanel.add(jScrollPane);
        jScrollPane.setBounds(12, 92, 444, 160);
        jScrollPane.getViewport().add(jTable);
        jTable.setBounds(0, 0, 420, 0);
    }

    private void addBtnDeposit() {
        btnDeposit.setText("Deposit");
        jPanel.add(btnDeposit);
        btnDeposit.setBounds(468, 104, 96, 33);
    }

    private void addBtnWithdraw() {
        btnWithdraw.setText("Charge");
        jPanel.add(btnWithdraw);
        btnWithdraw.setBounds(468, 164, 96, 33);
    }

    private void addBtnExit() {
        btnExit.setText("Exit");
        jPanel.add(btnExit);
        btnExit.setBounds(468, 248, 96, 32);
    }

    private void addBtnCreateAccount() {
        btnCreateAcc.setText("Create Account");
        jPanel.add(btnCreateAcc);
        btnCreateAcc.setBounds(24, 20, 192, 33);
    }

    private void addGenerateBill() {
        btnGenerateBill.setText("Generate Monthly bills");
        btnGenerateBill.setActionCommand("jbutton");
        jPanel.add(btnGenerateBill);
        btnGenerateBill.setBounds(240, 20, 192, 33);
    }

    private void btnExitActionPerformed(ActionEvent event) {
        System.exit(0);
    }

    private void btnCreateAccActionPerformed(ActionEvent event) {
        NewAccountDialog dialog = new NewAccountDialog();
        dialog.setVisible(true);

        if (newaccount) {
            // add row to table
            rowdata[0] = clientName;
            rowdata[1] = ccnumber;
            rowdata[2] = expdate;
            rowdata[3] = accountType;
            rowdata[4] = "0";
            model.addRow(rowdata);
            jTable.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }
    }

    private void btnGenerateBillActionPerformed(ActionEvent event) {
        GenerateBillDialog dialog = new GenerateBillDialog();
        dialog.setVisible(true);
    }

    private void btnDepositActionPerformed(ActionEvent event) {

    }

    private void btnWithdrawActionPerformed(ActionEvent event) {

    }

    private class SymAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == btnExit) btnExitActionPerformed(event);
            else if (object == btnCreateAcc) btnCreateAccActionPerformed(event);
            else if (object == btnGenerateBill) btnGenerateBillActionPerformed(event);
            else if (object == btnDeposit) btnDepositActionPerformed(event);
            else if (object == btnWithdraw) btnWithdrawActionPerformed(event);
        }
    }

}
