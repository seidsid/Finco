package Bank.ui;

import Finco.domain.impl.DefaultCustomer;
import Finco.ui.Dialog;
import Finco.ui.FacadeTableAbstractFactory;
import Finco.ui.impl.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import java.util.List;

public class BankMainWindow extends MainWindow<DefaultCustomer> {
    private JButton addCompanyButton;
    public BankMainWindow(FacadeTableAbstractFactory<DefaultCustomer> factory) throws HeadlessException {
        super(factory);
        addCompanyButton=new JButton("Add Company Account");
        addCompanyButton.addActionListener(e -> {
            CompanyAccountDialogBank companyAccountDialog=new CompanyAccountDialogBank();
            companyAccountDialog.setCallback(o -> factory.getServiceFacade().createCustomer(o));
            companyAccountDialog.setVisible(true);
        });
    }

    @Override
    public Optional<Iterable<JButton>> getVerticalButtons() {
        return Optional.empty();
    }

    @Override
    public Optional<Iterable<JButton>> getHorizontalButtons() {
        return Optional.of(List.of(addCompanyButton));
    }

    @Override
    public Dialog<DefaultCustomer> createAccountDialog() {
        return null;
    }

    @Override
    public String getAddAccountButtonLabel() {
        return "Add Personal Account";
    }

    @Override
    public String getWithdrawButtonLabel() {
        return "Withdraw";
    }
}
