import service.IFincoServiceFacade;
import ui.GUI;
import ui.SwingGUI;

/**
 * @author MinPhone, Seid, Asrat
 */
public class FinCoComponentFactory implements IFincoAbstractFactory {

    @Override
    public GUI getGui() {
        return new SwingGUI();
    }

    @Override
    public IFincoServiceFacade getFinCoService() {
        return null;
    }
}
