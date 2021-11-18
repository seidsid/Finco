package Bank;

import Bank.ui.BankMainWindow;
import Finco.datastore.InMemoryDataStore;
import Finco.domain.impl.DefaultCustomer;
import Finco.service.IFincoServiceFacade;
import Finco.service.impl.DefaultFincoServiceFacade;
import Finco.ui.FacadeTableAbstractFactory;
import Finco.ui.ITable;
import Finco.ui.impl.DefaultTable;

import javax.swing.*;
import java.awt.*;

public class Bank {
    public static void main(String args[]){
        JFrame jFrame=new BankMainWindow(new FacadeTableAbstractFactory<DefaultCustomer>() {
            @Override
            public ITable<DefaultCustomer> getTable() {
                return new DefaultTable();
            }

            @Override
            public IFincoServiceFacade<DefaultCustomer> getServiceFacade() {
                return new DefaultFincoServiceFacade<>(new InMemoryDataStore<>());
            }
        });
        jFrame.setSize(new Dimension(1000,500));
        jFrame.setVisible(true);

    }
}
