package domain;

import util.Email;

import java.util.Optional;


public interface ICustomer extends FunctionalIterable<IAccount> {
    void addAccount(IAccount account);
    void sendEmail(Email email);
    void deposit(Entry e, String accountNumber);
    void withdraw(Entry e,String accountNumber);
    void addInterest();
    String getEmail();
    Address getAddress();
    Optional<IAccount> findAccount(String accountNumber);
}
