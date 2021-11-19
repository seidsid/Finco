package Bank.ui;

import Bank.domain.BankAccount;
import Bank.domain.Checking;
import Finco.domain.impl.Company;
import Bank.domain.Saving;
import Finco.domain.Address;
import Finco.util.DefaultEmailSender;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyAccountDialogBank extends BankCommonDialog<Company> {
    private JTextField numberOfEmployees;

    @Override
    public Optional<List<Component>> addToBottom() {
        List<Component> components=new ArrayList<>();
        super.addToBottom().ifPresent(components1 -> components.addAll(components1));
        components.add(addNumberOfEmployeesLayout());
        return Optional.of(components);
    }

    @Override
    public void onOkClick() {
        BankAccount account;
        if (getAccountType() == AccountType.CHECKING)
            account = new Checking(new BigDecimal("0"), getAccountNumberText());
        else account = new Saving(new BigDecimal("0"), getAccountNumberText());
        consumer.accept(new Company(getAccountNumberText(), getEmailText(), getNameText(), new DefaultEmailSender(),
                getNumberOfEmployees(), new Address(getCityText(), getStateText(), Integer.parseInt(getZipText()),
                getStateText()), account));
    }

    public int getNumberOfEmployees() {
        return Integer.parseInt(numberOfEmployees.getText());
    }

    protected String getDateOfBirtText() {
        return numberOfEmployees.getText();
    }

    private JPanel addNumberOfEmployeesLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("Number of employees");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        numberOfEmployees = new JTextField();
        jPanel.add(numberOfEmployees);

        return jPanel;
    }
}
