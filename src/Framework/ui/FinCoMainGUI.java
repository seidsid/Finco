package Framework.ui;

import Framework.DefaultEmailSender;
import Framework.domain.Address;
import Framework.domain.IReport;
import Framework.domain.impl.DefaultCustomer;
import Framework.service.IFincoServiceFacade;
import Framework.ui.base.BaseMainJFrame;
import Framework.ui.common.UiUtilities;
import Framework.ui.dialog.AmountDialog;
import Framework.ui.dialog.GenerateBillDialog;
import Framework.ui.dialog.NewAccountDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCoMainGUI extends BaseMainJFrame {

    private final IFincoServiceFacade facade;

    protected int amountIndexOfTable = 0;
    protected int dialogDefaultIndexOfTable = 0;
    protected int emailIndexOfTable = 0;
    protected int accountIdIndexOfTable = 0;

    public FinCoMainGUI(IFincoServiceFacade facade) {
        amountIndexOfTable = 3;
        dialogDefaultIndexOfTable = 1;
        accountIdIndexOfTable = 1;
        emailIndexOfTable = 2;
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
        return Arrays.asList("Name", "Account No.", "Email", "Amount");
    }

    @Override
    protected void btnDepositActionPerformed(ActionEvent e) {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            createDepositDialog();
        } else {
            JOptionPane.showMessageDialog(this, "Select one row in the Table!");
        }
    }

    @Override
    protected void btnWithdrawActionPerformed(ActionEvent e) {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            createWithdrawDialog();
        } else {
            JOptionPane.showMessageDialog(this, "Select one row in the Table!");
        }
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

                Vector<String> rowData = new Vector<>(Arrays.asList(customerName, accNo, email, "0"));
                setDataInTable(rowData);

                facade.createCustomer(new DefaultCustomer(accNo, email, customerName, new DefaultEmailSender(),
                        new Address(city, state, zip, street)));
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
            Optional<IReport> report = facade.generateReport(email, accNo);
            dialog = report.map(iReport -> new GenerateBillDialog(iReport.getReport()))
                    .orElseGet(() -> new GenerateBillDialog(""));
            UiUtilities.getInstance().centerFrameOnDesktop(dialog);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one row in the Table!");
        }

    }

    private void createDepositDialog() {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        AmountDialog dialog = new AmountDialog(list -> {
            try {
                long currentValue = Long.parseLong((String) model.getValueAt(selection, amountIndexOfTable));
                long depositAmount = Long.parseLong(list.get(0));
                long updateValue = currentValue + depositAmount;
                model.setValueAt(String.valueOf(updateValue), selection, amountIndexOfTable);

                addDeposit(selection, depositAmount);
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Amount must be Number.");
            }
        }, "Deposit", "Account", (String) model.getValueAt(selection, dialogDefaultIndexOfTable));
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    private void createWithdrawDialog() {
        int selection = jTable.getSelectionModel().getMinSelectionIndex();
        AmountDialog dialog = new AmountDialog(list -> {
            try {
                long currentValue = Long.parseLong((String) model.getValueAt(selection, amountIndexOfTable));
                long withdrawAmount = Long.parseLong(list.get(0));
                long updateValue = currentValue - withdrawAmount;
                model.setValueAt(String.valueOf(updateValue), selection, amountIndexOfTable);

                addWithdraw(selection, withdrawAmount);
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Amount must be Number.");
            }
        }, "Withdraw", "Account", (String) model.getValueAt(selection, dialogDefaultIndexOfTable));
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    protected void addDeposit(int selection, long depositAmount) {
        facade.deposit((String) model.getValueAt(selection, emailIndexOfTable),
                (String) model.getValueAt(selection, accountIdIndexOfTable), BigDecimal.valueOf(depositAmount));
    }

    protected void addWithdraw(int selection, long withdrawAmount) {
        facade.withDraw((String) model.getValueAt(selection, emailIndexOfTable),
                (String) model.getValueAt(selection, accountIdIndexOfTable), BigDecimal.valueOf(withdrawAmount));
    }

}
