package Bank.domain;

import Finco.domain.Entry;
import Finco.domain.IReport;
import Finco.domain.impl.DefaultReport;

import java.math.BigDecimal;
import java.util.List;

public class Saving extends BankAccount {
    public Saving(List<Entry> entries, BigDecimal balance, String accountNumber) {
        super(entries, balance, accountNumber);
    }

    public Saving(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    public Saving(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public IReport getReport() {
        return new DefaultReport(this);
    }

    @Override
    public float getInterestPercentage() {
        return 0.1f;
    }
}