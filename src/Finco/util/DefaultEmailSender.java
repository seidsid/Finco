package Finco.util;

import javax.swing.*;

public class DefaultEmailSender implements IEmailSender {
    @Override
    public void send(Email email) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), email.toString());
        System.out.println(email);
    }
}
