package Finco.ui.impl;

import Finco.datastore.InMemoryDataStore;
import Finco.domain.impl.DefaultCustomer;
import Finco.service.IFincoServiceFacade;
import Finco.service.impl.DefaultFincoServiceFacade;
import Finco.ui.FacadeTableAbstractFactory;
import Finco.ui.GUI;
import Finco.ui.ITable;

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
