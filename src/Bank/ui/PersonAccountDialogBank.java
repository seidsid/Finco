package Bank.ui;

import Bank.domain.BankAccount;
import Bank.domain.Checking;
import Finco.domain.impl.Person;
import Bank.domain.Saving;
import Finco.domain.Address;
import Finco.domain.impl.DefaultCustomer;
import Finco.util.DefaultEmailSender;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonAccountDialogBank extends BankCommonDialog<DefaultCustomer> {
    private JTextField textFieldDOB;

    @Override
    public Optional<List<Component>> addToBottom() {
        List<Component> components = new ArrayList<>();
        super.addToBottom().ifPresent(components1 -> components.addAll(components1));
        components.add(addBirthdayLayout());
        return Optional.of(components);
    }

    @Override
    public void onOkClick() {
        if (consumer != null) {
            BankAccount account;
            if (getAccountType() == AccountType.CHECKING)
                account = new Checking(new BigDecimal("0"), getAccountNumberText());
            else account = new Saving(new BigDecimal("0"), getAccountNumberText());
            consumer.accept(new Person(textFieldAccNo.getText(), textFieldEmail.getText(), textFieldName.getText(),
                    new DefaultEmailSender(), new Address(textFieldCity.getText(), textFieldState.getText(),
                    Integer.parseInt(textFieldZip.getText()), textFieldStreet.getText()), account));
        }
    }

    protected String getDateOfBirtText() {
        return textFieldDOB.getText();
    }

    private JPanel addBirthdayLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("Birthday");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldDOB = new JTextField();
        jPanel.add(textFieldDOB);

        return jPanel;
    }
}
