package Framework.ui.common;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * Utility Class for all UI related features.
 * Work like as <b><i>Mediator</i></b>
 *
 * @author MinPhone, Seid, Asrat
 */
public class UiUtilities {

    private static UiUtilities instance;

    private UiUtilities() {
    }

    public static UiUtilities getInstance() {
        if (instance == null) instance = new UiUtilities();
        return instance;
    }

    /**
     * Use when want to appear at the center of the whole Machine Screen.
     *
     * @param component can pass any Swing Component
     */
    public void centerFrameOnDesktop(Component component) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = component.getSize().height;
        int frameWidth = component.getSize().width;
        component.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return "";
    }

    public String getAccountTypeShortForm(String type) {
        String result = "";
        if (type.equals("Checking")) result = "Ch";
        else result = "S";
        return result;
    }

}
