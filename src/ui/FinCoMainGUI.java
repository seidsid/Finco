package ui;

import domain.Address;
import domain.IReport;
import domain.impl.DefaultCustomer;
import service.IFincoServiceFacade;
import ui.base.BaseMainJFrame;
import ui.common.UiUtilities;
import ui.dialog.AmountDialog;
import ui.dialog.GenerateBillDialog;
import ui.dialog.NewAccountDialog;
import util.DefaultEmailSender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;

/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCoMainGUI extends BaseMainJFrame {

    private final IFincoServiceFacade facade;

    public FinCoMainGUI(IFincoServiceFacade facade) {
        this.facade = facade;
        JButton button = new JButton("Add Interest");
        button.addActionListener(e -> {
            facade.addInterest();
        });
        addNorthButton(button);
        reCreateUI();
    }

    @Override
    protected List<String> setColumnTitlesForTable() {
        return List.of("Name", "Account No.", "Email", "Amount");
    }

    @Override
    protected void btnDepositActionPerformed(ActionEvent e) {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        AmountDialog dialog = new AmountDialog(list -> {
            if (selection >= 0) {
                try {
                    long currentValue = Long.parseLong((String) model.getValueAt(selection, 3));
                    long depositAmount = Long.parseLong(list.get(0));
                    long updateValue = currentValue + depositAmount;
                    model.setValueAt(String.valueOf(updateValue), selection, 3);

                    facade.deposit((String) model.getValueAt(selection, 0),
                            (String) model.getValueAt(selection, 1), BigDecimal.valueOf(depositAmount));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Amount must be Number.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select one row in the Table!");
            }
        }, "Deposit", "Account", (String) model.getValueAt(selection, 1));
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnWithdrawActionPerformed(ActionEvent e) {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        AmountDialog dialog = new AmountDialog(list -> {
            if (selection >= 0) {
                try {
                    long currentValue = Long.parseLong((String) model.getValueAt(selection, 3));
                    long withdrawAmount = Long.parseLong(list.get(0));
                    long updateValue = currentValue - withdrawAmount;
                    model.setValueAt(String.valueOf(updateValue), selection, 3);

                    facade.withDraw((String) model.getValueAt(selection, 0),
                            (String) model.getValueAt(selection, 1), BigDecimal.valueOf(withdrawAmount));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Amount must be Number.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select one row in the Table!");
            }
        }, "Withdraw", "Account", (String) model.getValueAt(selection, 1));
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnAddAccActionPerformed(ActionEvent e) {
        NewAccountDialog dialog = new NewAccountDialog(list -> {
            String customerName = list.get(0);
            String accNo = list.get(2);
            String email = list.get(1);
            String street = list.get(3);
            String city = list.get(4);
            String state = list.get(5);
            try {
                int zip = Integer.parseInt(list.get(6));

                Vector<String> rowData = new Vector<>(List.of(customerName, accNo, email, "0"));
                setDataInTable(rowData);

                facade.createCustomer(new DefaultCustomer(email, customerName,
                        new DefaultEmailSender(), new Address(city, state, zip, street)));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Zip Code Number must be Number");
            }
        });
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnGenerateReportActionPerformed(ActionEvent e) {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            GenerateBillDialog dialog;
            String email = (String) model.getValueAt(selection, 2);
            String accNo = (String) model.getValueAt(selection, 1);
            var report = facade.generateReport(email, accNo);
            if (report.isPresent()) {
                dialog = new GenerateBillDialog(((IReport) report.get()).getReport());
            } else {
                dialog = new GenerateBillDialog("");
            }
            UiUtilities.getInstance().centerFrameOnDesktop(dialog);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one row in the Table!");
        }

    }

}
