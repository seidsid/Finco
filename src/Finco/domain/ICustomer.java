package Finco.domain;

import Finco.util.Email;

import java.util.Optional;


public interface ICustomer extends FunctionalIterable<IAccount> {
    public abstract void addAccount(IAccount account);

    public abstract void sendEmail(Email email);

    public abstract void deposit(Entry e, String accountNumber);

    public abstract void withdraw(Entry e, String accountNumber);

    public abstract void addInterest();

    public abstract String getEmail();

    public abstract Address getAddress();

    public abstract Optional<IAccount> findAccount(String accountNumber);
}
