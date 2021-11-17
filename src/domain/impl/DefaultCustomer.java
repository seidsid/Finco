package domain.impl;

import domain.Address;
import domain.Entry;
import util.IEmailSender;

import java.math.BigDecimal;

public class DefaultCustomer extends Customer {

    public DefaultCustomer(String accountNumber,String email, String name, IEmailSender emailSender, Address address) {
        super(email, name, emailSender, address);
        addAccount(new DefaultAccount(new BigDecimal("0"),accountNumber));
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
