package ui.impl;

import ui.Dialog;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.function.Consumer;

public class AmountDialog extends Dialog<BigDecimal> {

    private final String title;
    private final String fieldTitle;
    private final String fieldValue;

    private Consumer<BigDecimal> callback;
    private JTextField textFieldAmount;

    public AmountDialog(String title, String fieldTitle, String fieldValue) {
        this.title = title;
        this.fieldTitle = fieldTitle;
        this.fieldValue = fieldValue;
        setTitle(title);
        getContentPane().add(BorderLayout.CENTER, createUIAtCenter());
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
        if (callback!=null){
            callback.accept(new BigDecimal(textFieldAmount.getText()));
        }
    }

    @Override
    public void setCallback(Consumer<BigDecimal> consumer) {
        this.callback=consumer;
    }
}
