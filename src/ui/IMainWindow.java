package ui;

import domain.ICustomer;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Optional;

public interface IMainWindow<T extends ICustomer> {
    Optional<Iterable<JButton>> getVerticalButtons();
    Optional<Iterable<JButton>> getHorizontalButtons();
    Dialog<T> createAccountDialog();
    Dialog<BigDecimal> createDepositDialog();
    Dialog<BigDecimal> createWithdrawDialog();
}
