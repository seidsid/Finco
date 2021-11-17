package ui.impl;

import domain.IAccount;
import domain.ICustomer;
import service.IFincoServiceFacade;
import ui.Dialog;
import ui.FacadeTableAbstractFactory;
import ui.IMainWindow;
import ui.ITable;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Optional;

public abstract class MainWindow<T extends ICustomer> extends JFrame implements IMainWindow<T>  {
    private JButton addAccountButton;
    private JButton addInterestButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exit;
    private JButton generateReportButton;

    private ITable<T> table;
    private IFincoServiceFacade<T> serviceFacade;
    public MainWindow(FacadeTableAbstractFactory<T> factory) throws HeadlessException {
        table=factory.getTable();
        serviceFacade= factory.getServiceFacade();

        addAccountButton();
        generateReportButton();
        addInterestButton();
        addDepositButton();
        addWithdrawButton();
        addExitButton();

        JPanel horizontalPanel = addComponentsToHorizontalPanel();
        JPanel verticalPanel = addComponentsToVerticalPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(horizontalPanel,BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(table.getTable()),BorderLayout.CENTER);
        getContentPane().add(verticalPanel,BorderLayout.EAST);

    }
    private void showReport(T customer, IAccount account){
        (new ReportDialog(account.getReport())).setVisible(true);
    }


    private JPanel addComponentsToVerticalPanel() {
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel,BoxLayout.Y_AXIS));
        verticalPanel.add(generateReportButton);
        verticalPanel.add(addInterestButton);
        verticalPanel.add(depositButton);
        verticalPanel.add(withdrawButton);

        Optional<Iterable<JButton>> verticalButtons=getVerticalButtons();
        verticalButtons.ifPresent(buttons -> buttons.forEach(verticalPanel::add));

        verticalPanel.add(exit);
        return verticalPanel;
    }

    private JPanel addComponentsToHorizontalPanel() {
        JPanel horizontalPanel=new JPanel();
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel,BoxLayout.X_AXIS));

        horizontalPanel.add(addAccountButton);
        Optional<Iterable<JButton>> horizontalButtons=getHorizontalButtons();
        horizontalButtons.ifPresent(buttons -> buttons.forEach(horizontalPanel::add));
        return horizontalPanel;
    }

    private void addExitButton() {
        exit=new JButton();
        exit.setText("Exit");
    }

    private void addWithdrawButton() {
        withdrawButton=new JButton();
        withdrawButton.setText(getWithdrawButtonLabel());
        withdrawButton.addActionListener(e -> {
            table.getSelected().ifPresent(tuple -> {
                Dialog<BigDecimal> dialog=createDepositDialog();
                dialog.setCallback(bigDecimal -> {
                    serviceFacade.withDraw(tuple.getFirst().getEmail(),tuple.getSecond().getAccountNumber(),bigDecimal);
                });
                dialog.setVisible(true);
            });
        });
    }

    private void addDepositButton() {
        depositButton=new JButton();
        depositButton.setText("Deposit");
        depositButton.addActionListener(e -> {
            table.getSelected().ifPresent(tuple->{
                Dialog<BigDecimal> dialog=createDepositDialog();
                dialog.setCallback(bigDecimal -> {
                    serviceFacade.deposit(tuple.getFirst().getEmail(),tuple.getSecond().getAccountNumber(),bigDecimal);
                });
                dialog.setVisible(true);
            });
        });
    }

    private void addInterestButton() {
        addInterestButton=new JButton();
        addInterestButton.setText("Add Interest");
        addInterestButton.addActionListener(e -> serviceFacade.addInterest());
    }

    private void generateReportButton() {
        generateReportButton=new JButton();
        generateReportButton.setText("Generate Report");
        generateReportButton.addActionListener(e -> {
            table.getSelected().ifPresent(ti ->{
                showReport(ti.getFirst(),ti.getSecond());
            } );
        });
    }

    private void addAccountButton() {
        addAccountButton=new JButton();
        addAccountButton.setText(getAddAccountButtonLabel());
        addAccountButton.addActionListener(e -> {
            Dialog<T> accountDialog=createAccountDialog();
            accountDialog.setCallback(o -> {
                table.add(o);
                serviceFacade.createCustomer(o);
            });
            accountDialog.setVisible(true);
        });
    }

    @Override
    public  Dialog<BigDecimal> createDepositDialog() {
        return new AmountDialog("Deposit","Account Number",table.getSelected().get().getSecond().getAccountNumber());
    }

    @Override
    public Dialog<BigDecimal> createWithdrawDialog() {
        return new AmountDialog("Withdraw","Account Number",table.getSelected().get().getSecond().getAccountNumber());
    }

    public abstract String getAddAccountButtonLabel();
    public abstract String getWithdrawButtonLabel();

}
