package Model;

import java.util.Date;

public class Ticket {
    private Date dateAndTime;
    private int ticketNumber;
    private Service typeOfService;

    public Ticket(Date dateAndTime, int ticketNumber, Service typeOfService) {
        this.dateAndTime = dateAndTime;
        this.ticketNumber = ticketNumber;
        this.typeOfService = typeOfService;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        ticketNumber = ticketNumber;
    }

    public Service getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(Service typeOfService) {
        this.typeOfService = typeOfService;
    }
}
