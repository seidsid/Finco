package Finco.domain.impl;

import Finco.domain.IAccount;
import Finco.domain.IReport;

public class DefaultReport implements IReport {
    private IAccount account;

    public DefaultReport(IAccount account) {
        this.account = account;
    }

    @Override
    public String getReport() {
        return String.format("<html><h1>Report Summary</h1><p><b>account no</b>:%s</p><p><b>balance</b>:%s</p></html>",account.getAccountNumber(),account.getBalance());
    }
}
