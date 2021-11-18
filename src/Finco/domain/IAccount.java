package Finco.domain;

import java.math.BigDecimal;

public interface IAccount {
    void deposit(Entry entry);
    void withdraw(Entry entry) throws InsufficientBalanceException;
    void addInterest();
    String getAccountNumber();
    IReport getReport();
    BigDecimal getBalance();
}

