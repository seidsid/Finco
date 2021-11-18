package Bank.domain;

import Finco.domain.Address;
import Finco.domain.Entry;
import Finco.domain.impl.DefaultCustomer;
import Finco.util.IEmailSender;

public class Person extends DefaultCustomer {
    public Person(String email,String accountNumber, String name, IEmailSender emailSender, Address address) {
        super(accountNumber,email, name, emailSender, address);
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
