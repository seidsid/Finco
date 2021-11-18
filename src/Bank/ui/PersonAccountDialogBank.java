package Bank.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;

public class PersonAccountDialogBank extends BankCommonDialog {
    private JTextField textFieldDOB;

    @Override
    public Optional<List<Component>> addToBottom() {
        return Optional.of(List.of(addBirthdayLayout()));
    }

    @Override
    public void onOkClick() {

    }

    @Override
    public void onCancelClick() {

    }

    protected String getDateOfBirtText(){
        return textFieldDOB.getText();
    }
    private JPanel addBirthdayLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("Birthday");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldDOB = new JTextField();
        jPanel.add(textFieldDOB);

        return jPanel;
    }
}
