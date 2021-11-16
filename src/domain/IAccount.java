package domain;

import java.math.BigDecimal;

public interface IAccount {
    void deposit(Entry entry);
    void withdraw(Entry entry);
    void addInterest(BigDecimal amount);

}
