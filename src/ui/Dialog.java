package ui;

import ui.impl.BaseDialog;

import java.util.function.Consumer;

public abstract class Dialog <T> extends BaseDialog {
    public abstract void setCallback(Consumer<T> consumer);
}
