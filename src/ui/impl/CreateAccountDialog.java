package ui.impl;

import domain.Address;
import domain.impl.DefaultCustomer;
import ui.Dialog;
import util.DefaultEmailSender;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CreateAccountDialog extends Dialog<DefaultCustomer> {
    private Consumer<DefaultCustomer> consumer;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldAccNo;
    private JTextField textFieldStreet;
    private JTextField textFieldCity;
    private JTextField textFieldState;
    private JTextField textFieldZip;

    public CreateAccountDialog() {
    }

    @Override
    protected void btnOkActionPerformed() {
        if (consumer!=null){
            consumer.accept(new DefaultCustomer(textFieldAccNo.getText(), textFieldEmail.getText(),textFieldName.getText(),new DefaultEmailSender(),new Address(textFieldCity.getText(),textFieldState.getText(),Integer.parseInt(textFieldZip.getText()),textFieldStreet.getText())));
        }
    }

    @Override
    protected String giveDialogTitle() {
        return "Create Account";
    }

    @Override
    protected int giveDialogWidth() {
        return 400;
    }

    @Override
    protected int giveDialogHeight() {
        return 500;
    }

    protected JPanel createUIAtCenter() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));

        jPanel.add(addNameLayout());
        jPanel.add(addEmailLayout());
        jPanel.add(addAccNoLayout());
        jPanel.add(addStreetLayout());
        jPanel.add(addCityLayout());
        jPanel.add(addStateLayout());
        jPanel.add(addZipLayout());

        return jPanel;
    }

    private JPanel addNameLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelName = new JLabel("Name");
        jPanel.add(labelName);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldName = new JTextField();
        jPanel.add(textFieldName);

        return jPanel;
    }

    private JPanel addEmailLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelEmail = new JLabel("Email");
        jPanel.add(labelEmail);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldEmail = new JTextField();
        jPanel.add(textFieldEmail);

        return jPanel;
    }

    private JPanel addAccNoLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("Acc No.");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldAccNo = new JTextField();
        jPanel.add(textFieldAccNo);

        return jPanel;
    }

    private JPanel addStreetLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelStreet = new JLabel("Street");
        jPanel.add(labelStreet);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldStreet = new JTextField();
        jPanel.add(textFieldStreet);

        return jPanel;
    }

    private JPanel addCityLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelCity = new JLabel("City");
        jPanel.add(labelCity);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldCity = new JTextField();
        jPanel.add(textFieldCity);

        return jPanel;
    }

    private JPanel addStateLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelState = new JLabel("State");
        jPanel.add(labelState);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldState = new JTextField();
        jPanel.add(textFieldState);

        return jPanel;
    }

    private JPanel addZipLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelZip = new JLabel("Zip");
        jPanel.add(labelZip);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldZip = new JTextField();
        jPanel.add(textFieldZip);

        return jPanel;
    }
    @Override
    public void setCallback(Consumer<DefaultCustomer> consumer) {
          this.consumer=consumer;
    }
}
