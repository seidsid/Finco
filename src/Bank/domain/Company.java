package Bank.domain;

import Finco.domain.Address;
import Finco.domain.Entry;
import Finco.domain.impl.DefaultCustomer;
import Finco.util.IEmailSender;

public class Company extends DefaultCustomer {
    private int numberOfEmployees;

    public Company(String email, String accountNumber, String name, IEmailSender emailSender,
                   int numberOfEmployees, Address address, BankAccount bankAccount) {
        super(email, name, emailSender, address, bankAccount);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean shouldSendEmailForWithdraw(Entry e) {
        return true;
    }

    @Override
    public boolean shouldSendEmailForDeposit(Entry e) {
        return true;
    }
}
