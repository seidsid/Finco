package banking.ui;

import Framework.domain.Address;
import Framework.domain.impl.DefaultCustomer;
import Framework.service.IFincoServiceFacade;
import Framework.ui.FinCoMainGUI;
import Framework.ui.common.UiUtilities;
import Framework.util.DefaultEmailSender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author MinPhone, Seid, Asrat
 */
public class BankMainGUI extends FinCoMainGUI {

    private final IFincoServiceFacade facade;

    public BankMainGUI(IFincoServiceFacade facade) {
        super(facade);
        amountIndexOfTable = 6;
        dialogDefaultIndexOfTable = 0;
        emailIndexOfTable = 2;
        accountIdIndexOfTable = 0;
        this.facade = facade;
        addPersonalAccButton();
        setBtnAddAccLabel("Add Company Account");
        reCreateUI();
    }

    @Override
    protected List<String> setColumnTitlesForTable() {
        return Arrays.asList("Account No.", "Name", "Email", "City", "P/C", "Ch/S", "Amount");
    }

    @Override
    protected void btnAddAccActionPerformed(ActionEvent e) {
        AddCompanyAccountDialog dialog = new AddCompanyAccountDialog(list -> {
            String customerName = list.get(0);
            String accNo = list.get(2);
            String email = list.get(1);
            String street = list.get(3);
            String city = list.get(4);
            String state = list.get(5);
            String accType = list.get(8);
            try {
                int zip = Integer.parseInt(list.get(6));

                Vector<String> rowData = new Vector<>(Arrays.asList(accNo, customerName, email, city, "C",
                        UiUtilities.getInstance().getAccountTypeShortForm(accType), "0"));
                setDataInTable(rowData);

                facade.createCustomer(new DefaultCustomer(email, customerName,
                        new DefaultEmailSender(), new Address(city, state, zip, street)));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Zip Code Number must be Number");
            }
        }, "Add Company Account");
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    private void onAddPersonalAccActionPerformed(ActionEvent e) {
        AddPersonalAccountDialog dialog = new AddPersonalAccountDialog(list -> {
            String customerName = list.get(0);
            String accNo = list.get(2);
            String email = list.get(1);
            String street = list.get(3);
            String city = list.get(4);
            String state = list.get(5);
            String accType = list.get(8);
            try {
                int zip = Integer.parseInt(list.get(6));

                Vector<String> rowData = new Vector<>(Arrays.asList(accNo, customerName, email, city, "C",
                        UiUtilities.getInstance().getAccountTypeShortForm(accType), "0"));
                setDataInTable(rowData);

                facade.createCustomer(new DefaultCustomer(email, customerName,
                        new DefaultEmailSender(), new Address(city, state, zip, street)));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Zip Code Number must be Number");
            }
        }, "Add Personal Account");
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    private void addPersonalAccButton() {
        JButton btnPersonalAcc = new JButton("Add Personal Account");
        btnPersonalAcc.addActionListener(this::onAddPersonalAccActionPerformed);
        addFirstNorthButton(btnPersonalAcc);
    }
}
