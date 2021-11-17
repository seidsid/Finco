package Framework.service.impl;

import Framework.datastore.IDataStore;
import Framework.domain.*;
import Framework.service.IFincoServiceFacade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class DefaultFincoServiceFacade<T extends ICustomer> implements IFincoServiceFacade<T> {
    private IDataStore<T> dataStore;

    public DefaultFincoServiceFacade(IDataStore<T> dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void createCustomer(T customer) {
        dataStore.persist(customer);
    }

    @Override
    public void deposit(String customerEmail, String accountId, BigDecimal amount) {
        Optional<T> customer =dataStore.findByEmail(customerEmail);
        customer.ifPresent(c-> {
            c.deposit(new Entry(amount,"Deposit",new Date()),accountId);
            dataStore.update(c);
        });
    }

    @Override
    public void withDraw(String customerEmail, String accountId, BigDecimal amount) throws InsufficientBalanceException {
        Optional<T> customer =dataStore.findByEmail(customerEmail);
        customer.ifPresent(c -> {
            c.withdraw(new Entry(amount,"Withdraw",new Date()),accountId);
            dataStore.update(c);
        });
    }

    @Override
    public void addInterest() {
        dataStore.load().forEach(t -> t.addInterest());
    }

    @Override
    public Optional<IReport> generateReport(String customerEmail, String accountId) {
        Optional<? extends ICustomer> customer = dataStore.findByEmail(customerEmail);
        return customer.flatMap(c->c.findAccount(accountId)).map(account -> account.getReport());
    }

    @Override
    public Iterable getAll() {
        return dataStore.load();
    }

    @Override
    public void addAccount(String customerEmail, IAccount account) {
        dataStore.findByEmail(customerEmail).ifPresent(c->{
            c.addAccount(account);
            dataStore.update(c);
        });
    }
}
