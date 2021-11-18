package Framework;

public class DefaultEmailSender implements IEmailSender {
    @Override
    public void send(Email email) {
        System.out.println(email);
    }
}
