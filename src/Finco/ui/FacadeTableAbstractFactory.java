package Finco.ui;

import Finco.domain.ICustomer;
import Finco.service.IFincoServiceFacade;

public interface FacadeTableAbstractFactory <T extends ICustomer>{
    ITable<T> getTable();
    IFincoServiceFacade<T> getServiceFacade();
}
