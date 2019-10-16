package Controller;

import Model.Counter;
import Model.Ticket;

public interface ControllerInterface {
   /*init() function that will initialize the counters and the services they provide
   * initialize the queues
   */
   public void init();
   /*generateTicket() it is responsible for generating a ticket for the customer based on the requested service*/
   public int generateTicket(String serviceName);
   /*callNextCustomer() this function is going to be used by the operator to call the next customer to the counter*/
   public String callNextCustomer(Counter counter);
}
