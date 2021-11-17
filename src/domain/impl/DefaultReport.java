package domain.impl;

import domain.IAccount;
import domain.IReport;

public class DefaultReport implements IReport {
    private IAccount account;

    public DefaultReport(IAccount account) {
        this.account = account;
    }

    @Override
    public String getReport() {
        return String.format("account no:%s\nbalance:%s\n");
    }
}
