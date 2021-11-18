package Finco;

import Finco.datastore.InMemoryDataStore;
import Finco.domain.impl.DefaultCustomer;
import Finco.service.IFincoServiceFacade;
import Finco.service.impl.DefaultFincoServiceFacade;
import Finco.ui.FacadeTableAbstractFactory;
import Finco.ui.GUI;
import Finco.ui.ITable;
import Finco.ui.impl.DefaultTable;
import Finco.ui.impl.DefaultWindow;

public class FinCo {

    public static void main(String[] args) {
        start(new DefaultWindow(new FacadeTableAbstractFactory<>() {
            @Override
            public ITable<DefaultCustomer> getTable() {
                return new DefaultTable();
            }

            @Override
            public IFincoServiceFacade<DefaultCustomer> getServiceFacade() {
                return new DefaultFincoServiceFacade<>(new InMemoryDataStore<>());
            }
        }));
    }

    public static void start(GUI gui) {
        gui.start();
    }

}
