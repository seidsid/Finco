import datastore.IDataStore;
import datastore.InMemoryDataStore;
import domain.impl.DefaultCustomer;
import service.impl.DefaultFincoServiceFacade;
import ui.GUI;
import ui.SwingGUI;

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
//        IFincoAbstractFactory abstractFactory = new FinCoComponentFactory();
//        abstractFactory.getGui().start();
    }

}
