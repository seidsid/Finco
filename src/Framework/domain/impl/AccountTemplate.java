package Framework.domain.impl;

import Framework.domain.Entry;
import Framework.domain.IAccount;
import Framework.domain.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AccountTemplate implements IAccount {
    private List<Entry> entries;
    private BigDecimal balance;
    private String accountNumber;

    public AccountTemplate(List<Entry> entries, BigDecimal balance, String accountNumber) {
        this.entries = entries;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public AccountTemplate(BigDecimal balance, String accountNumber) {
        this(new ArrayList<Entry>(), balance, accountNumber);
    }

    public AccountTemplate(String accountNumber) {
        this(new ArrayList<Entry>(), new BigDecimal(0), accountNumber);
    }

    @Override
    public void deposit(Entry entry) {
        entries.add(entry);
        balance = balance.add(entry.getAmount());
    }

    public abstract float getInterestPercentage();

    @Override
    public void addInterest() {
        balance = balance.add(balance.multiply(new BigDecimal(getInterestPercentage())));
    }

    @Override
    public void withdraw(Entry entry) {
        if (entry.getAmount().compareTo(balance) > 0) {
            throw new InsufficientBalanceException(String.format("Insufficient balance! available:%s, withdrawal amount:%s", balance, entry.getAmount()));
        } else {
            entries.add(entry);
            balance = balance.subtract(entry.getAmount());
        }
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}