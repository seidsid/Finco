package Bank.domain;

import Finco.domain.Address;
import Finco.domain.Entry;
import Finco.domain.impl.DefaultCustomer;
import Finco.util.IEmailSender;

public class Company extends DefaultCustomer {
    private int numberOfEmployees;
    public Company(String email, String accountNumber,String name, IEmailSender emailSender, int numberOfEmployees, Address address) {
        super(accountNumber,email, name, emailSender, address);
        this.numberOfEmployees=numberOfEmployees;
    }

    @Override
    public boolean shouldSendEmailForWithdraw(Entry e) {
        return false;
    }

    @Override
    public boolean shouldSendEmailForDeposit(Entry e) {
        return false;
    }
}
