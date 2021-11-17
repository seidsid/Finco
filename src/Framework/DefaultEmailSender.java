package Framework.util;

import Framework.Email;
import Framework.IEmailSender;

public class DefaultEmailSender implements IEmailSender {
    @Override
    public void send(Email email) {
        System.out.println(email);
    }
}
