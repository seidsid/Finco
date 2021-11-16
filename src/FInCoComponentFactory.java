import service.IFincoServiceFacade;
import ui.GUI;
import ui.SwingGUI;

public class FInCoComponentFactory implements IFincoAbstractFactory {

    @Override
    public GUI getGui() {
        return new SwingGUI();
    }

    @Override
    public IFincoServiceFacade getFincoService() {
        return null;
    }
}
