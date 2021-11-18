package Bank.ui;

import Bank.domain.Company;
import Finco.domain.Address;
import Finco.util.DefaultEmailSender;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;

public class CompanyAccountDialogBank extends BankCommonDialog<Company> {
    private JTextField numberOfEmployees;

    @Override
    public Optional<List<Component>> addToBottom() {
        return Optional.of(List.of(addNumberOfEmployeesLayout()));
    }

    @Override
    public void onOkClick() {
        consumer.accept(new Company(getAccountNumberText(),getEmailText(),getNameText(),new DefaultEmailSender(),getNumberOfEmployees(),new Address(getCityText(),getStateText(),Integer.parseInt(getZipText()),getStateText())));
    }
    public int getNumberOfEmployees(){
        return Integer.parseInt(numberOfEmployees.getText());
    }
    @Override
    public void onCancelClick() {

    }

    protected String getDateOfBirtText(){
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
