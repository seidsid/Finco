package ui.dialog;

import ui.base.BaseDialog;
import ui.common.OkSubmitDelegate;

import javax.swing.*;
import java.awt.*;

/**
 * @author MinPhone, Seid, Asrat
 */
public class NewAccountDialog extends BaseDialog {

    public NewAccountDialog(OkSubmitDelegate delegate) {
        super(delegate);
        setBtnSubmitVisible();
        reCreateUI();
    }

    @Override
    protected String giveDialogTitle() {
        return "Create New Account";
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

        jPanel.add(addNameLayout());
        jPanel.add(addEmailLayout());
        jPanel.add(addStreetLayout());
        jPanel.add(addCityLayout());
        jPanel.add(addStateLayout());
        jPanel.add(addZipLayout());

        return jPanel;
    }

    private JPanel addNameLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelName = new JLabel("Name");
        jPanel.add(labelName);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldName = new JTextField();
        jPanel.add(textFieldName);

        return jPanel;
    }

    private JPanel addEmailLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelEmail = new JLabel("Email");
        jPanel.add(labelEmail);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldEmail = new JTextField();
        jPanel.add(textFieldEmail);

        return jPanel;
    }

    private JPanel addStreetLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelStreet = new JLabel("Street");
        jPanel.add(labelStreet);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldStreet = new JTextField();
        jPanel.add(textFieldStreet);

        return jPanel;
    }

    private JPanel addCityLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelCity = new JLabel("City");
        jPanel.add(labelCity);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldCity = new JTextField();
        jPanel.add(textFieldCity);

        return jPanel;
    }

    private JPanel addStateLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelState = new JLabel("State");
        jPanel.add(labelState);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldState = new JTextField();
        jPanel.add(textFieldState);

        return jPanel;
    }

    private JPanel addZipLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JLabel labelZip = new JLabel("Zip");
        jPanel.add(labelZip);

        jPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JTextField textFieldZip = new JTextField();
        jPanel.add(textFieldZip);

        return jPanel;
    }

}
