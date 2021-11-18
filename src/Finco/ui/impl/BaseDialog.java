package Finco.ui.impl;

import Finco.ui.Dialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class BaseDialog<T> extends Dialog<T> {
    private JButton okButton;
    private JButton cancelButton;
    protected Consumer<T> consumer;

    public final void setCallback(Consumer<T> consumer){
        this.consumer=consumer;
    }
    public BaseDialog(){
    }

    @Override
    public void addNotify() {
        super.addNotify();
        BoxLayout boxLayout=new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
        getContentPane().setLayout(boxLayout);
        addToTOp().ifPresent(list->list.stream().forEach(getContentPane()::add));
        addToBottom().ifPresent(list->list.stream().forEach(getContentPane()::add));

        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());

        okButton=new JButton("Ok");
        cancelButton=new JButton("Cancel");

        panel.add(okButton, BorderLayout.EAST);
        panel.add(cancelButton,BorderLayout.WEST);
        cancelButton.addActionListener(e -> onCancelClick());
        okButton.addActionListener(e -> {
            onOkClick();
            dispose();
        });
        getContentPane().add(panel);
    }

    public abstract Optional<List<Component>> addToTOp();
    public abstract Optional<List<Component>> addToBottom();
    public abstract void onOkClick();
    public void onCancelClick(){
        dispose();
    }
}
