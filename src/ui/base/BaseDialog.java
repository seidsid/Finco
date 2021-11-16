package ui.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseDialog extends JDialog {

    private final JButton btnOk = new JButton("Ok");
    private final JButton btnCancel = new JButton("Cancel");
    private final SymAction symAction = new SymAction();

    private boolean isSubmitVisible = false;

    protected abstract String giveDialogTitle();

    protected abstract int giveDialogWidth();

    protected abstract int giveDialogHeight();

    protected abstract JPanel createUIAtCenter();

    public BaseDialog() {
        setVisible(false);
        setTitle(giveDialogTitle());
        setSize(giveDialogWidth(), giveDialogHeight());
        addUIComponent();
        setBounds(450, 20, 300, 380);
    }

    private void addUIComponent() {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(BorderLayout.CENTER, createUIAtCenter());
        getContentPane().add(BorderLayout.SOUTH, createUIAtSouth());
        getContentPane().add(BorderLayout.NORTH, createUIAtNorth());
    }

    protected JPanel createUIAtSouth() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        if (isSubmitVisible) jPanel.add(btnOk);
        jPanel.add(btnCancel);

        btnCancel.addActionListener(symAction);

        return jPanel;
    }

    protected JPanel createUIAtNorth() {
        JPanel jPanel = new JPanel();
        return jPanel;
    }

    protected void setBtnSubmitVisible(boolean flag) {
        this.isSubmitVisible = flag;
        addUIComponent();
    }

    protected void setBtnSubmitText(String label) {
        this.btnOk.setText(label);
    }

    protected void setBtnCancelText(String label) {
        this.btnCancel.setText(label);
    }

    protected class SymAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == btnOk)
                btnOkActionPerformed(event);
            else if (object == btnCancel)
                btnCancelActionPerformed(event);
        }
    }

    private void btnOkActionPerformed(ActionEvent event) {

    }

    private void btnCancelActionPerformed(ActionEvent event) {
        dispose();
    }

}
