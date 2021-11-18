package Finco.ui.impl;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class AmountDialog extends BaseDialog<BigDecimal> {

    private final String fieldTitle;
    private final String fieldValue;

    private JTextField textFieldAmount;

    public AmountDialog(String title, String fieldTitle, String fieldValue) {
        this.fieldTitle = fieldTitle;
        this.fieldValue = fieldValue;
        setTitle(title);
    }
    @Override
    public Optional<List<Component>> addToTOp() {
        return Optional.of(List.of(ui()));
    }
    protected JPanel ui() {
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
    public Optional<List<Component>> addToBottom() {
        return Optional.empty();
    }

    @Override
    public void onOkClick() {
        if(consumer!=null)consumer.accept(new BigDecimal(textFieldAmount.getText()));
    }
}
