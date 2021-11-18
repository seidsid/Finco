package Finco.ui.impl;

import Finco.domain.IReport;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ReportDialog extends BaseDialog<Void> {
    private Consumer<Void> consumer;
    private IReport report;

    public ReportDialog(IReport report) {
        this.report = report;
    }
    private JPanel createUi(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(new JLabel(report.getReport()));
        jPanel.add(scrollPane);

        return jPanel;
    }
    @Override
    public Optional<List<Component>> addToTOp() {
        return Optional.of(List.of(createUi()));
    }

    @Override
    public Optional<List<Component>> addToBottom() {
        return Optional.empty();
    }

    @Override
    public void onOkClick() {

    }
}
