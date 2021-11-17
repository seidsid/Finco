package banking.ui;

import Framework.service.IFincoServiceFacade;
import Framework.ui.SwingGUI;
import Framework.ui.common.UiUtilities;

import javax.swing.*;

/**
 * @author MinPhone, Seid, Asrat
 */
public class BankSwingGUI extends SwingGUI {

    private IFincoServiceFacade facade;

    public BankSwingGUI(IFincoServiceFacade facade) {
        super(facade);
        this.facade = facade;
    }

    @Override
    public void start() {
        BankMainGUI mainPageGUI = new BankMainGUI(facade);
        mainPageGUI.setTitle("Bank Application");

        mainPageGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPageGUI.setSize(650, 310);
        mainPageGUI.setVisible(true);
        UiUtilities.getInstance().centerFrameOnDesktop(mainPageGUI);
    }
}
