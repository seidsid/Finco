package Finco.domain.impl;

import Bank.domain.BankAccount;
import Finco.domain.Address;
import Finco.domain.Entry;
import Finco.domain.IPerson;
import Finco.util.IEmailSender;

import java.math.BigDecimal;

public class Person extends DefaultCustomer implements IPerson {
    private final BankAccount bankAccount;

    public Person(String email, String accountNumber, String name, IEmailSender emailSender, Address address, BankAccount bankAccount) {
        super(email, name, emailSender, address, bankAccount);
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean shouldSendEmailForWithdraw(Entry e) {
        return checkShouldSendEmailOrNot(e);
    }

    @Override
    public boolean shouldSendEmailForDeposit(Entry e) {
        return checkShouldSendEmailOrNot(e);
    }

    private boolean checkShouldSendEmailOrNot(Entry e) {
        if (e.getAmount().compareTo(new BigDecimal(400)) > 0) return true;
        if (bankAccount.getBalance().compareTo(new BigDecimal(0)) < 0) return true;
        else return false;
    }
}
