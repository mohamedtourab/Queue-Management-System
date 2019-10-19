package Model;

public class Counter {
    public enum serviceProvidedByCounter{
        ACCOUNT,
        PACKAGE,
        MIXED
    }
    private serviceProvidedByCounter serviceProvided;
    private Ticket currentTicket;
    private int counterId;

    public Counter(serviceProvidedByCounter serviceProvided, int counterId) {
        this.serviceProvided = serviceProvided;
        this.counterId = counterId;
    }
    public serviceProvidedByCounter getServiceProvided() {
        return serviceProvided;
    }

    public void setServiceProvided(serviceProvidedByCounter serviceProvided) {
        this.serviceProvided = serviceProvided;
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) { this.currentTicket = currentTicket;
    }

    public int getCounterId() {
        return counterId;
    }

    public void setCounterId(int counterId) {
        this.counterId = counterId;
    }


}
