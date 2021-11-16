package ui;

import javax.swing.*;
import java.awt.*;

public class SwingGUI implements GUI {
    @Override
    public void start() {
        MainPageGUI mainPageGUI = new MainPageGUI();

        mainPageGUI.setTitle("FinCo Application");
        mainPageGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPageGUI.setSize(575, 310);
        mainPageGUI.setVisible(true);
        centerFrameOnDesktop(mainPageGUI);
    }

    private void centerFrameOnDesktop(Component component) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = component.getSize().height;
        int frameWidth = component.getSize().width;
        component.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
    }
}
