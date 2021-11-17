package ui;

import ui.base.BaseMainJFrame;
import ui.common.UiUtilities;
import ui.dialog.AmountDialog;
import ui.dialog.GenerateBillDialog;
import ui.dialog.NewAccountDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCoMainGUI extends BaseMainJFrame {

    public FinCoMainGUI() {
        /*
         * This is the sample usage of add Button with Inheritance
         */
        addNorthButton(new JButton("Add Interest"));
        reCreateUI();
    }

    @Override
    protected List<String> setColumnTitlesForTable() {
        return List.of("Name", "Account No.", "Email", "Amount");
    }

    @Override
    protected void btnDepositActionPerformed(ActionEvent e) {
        AmountDialog dialog = new AmountDialog(list -> {

        }, "Deposit", "Account", "12345");
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnWithdrawActionPerformed(ActionEvent e) {
        AmountDialog dialog = new AmountDialog(list -> {

        }, "Withdraw", "Account", "ABCD");
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnAddAccActionPerformed(ActionEvent e) {
        NewAccountDialog dialog = new NewAccountDialog(list -> {

        });
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

    @Override
    protected void btnGenerateReportActionPerformed(ActionEvent e) {
        GenerateBillDialog dialog = new GenerateBillDialog();
        UiUtilities.getInstance().centerFrameOnDesktop(dialog);
        dialog.setVisible(true);
    }

}
