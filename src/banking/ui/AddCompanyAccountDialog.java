package banking.ui;

import Framework.ui.base.BaseDialog;
import Framework.ui.common.OkSubmitDelegate;
import Framework.ui.common.UiUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AddCompanyAccountDialog extends BaseDialog {

    private final OkSubmitDelegate delegate;

    private ButtonGroup btnAccTypeGroup;
    private JTextField textFieldNoOfEmployee;
    protected JTextField textFieldName;
    protected JTextField textFieldEmail;
    protected JTextField textFieldAccNo;
    protected JTextField textFieldStreet;
    protected JTextField textFieldCity;
    protected JTextField textFieldState;
    protected JTextField textFieldZip;

    public AddCompanyAccountDialog(OkSubmitDelegate delegate, String title) {
        this.delegate = delegate;
        setBtnSubmitVisible();
        setTitle(title);
        reCreateUI();
    }

    @Override
    protected String giveDialogTitle() {
        return "";
    }

    @Override
    protected int giveDialogWidth() {
        return 301;
    }

    @Override
    protected int giveDialogHeight() {
        return 373;
    }

    @Override
    protected JPanel createUIAtCenter() {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));

        jPanel.add(addAccTypeLayout());
        jPanel.add(addNameLayout());
        jPanel.add(addEmailLayout());
        jPanel.add(addBirthdayLayout());
        jPanel.add(addAccNoLayout());
        jPanel.add(addStreetLayout());
        jPanel.add(addCityLayout());
        jPanel.add(addStateLayout());
        jPanel.add(addZipLayout());

        return jPanel;
    }

    @Override
    protected void btnOkActionPerformed() {
        delegate.onSubmitClicked(Arrays.asList(textFieldName.getText(), textFieldEmail.getText(), textFieldAccNo.getText(),
                textFieldStreet.getText(), textFieldCity.getText(), textFieldState.getText(), textFieldZip.getText(),
                textFieldNoOfEmployee.getText(), UiUtilities.getInstance().getSelectedButtonText(btnAccTypeGroup)));
    }

    protected JPanel addNameLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelName = new JLabel("Name");
        jPanel.add(labelName);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldName = new JTextField();
        jPanel.add(textFieldName);

        return jPanel;
    }

    protected JPanel addEmailLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelEmail = new JLabel("Email");
        jPanel.add(labelEmail);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldEmail = new JTextField();
        jPanel.add(textFieldEmail);

        return jPanel;
    }

    protected JPanel addAccNoLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("Acc No.");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldAccNo = new JTextField();
        jPanel.add(textFieldAccNo);

        return jPanel;
    }

    protected JPanel addStreetLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelStreet = new JLabel("Street");
        jPanel.add(labelStreet);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldStreet = new JTextField();
        jPanel.add(textFieldStreet);

        return jPanel;
    }

    protected JPanel addCityLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelCity = new JLabel("City");
        jPanel.add(labelCity);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldCity = new JTextField();
        jPanel.add(textFieldCity);

        return jPanel;
    }

    protected JPanel addStateLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelState = new JLabel("State");
        jPanel.add(labelState);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldState = new JTextField();
        jPanel.add(textFieldState);

        return jPanel;
    }

    protected JPanel addZipLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelZip = new JLabel("Zip");
        jPanel.add(labelZip);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldZip = new JTextField();
        jPanel.add(textFieldZip);

        return jPanel;
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

    private JPanel addBirthdayLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelAccNo = new JLabel("No. Of Employee");
        jPanel.add(labelAccNo);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        textFieldNoOfEmployee = new JTextField();
        jPanel.add(textFieldNoOfEmployee);

        return jPanel;
    }
}
