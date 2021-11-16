package ui.dialog;

import ui.base.BaseDialog;

import javax.swing.*;
import java.awt.*;

public class GenerateBillDialog extends BaseDialog {

    protected JScrollPane scrollPane;

    @Override
    protected String giveDialogTitle() {
        return "Generate Bill Report";
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
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 2, 10));
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(new TextField("Test"));

        jPanel.add(scrollPane);

        return jPanel;
    }

}
