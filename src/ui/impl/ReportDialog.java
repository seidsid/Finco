package ui.impl;

import domain.IReport;
import ui.Dialog;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ReportDialog extends Dialog<Void> {
    private Consumer<Void> consumer;
    private IReport report;

    public ReportDialog(IReport report) {
        this.report = report;
        getContentPane().add(BorderLayout.CENTER, createUIAtCenter());
    }

    @Override
    public void setCallback(Consumer<Void> consumer) {
        this.consumer=consumer;
    }

    @Override
    protected String giveDialogTitle() {
        return "Report";
    }

    @Override
    protected int giveDialogWidth() {
        return 500;
    }

    @Override
    protected int giveDialogHeight() {
        return 750;
    }

    protected JPanel createUIAtCenter() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));

        if(report!=null)jPanel.add(new JLabel("Amount"));

        return jPanel;
    }

    @Override
    protected void btnOkActionPerformed() {
    }
}
