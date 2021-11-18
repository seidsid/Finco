package Framework;

import Framework.datastore.IDataStore;
import Framework.datastore.InMemoryDataStore;
import Framework.domain.impl.DefaultCustomer;
import Framework.service.impl.DefaultFincoServiceFacade;
import Framework.ui.GUI;
import Framework.ui.SwingGUI;

/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCo {

    public static void main(String[] args) {
        FinCo finCo = new FinCo();
        finCo.start();
    }

    public void start() {
        IDataStore<DefaultCustomer> dataStore = new InMemoryDataStore<>();
        GUI gui = new SwingGUI(new DefaultFincoServiceFacade(dataStore));
        gui.start();
    }

}
