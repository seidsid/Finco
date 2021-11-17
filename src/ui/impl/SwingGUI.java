package ui.impl;

import datastore.InMemoryDataStore;
import domain.impl.DefaultCustomer;
import service.IFincoServiceFacade;
import service.impl.DefaultFincoServiceFacade;
import ui.FacadeTableAbstractFactory;
import ui.GUI;
import ui.ITable;

import javax.swing.*;
import java.awt.*;

public class SwingGUI implements GUI {
    @Override
    public void start() {
        JFrame jFrame=new DefaultWindow(new FacadeTableAbstractFactory<DefaultCustomer>() {
            @Override
            public ITable<DefaultCustomer> getTable() {
                return new DefaultTable();
            }

            @Override
            public IFincoServiceFacade<DefaultCustomer> getServiceFacade() {
                return new DefaultFincoServiceFacade<DefaultCustomer>(new InMemoryDataStore<DefaultCustomer>());
            }
        });
        jFrame.setSize(new Dimension(1000,500));
        jFrame.setVisible(true);
    }
    public static void main(String [] args){
        new SwingGUI().start();
    }
}
