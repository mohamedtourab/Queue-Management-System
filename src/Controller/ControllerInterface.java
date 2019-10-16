package Controller;

import Model.Counter;
import Model.Service;
import Model.Ticket;

public interface ControllerInterface {
   public void init();
   public Ticket generateTicket(Service.TypeOfService serviceName);
   public Ticket callNextCustomer(Counter counter);
}
