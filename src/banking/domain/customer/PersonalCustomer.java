package banking.domain.customer;

import Framework.IEmailSender;
import Framework.domain.Address;
import Framework.domain.impl.DefaultCustomer;

public class PersonalCustomer extends DefaultCustomer {

    private final String DOB;

    public PersonalCustomer(String accountNumber, String email, String name,
                            IEmailSender emailSender, Address address, String DOB) {
        super(accountNumber, email, name, emailSender, address);
        this.DOB = DOB;
    }
}
