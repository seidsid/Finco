package Bank.domain;

import Finco.domain.Entry;
import Finco.domain.IReport;
import Finco.domain.impl.DefaultReport;

import java.math.BigDecimal;
import java.util.List;

public class Checking extends BankAccount {
    public Checking(List<Entry> entries, BigDecimal balance, String accountNumber) {
        super(entries, balance, accountNumber);
    }

    public Checking(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    public Checking(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public IReport getReport() {
        return new DefaultReport(this);
    }

    @Override
    public float getInterestPercentage() {
        return 0.01f;
    }
}
