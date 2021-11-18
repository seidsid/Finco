package Bank;

import Bank.ui.BankMainWindow;
import Bank.ui.BankTable;
import Finco.FinCo;
import Finco.datastore.InMemoryDataStore;
import Finco.domain.impl.DefaultCustomer;
import Finco.service.IFincoServiceFacade;
import Finco.service.impl.DefaultFincoServiceFacade;
import Finco.ui.FacadeTableAbstractFactory;
import Finco.ui.ITable;

public class Bank extends FinCo {
    public static void main(String args[]) {
        start(new BankMainWindow(new FacadeTableAbstractFactory<>() {
            @Override
            public ITable<DefaultCustomer> getTable() {
                return new BankTable();
            }

            @Override
            public IFincoServiceFacade<DefaultCustomer> getServiceFacade() {
                return new DefaultFincoServiceFacade<>(new InMemoryDataStore<>());
            }
        }));
    }
}
