package ui.impl;

import domain.impl.DefaultCustomer;
import ui.Dialog;
import ui.FacadeTableAbstractFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class DefaultWindow extends MainWindow<DefaultCustomer>{
    public DefaultWindow(FacadeTableAbstractFactory<DefaultCustomer> factory) throws HeadlessException {
        super(factory);
    }

    @Override
    public Optional<Iterable<JButton>> getVerticalButtons() {
        return Optional.empty();
    }

    @Override
    public Optional<Iterable<JButton>> getHorizontalButtons() {
        return Optional.empty();
    }

    @Override
    public Dialog<DefaultCustomer> createAccountDialog() {
        return new CreateAccountDialog();
    }

    @Override
    public String getAddAccountButtonLabel() {
        return "Add Account";
    }

    @Override
    public String getWithdrawButtonLabel() {
        return "Withdraw";
    }
}
