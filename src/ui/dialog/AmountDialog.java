package ui.dialog;

import ui.base.BaseDialog;
import ui.common.OkSubmitDelegate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * @author MinPhone, Seid, Asrat
 */
public class AmountDialog extends BaseDialog {

    private final String title;
    private final String fieldTitle;
    private final String fieldValue;
    private final OkSubmitDelegate delegate;

    private JTextField textFieldAmount;

    public AmountDialog(OkSubmitDelegate delegate, String title, String fieldTitle, String fieldValue) {
        this.delegate = delegate;
        this.title = title;
        this.fieldTitle = fieldTitle;
        this.fieldValue = fieldValue;

        setBtnSubmitVisible();
        reCreateUI();
    }

    @Override
    protected String giveDialogTitle() {
        return title;
    }

    @Override
    protected int giveDialogWidth() {
        return 268;
    }

    @Override
    protected int giveDialogHeight() {
        return 150;
    }

    @Override
    protected JPanel createUIAtCenter() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));

        jPanel.add(new JLabel(fieldTitle));

        JTextField textFieldValue = new JTextField();
        textFieldValue.setEnabled(false);
        textFieldValue.setText(fieldValue);
        jPanel.add(textFieldValue);

        jPanel.add(new JLabel("Amount"));

        textFieldAmount = new JTextField();
        jPanel.add(textFieldAmount);

        return jPanel;
    }

    @Override
    protected void btnOkActionPerformed() {
        delegate.onSubmitClicked(Arrays.asList(textFieldAmount.getText()));
    }
}
