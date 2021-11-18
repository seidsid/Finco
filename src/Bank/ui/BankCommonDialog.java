package Bank.ui;

import Finco.ui.impl.CommonDialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

public abstract class BankCommonDialog<T> extends CommonDialog<T> {
    public enum AccountType{
        CHECKING,SAVING
    }
    private ButtonGroup btnAccTypeGroup;


    @Override
    public Optional<List<Component>> addToBottom() {
        List<Component> components=new ArrayList<>();
        super.addToBottom().ifPresent(components1 -> components.addAll(components1));
        components.add(addAccTypeLayout());
        return Optional.of(components);
    }

    protected AccountType getAccountType(){
        return getSelectedButtonText(btnAccTypeGroup);
    }

    private JPanel addAccTypeLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        btnAccTypeGroup = new ButtonGroup();
        JRadioButton rbChecking = new JRadioButton("Checking");
        JRadioButton rbSaving = new JRadioButton("Saving");
        rbChecking.setSelected(true);

        btnAccTypeGroup.add(rbSaving);
        btnAccTypeGroup.add(rbChecking);

        jPanel.add(rbSaving);
        jPanel.add(rbChecking);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        return jPanel;
    }
    public AccountType getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return getAccountTypeShortForm(button.getText());
            }
        }

        return getAccountTypeShortForm("");
    }
    private AccountType getAccountTypeShortForm(String type) {
        AccountType result=AccountType.CHECKING;
        if (type.toLowerCase().equals("saving"))result= AccountType.SAVING;
        return result;
    }

}
