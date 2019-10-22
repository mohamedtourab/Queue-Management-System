package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Engine implements ControllerInterface {
    final static String accountString = "ACCOUNT";
    final static String packageString = "PACKAGE";
    static int accountIndex = 0;
    static int packageIndex = 0;
    // Implementing singleton Engine
    private static Engine engine;

    public static Engine getEngineInstance() {
        if (engine == null) {
            engine = new Engine();
        }
        return engine;
    }

    private Engine() {
    }

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
        counters.add(new Counter(Counter.serviceProvidedByCounter.ACCOUNT, 1));
        counters.add(new Counter(Counter.serviceProvidedByCounter.PACKAGE, 2));
        counters.add(new Counter(Counter.serviceProvidedByCounter.MIXED, 3));
        accountQueue = new LinkedList<>();
        packageQueue = new LinkedList<>();
    }

    @Override
    public Ticket generateTicket(Service.TypeOfService serviceName) {
        //Add date for ticket
        Service newService = new Service(serviceName);
        Ticket newTicket;
        if (serviceName.toString().equals(accountString)) {
            newTicket = new Ticket(new Date(), ++accountIndex, newService);
            accountQueue.add(newTicket);
        } else {
            newTicket = new Ticket(new Date(), ++packageIndex, newService);
            packageQueue.add(newTicket);
        }
        return newTicket;
    }

    //TODO the return of the callNextCustomer is just a ticket I didn't specify which counter is calling this ticket yet
    @Override
    public Ticket callNextCustomer(Counter counter) {
        int counterId = counter.getCounterId();
        String counterService = counter.getServiceProvided().toString();

        if (counterService.equals(accountString)) {
            if (accountQueue.size() > 0 && accountQueue != null) {
                return accountQueue.remove();
            } else {
                throw new RuntimeException();
            }

        } else if (counterService.equals(packageString)) {
            if (packageQueue.size() > 0 && packageQueue != null) {
                return packageQueue.remove();
            } else {
                throw new RuntimeException();
            }

        } else { //MIXED service counter
            if (accountQueue.size() > packageQueue.size()) {
                if (accountQueue.size() > 0 && accountQueue != null) {
                    return accountQueue.remove();
                } else {
                    throw new RuntimeException();
                }
            } else {
                if (packageQueue.size() > 0 && packageQueue != null) {
                    return packageQueue.remove();
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }
}
