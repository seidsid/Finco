package ui.base;

import ui.common.OkSubmitDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;


/**
 * Base class for All JDialogs which will be used in FinCo Application
 *
 * @author MinPhone, Seid, Asrat
 */
public abstract class BaseDialog extends JDialog {

    private final JButton btnOk = new JButton("Ok");
    private final JButton btnCancel = new JButton("Cancel");
    private final OkSubmitDelegate delegate;

    private boolean isSubmitVisible = false;

    /**
     * @return Title(String), show as <i>Title</i> in the Dialog.
     */
    protected abstract String giveDialogTitle();

    /**
     * @return Width(int), provide for the Dialog <i>Width</i>.
     */
    protected abstract int giveDialogWidth();

    /**
     * @return Height(int), provide for the Dialog <i>Height</i>.
     */
    protected abstract int giveDialogHeight();

    /**
     * @return Screen Design(JPanel) which will appear in the center of the dialog.
     */
    protected abstract JPanel createUIAtCenter();

    /**
     * Default Constructor, can use when doesn't use <b><i>Ok(Submit)</i></b> Button
     */
    public BaseDialog() {
        this(null);
    }

    /**
     * We must use this Constructor when we <b><i>Ok(Submit)</i></b> Button
     *
     * @param delegate which will be used(delegate) when click <b><i>Ok(Submit)</i></b> Button click.
     * @see BaseDialog#createUIAtSouth()
     */
    public BaseDialog(OkSubmitDelegate delegate) {
        this.delegate = delegate;
        setVisible(false);
        setTitle(giveDialogTitle());
        setSize(giveDialogWidth(), giveDialogHeight());
        addUIComponent();
    }

    /**
     * add UI part in <i><b>Center</b></i>, <i><b>South</b></i> and <i><b>North</b></i> of Screen.
     *
     * @see BaseDialog#createUIAtCenter()
     * @see BaseDialog#createUIAtSouth()
     * @see BaseDialog#createUIAtNorth()
     */
    private void addUIComponent() {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(BorderLayout.CENTER, createUIAtCenter());
        getContentPane().add(BorderLayout.SOUTH, createUIAtSouth());
        getContentPane().add(BorderLayout.NORTH, createUIAtNorth());
    }

    /**
     * setup UI part in South Panel.
     */
    protected JPanel createUIAtSouth() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        if (isSubmitVisible) {
            jPanel.add(btnOk);
            btnOk.addActionListener(e -> {
                if (delegate != null) {
                    dispose();
                    delegate.onSubmitClicked(List.of(""));
                }
            });
        }
        jPanel.add(btnCancel);

        btnCancel.addActionListener(e -> dispose());

        return jPanel;
    }

    /**
     * setup UI part in North Panel.
     */
    protected JPanel createUIAtNorth() {
        JPanel jPanel = new JPanel();
        return jPanel;
    }

    /**
     * Call this method when want to add <b><i>Ok(Submit)</i></b> Button.
     */
    protected void setBtnSubmitVisible() {
        this.isSubmitVisible = true;
    }

    /**
     * @param label argument to customize <b><i>Ok(Submit)</i></b> Button Label; with default: <b><i>Ok</i></b>
     */
    protected void setBtnSubmitText(String label) {
        this.btnOk.setText(label);
    }

    /**
     * @param label argument to customize <b><i>Cancel</i></b> Button Label; with default: <b><i>Cancel</i></b>
     */
    protected void setBtnCancelText(String label) {
        this.btnCancel.setText(label);
    }

    /**
     * Need to recall this method whenever change/add the default value/UI to get an updated UI.
     */
    protected void reCreateUI() {
        addUIComponent();
    }

}
