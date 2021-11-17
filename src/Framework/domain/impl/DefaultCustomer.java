package Framework.domain.impl;

import Framework.IEmailSender;
import Framework.domain.Address;
import Framework.domain.Entry;

public class DefaultCustomer extends Customer {

    public DefaultCustomer(String email, String name, IEmailSender emailSender, Address address) {
        super(email, name, emailSender, address);
    }

    //by default send email for every transaction
    @Override
    public boolean shouldSendEmailForWithdraw(Entry e) {
        return true;
    }

    @Override
    public boolean shouldSendEmailForDeposit(Entry e) {
        return true;
    }
}
