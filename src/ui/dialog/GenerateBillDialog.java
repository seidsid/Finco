package ui.dialog;

import ui.base.BaseDialog;

import javax.swing.*;

public class GenerateBillDialog extends BaseDialog {

    public GenerateBillDialog() {
//        super();
    }

    @Override
    protected String giveDialogTitle() {
        return "Generate Bill Report";
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
        return null;
    }


}
