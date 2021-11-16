package domain.impl;

import domain.Entry;
import domain.IReport;

import java.math.BigDecimal;
import java.util.List;

public class DefaultAccount extends AccountTemplate {
    private final float interestPercent=0.13f;
    public DefaultAccount(List<Entry> entries, BigDecimal balance, String accountNumber) {
        super(entries, balance, accountNumber);
    }

    public DefaultAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    public DefaultAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public float getInterestPercentage() {
        return interestPercent;
    }

    @Override
    public IReport getReport() {
        return new DefaultReport(this);
    }
}
