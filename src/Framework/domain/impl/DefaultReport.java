package Framework.domain.impl;

import Framework.domain.IAccount;
import Framework.domain.IReport;

public class DefaultReport implements IReport {
    private IAccount account;

    public DefaultReport(IAccount account) {
        this.account = account;
    }

    @Override
    public String getReport() {
        return String.format("account no:%s\nbalance:%s\n", account.getAccountNumber(), account.getBalance());
    }
}
