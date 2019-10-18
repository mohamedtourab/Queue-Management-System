package Controller;
import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Engine implements ControllerInterface {

    public ArrayList<Counter> getCounters() {
        return counters;
    }

    public void setCounters(ArrayList<Counter> counters) {
        this.counters = counters;
    }

    public Queue<Ticket> getAccountQueue() {
        return accountQueue;
    }

    public void setAccountQueue(Queue<Ticket> accountQueue) {
        this.accountQueue = accountQueue;
    }

    public Queue<Ticket> getPackageQueue() {
        return packageQueue;
    }

    public void setPackageQueue(Queue<Ticket> packageQueue) {
        this.packageQueue = packageQueue;
    }

    private ArrayList<Counter> counters = new ArrayList<Counter>();
    private Queue<Ticket> accountQueue;
    private Queue<Ticket> packageQueue;

    @Override
    public void init() {
        counters.add(new Counter(Counter.serviceProvidedByCounter.PACKAGE,1));
        counters.add(new Counter(Counter.serviceProvidedByCounter.ACCOUNT,2));
        counters.add(new Counter(Counter.serviceProvidedByCounter.MIXED,3));
        accountQueue = new LinkedList<>();
        packageQueue = new LinkedList<>();
    }

    @Override
    public Ticket generateTicket(Service.TypeOfService serviceName) {
        //Add date for ticket
        Service newService = new Service(serviceName);
        int sizeOfQueue = 0;
        Ticket newTicket;
        if(serviceName.toString().equals("ACCOUNT")){
            sizeOfQueue = accountQueue.size();
            newTicket = new Ticket(new Date(),sizeOfQueue+1,newService);
            accountQueue.add(newTicket);
            System.out.println(newTicket);
        }
        else{
            sizeOfQueue = packageQueue.size() ;
            newTicket = new Ticket(new Date(),sizeOfQueue+1,newService);
            packageQueue.add(newTicket);
            System.out.println(newTicket);
        }
        return newTicket;
    }
//TODO the return of the callNextCustomer is just a ticket I didn't specify which counter is calling this ticket yet
    @Override
    public Ticket callNextCustomer(Counter counter) {
        int counterId =counter.getCounterId();
        final String accountString = "ACCOUNT";

        String counterService = counter.getServiceProvided().toString();

        if(counterService.equals("ACCOUNT")){
            return accountQueue.remove();
        }
        else if(counterService.equals("PACKAGE")){
            return packageQueue.remove();
        }
        else{ //MIXED service counter
            if(accountQueue.size()>packageQueue.size()){
                return accountQueue.remove();
            }
            else {
                return packageQueue.remove();
            }
        }
    }
}
