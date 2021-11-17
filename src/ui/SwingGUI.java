package ui;

import service.IFincoServiceFacade;
import ui.common.UiUtilities;

import javax.swing.*;

/**
 * @author MinPhone, Seid, Asrat
 */
public class SwingGUI implements GUI {

    private IFincoServiceFacade facade;

    public SwingGUI(IFincoServiceFacade facade) {
        this.facade = facade;
    }

    @Override
    public void start() {
        FinCoMainGUI mainPageGUI = new FinCoMainGUI(facade);

        mainPageGUI.setTitle("FinCo Application");
        mainPageGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPageGUI.setSize(575, 310);
        mainPageGUI.setVisible(true);
        UiUtilities.getInstance().centerFrameOnDesktop(mainPageGUI);
    }
}
