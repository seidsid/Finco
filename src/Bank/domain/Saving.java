package Bank.domain;

import Finco.domain.Entry;
import Finco.domain.IReport;
import Finco.domain.impl.AccountTemplate;

import java.math.BigDecimal;
import java.util.List;

public class Saving extends AccountTemplate {
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
        return null;
    }

    @Override
    public float getInterestPercentage() {
        return 0;
    }
}
