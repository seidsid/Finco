package banking.domain.customer;

import Framework.IEmailSender;
import Framework.domain.Address;
import Framework.domain.impl.DefaultCustomer;

public class CompanyCustomer extends DefaultCustomer {

    private final String noOfEmployee;

    public CompanyCustomer(String email, String name, IEmailSender emailSender, Address address, String noOfEmployee) {
        super(email, name, emailSender, address);
        this.noOfEmployee = noOfEmployee;
    }
}
