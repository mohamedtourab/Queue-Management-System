package Model;

import java.util.Date;

public class Ticket {
    private Date dateAndTime;
    private int ticketNumber;
    private Service typeOfService;

    public Ticket(Date dateAndTime, int ticketNumber, Service serviceObject) {
        this.dateAndTime = dateAndTime;
        this.ticketNumber = ticketNumber;
        this.typeOfService = serviceObject;
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

    public String toString() {
        String typeOfTicket = typeOfService.getServiceType() == Service.TypeOfService.ACCOUNT ? "A" : "P";
        return String.format(
                "Your ticket number is %s%s \n Date: %s",
                typeOfTicket,
                String.format("%3d", ticketNumber).replace(' ', '0'),
                dateAndTime
        );
    }
}
