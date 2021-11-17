package banking;

import Framework.datastore.IDataStore;
import Framework.datastore.InMemoryDataStore;
import Framework.domain.impl.DefaultCustomer;
import Framework.service.impl.DefaultFincoServiceFacade;
import Framework.ui.GUI;
import banking.ui.BankSwingGUI;

/**
 * @author MinPhone, Seid, Asrat
 */
public class Bank {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }

    public void start() {
        IDataStore<DefaultCustomer> dataStore = new InMemoryDataStore<>();
        GUI gui = new BankSwingGUI(new DefaultFincoServiceFacade(dataStore));
        gui.start();
    }

}
