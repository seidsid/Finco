package Bank.domain;

import Finco.domain.Entry;
import Finco.domain.IReport;
import Finco.domain.impl.Account;
import Finco.domain.impl.DefaultAccount;
import Finco.domain.impl.DefaultReport;

import java.math.BigDecimal;
import java.util.List;

public abstract class BankAccount extends DefaultAccount {
    public BankAccount(List<Entry> entries, BigDecimal balance, String accountNumber) {
        super(entries, balance, accountNumber);
    }

    public BankAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    public BankAccount(String accountNumber) {
        super(accountNumber);
    }
}
