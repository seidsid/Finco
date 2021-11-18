package Framework.ui.dialog;

import Framework.ui.base.BaseDialog;

import javax.swing.*;
import java.awt.*;

/**
 * @author MinPhone, Seid, Asrat
 */
public class GenerateBillDialog extends BaseDialog {

    protected JScrollPane scrollPane;
    private final String report;

    public GenerateBillDialog(String report) {
        this.report = report;
        reCreateUI();
    }

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
        scrollPane.getViewport().add(new TextField(report));

        jPanel.add(scrollPane);

        return jPanel;
    }

}
