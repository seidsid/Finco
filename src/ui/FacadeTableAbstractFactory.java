package ui;

import domain.ICustomer;
import service.IFincoServiceFacade;

public interface FacadeTableAbstractFactory <T extends ICustomer>{
    ITable<T> getTable();
    IFincoServiceFacade<T> getServiceFacade();
}
