import service.IFincoServiceFacade;
import ui.GUI;

public interface IFincoAbstractFactory {
    GUI getGui();
    IFincoServiceFacade getFincoService();
}
