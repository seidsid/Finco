package service;

import domain.IAccount;
import domain.ICustomer;
import domain.IReport;

import java.math.BigDecimal;
import java.util.Optional;

public interface IFincoServiceFacade<T extends ICustomer> {
    void createCustomer(T customer);

    void deposit(String customerEmail, String accountId, BigDecimal amount);

    void withDraw(String customerEmail, String accountId, BigDecimal amount);

    void addInterest();

    Optional<IReport> generateReport(String customerEmail, String accountId);

    Iterable<T> getAll();

    void addAccount(String customerEmail, IAccount account);
}
