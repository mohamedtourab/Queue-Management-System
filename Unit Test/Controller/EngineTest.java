package Controller;

import Model.Counter;
import Model.Service;
import Model.Ticket;
import Controller.Engine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import java.util.LinkedList;

import static Model.Service.TypeOfService.ACCOUNT;
import static Model.Service.TypeOfService.PACKAGE;
import static org.junit.jupiter.api.Assertions.*;

class EngineTest{

    Engine engine = new Engine();
    @Test
    @DisplayName("Need")
        //Verify that the ticket that has all its characteristics
    Ticket generateTicket2(Service.TypeOfService accountOne) {

        //SETUP

        Service serviceAccount = new Service(ACCOUNT);
        Service servicePackage = new Service (PACKAGE);

        //ACTION
        Ticket testOne=engine.generateTicket(serviceAccount.getServiceType());
        engine.generateTicket(servicePackage.getServiceType());
        //TEST
        assertEquals(1,engine.getPackageQueue().size());
        assertEquals(1,engine.getAccountQueue().size());
        assertEquals(accountOne,testOne.getTypeOfService());
        assertEquals(1,testOne.getTicketNumber());
        return (testOne);

    }

    @Test
    @DisplayName("Need")
        // Verify that the method call the next customer
    void callNextCustomer() {

        //SETUP

        //ACTION

        //TEST
    }
}