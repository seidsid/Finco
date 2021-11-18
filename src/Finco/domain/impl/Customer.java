package Finco.domain.impl;

import Finco.domain.Address;
import Finco.domain.Entry;
import Finco.domain.IAccount;
import Finco.domain.ICustomer;
import Finco.util.Email;
import Finco.util.IEmailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Customer extends ICustomer {
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
        notifyAllObservers();
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
        notifyAllObservers();
    }
    private void notifyAllObservers(){
        setChanged();
        notifyObservers();
    }

    @Override
    public void withdraw(Entry e, String accountNumber) {
        doAll(account -> account.withdraw(e),account -> account.getAccountNumber().equals(accountNumber));
        if(shouldSendEmailForWithdraw(e)){
            sendEmail(new Email("Account withdraw Performed","..."));
        }
        notifyAllObservers();
    }

    @Override
    public void addInterest() {
        doAll(account -> account.addInterest(),account -> true);
        notifyAllObservers();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
