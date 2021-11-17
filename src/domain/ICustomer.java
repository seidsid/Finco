package domain;

import util.Email;

import java.util.Observable;
import java.util.Optional;


public abstract class ICustomer extends Observable implements FunctionalIterable<IAccount> {
    public abstract void addAccount(IAccount account);
    public abstract void sendEmail(Email email);
    public abstract void deposit(Entry e, String accountNumber);
    public abstract void withdraw(Entry e,String accountNumber);
    public abstract void addInterest();
    public abstract String getEmail();
    public abstract Address getAddress();
    public abstract Optional<IAccount> findAccount(String accountNumber);
}
