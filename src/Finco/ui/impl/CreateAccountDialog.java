package Finco.ui.impl;

import Finco.domain.Address;
import Finco.domain.impl.DefaultCustomer;
import Finco.util.DefaultEmailSender;


public class CreateAccountDialog extends CommonDialog<DefaultCustomer> {

    public CreateAccountDialog() {
    }

    @Override
    public void onOkClick() {
        if (consumer!=null){
            consumer.accept(new DefaultCustomer(textFieldAccNo.getText(), textFieldEmail.getText(),textFieldName.getText(),new DefaultEmailSender(),new Address(textFieldCity.getText(),textFieldState.getText(),Integer.parseInt(textFieldZip.getText()),textFieldStreet.getText())));
        }
    }
}
