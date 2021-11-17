import service.IFincoServiceFacade;
import ui.GUI;

/**
 * @author MinPhone, Seid, Asrat
 */
public interface IFincoAbstractFactory {
    GUI getGui();

    IFincoServiceFacade getFinCoService();
}
