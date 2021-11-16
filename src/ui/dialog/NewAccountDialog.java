package ui.dialog;

import ui.base.BaseDialog;

import javax.swing.*;

public class NewAccountDialog extends BaseDialog {

    public NewAccountDialog() {

    }

    @Override
    protected String giveDialogTitle() {
        return "Create New Account";
    }

    @Override
    protected int giveDialogWidth() {
        return 301;
    }

    @Override
    protected int giveDialogHeight() {
        return 373;
    }

    @Override
    protected JPanel createUIAtCenter() {
        return new JPanel();
    }

}
