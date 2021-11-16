package domain.impl;

import domain.*;
import util.Email;
import util.IEmailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Customer implements ICustomer {
    private String email;
    private String name;
    private IEmailSender emailSender;
    private List<IAccount> accounts;
    private Address address;

    public Customer(String email, String name, IEmailSender emailSender, Address address) {
        this.email = email;
        this.name = name;
        this.emailSender=emailSender;
        this.accounts = new ArrayList<>();
        this.address=address;
    }

    @Override
    public void addAccount(IAccount account){
        accounts.add(account);
    }
    @Override
    public void sendEmail(Email email){
        emailSender.send(email);
    }

    @Override
    public void doAll(Consumer<IAccount> functor, Predicate<IAccount> predicate) {
        this.accounts.parallelStream().filter(predicate).forEach(functor);
    }

    @Override
    public void deposit(Entry e, String accountNumber) {
        doAll(account -> account.deposit(e),account -> account.getAccountNumber().equals(accountNumber));
        if(shouldSendEmailForDeposit(e)){
            sendEmail(new Email("Account deposit Performed","..."));
        }
    }

    @Override
    public void withdraw(Entry e, String accountNumber) {
        doAll(account -> account.withdraw(e),account -> account.getAccountNumber().equals(accountNumber));
        if(shouldSendEmailForWithdraw(e)){
            sendEmail(new Email("Account withdraw Performed","..."));
        }
    }

    @Override
    public void addInterest() {
        doAll(account -> account.addInterest(),account -> true);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public Optional<IAccount> findAccount(String accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findAny();
    }

    public abstract boolean shouldSendEmailForWithdraw(Entry e);
    public abstract boolean shouldSendEmailForDeposit(Entry e);
}
