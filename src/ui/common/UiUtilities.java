package ui.common;

import java.awt.*;

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

}
