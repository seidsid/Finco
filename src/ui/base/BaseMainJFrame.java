package ui.base;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * Base class for All JFrame which will be used in FinCo Application
 *
 * @author MinPhone, Seid, Asrat
 */
public abstract class BaseMainJFrame extends JFrame {

    private final JScrollPane jScrollPane = new JScrollPane();
    private final List<JButton> northButtons = new LinkedList<>();
    private final List<JButton> eastButtons = new LinkedList<>();

    protected String btnWithdrawLabel = "Withdraw";
    protected String btnAddAccLabel = "Add Account";
    protected String btnGenerateReportLabel = "Generate Report";
    private DefaultTableModel model;
    private JTable jTable;

    /**
     * @return List of Labels(String) Columns want to show in the ScrollPane
     */
    protected abstract List<String> setColumnTitlesForTable();

    /**
     * ActionListener for Deposit Button
     *
     * @param e the event to be processed
     */
    protected abstract void btnDepositActionPerformed(ActionEvent e);

    /**
     * ActionListener for Withdraw Button
     *
     * @param e the event to be processed
     */
    protected abstract void btnWithdrawActionPerformed(ActionEvent e);

    /**
     * ActionListener for Add Account Button
     *
     * @param e the event to be processed
     */
    protected abstract void btnAddAccActionPerformed(ActionEvent e);

    /**
     * ActionListener for Generate Report Button
     *
     * @param e the event to be processed
     */
    protected abstract void btnGenerateReportActionPerformed(ActionEvent e);

    private void setUpMainLayout() {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.NORTH, createUINorth());
        getContentPane().add(BorderLayout.SOUTH, createUISouth());
        getContentPane().add(BorderLayout.EAST, createUIEast());
        getContentPane().add(BorderLayout.WEST, createUIWest());
        getContentPane().add(BorderLayout.CENTER, createUICenter());
    }

    private void addDefaultButtonForNorth() {
        JButton btnCreateAcc = new JButton(btnAddAccLabel);
        btnCreateAcc.addActionListener(this::btnAddAccActionPerformed);

        JButton btnGenerateReport = new JButton(btnGenerateReportLabel);
        btnGenerateReport.addActionListener(this::btnGenerateReportActionPerformed);

        northButtons.add(btnCreateAcc);
        northButtons.add(btnGenerateReport);
    }

    private void addDefaultButtonForEast() {
        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(this::btnDepositActionPerformed);

        JButton btnWithdraw = new JButton(btnWithdrawLabel);
        btnWithdraw.addActionListener(this::btnWithdrawActionPerformed);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        eastButtons.add(btnDeposit);
        eastButtons.add(btnWithdraw);
        eastButtons.add(btnExit);
    }

    protected BaseMainJFrame() {
        addDefaultButtonForNorth();
        addDefaultButtonForEast();
        setUpMainLayout();
    }

    /**
     * setup UI part in North Panel.
     */
    protected JPanel createUINorth() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        for (JButton button : northButtons) {
            jPanel.add(button);
        }

        return jPanel;
    }

    /**
     * setup UI part in South Panel.
     */
    protected JPanel createUISouth() {
        return new JPanel();
    }

    /**
     * setup UI part in East Panel.
     */
    protected JPanel createUIEast() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        for (JButton button : eastButtons) {
            jPanel.add(button);
        }

        return jPanel;
    }

    /**
     * setup UI part in West Panel.
     */
    protected JPanel createUIWest() {
        return new JPanel();
    }

    /**
     * setup UI part in Center Panel.
     */
    protected JPanel createUICenter() {
        model = new DefaultTableModel();
        jTable = new JTable(model);
        JPanel jPanel = new JPanel();
        List<String> columnTitles = setColumnTitlesForTable();
        for (String title : columnTitles) {
            model.addColumn(title);
        }

        jPanel.add(jScrollPane);
        jScrollPane.getViewport().add(jTable);
        return jPanel;
    }

    /**
     * Use this method when want to add Single Button in North part of the Screen.
     * And want to appear <i><b>First</b></i> in the particular part of the screen.
     *
     * @param btn need to provide JButton.
     */
    protected void addFirstNorthButton(JButton btn) {
        ((LinkedList) northButtons).addFirst(btn);
    }

    /**
     * Use this method when want to add Single Button in North part of the Screen.
     *
     * @param btn need to provide JButton.
     */
    protected void addNorthButton(JButton btn) {
        northButtons.add(btn);
    }

    /**
     * Use this method when want to add List of Button in North part of the Screen.
     *
     * @param btns need to provide List of JButton.
     */
    protected void addNorthButton(List<JButton> btns) {
        northButtons.addAll(btns);
    }

    /**
     * Use this method when want to add Single Button in East part of the Screen.
     * And want to appear <i><b>First</b></i> in the particular part of the screen.
     *
     * @param btn need to provide JButton.
     */
    protected void addFirstEastButton(JButton btn) {
        ((LinkedList) eastButtons).addFirst(btn);
    }

    /**
     * Use this method when want to add Single Button in East part of the Screen.
     *
     * @param btn need to provide JButton.
     */
    protected void addEastButton(JButton btn) {
        eastButtons.add(btn);
    }

    /**
     * Use this method when want to add List of Button in East part of the Screen.
     *
     * @param btns need to provide List of JButton.
     */
    protected void addEastButton(List<JButton> btns) {
        eastButtons.addAll(btns);
    }

    /**
     * Need to recall this method whenever change/add the default value/UI to get an updated UI.
     */
    protected void reCreateUI() {
        setUpMainLayout();
    }

}
