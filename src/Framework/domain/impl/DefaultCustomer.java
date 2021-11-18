package Framework.domain.impl;

import Framework.IEmailSender;
import Framework.domain.Address;
import Framework.domain.Entry;

import java.math.BigDecimal;

public class DefaultCustomer extends Customer {

    public DefaultCustomer(String accountNumber, String email, String name, IEmailSender emailSender, Address address) {
        super(email, name, emailSender, address);
        addAccount(new DefaultAccount(new BigDecimal("0"), accountNumber));
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
