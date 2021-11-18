package Finco.ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public abstract class Dialog <T> extends JDialog {
    public Dialog() {
        setSize(new Dimension(250,500));
    }

    public abstract void setCallback(Consumer<T> consumer);
}
