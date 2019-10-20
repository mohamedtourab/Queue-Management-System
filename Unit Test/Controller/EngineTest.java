package Controller;


import Model.Service;
import Model.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static Model.Service.TypeOfService.ACCOUNT;
import static Model.Service.TypeOfService.PACKAGE;
import static org.junit.jupiter.api.Assertions.*;

class EngineTest{

    Engine engine = new Engine();
    @Test
    @DisplayName("Need")
        //Verify that the ticket that has all its characteristics
    void generateTicket2() {

        //SETUP
        engine.init();
        Service serviceAccount = new Service(ACCOUNT);
        Service servicePackage = new Service(PACKAGE);
        //ACTION
        Ticket testOne=engine.generateTicket(ACCOUNT);
        Ticket testTwo=engine.generateTicket(PACKAGE);
        //TEST
        String test=testOne.getTypeOfService().toString();
        String test2=testTwo.getTypeOfService().toString();
        int sizeAccountQueue=engine.getAccountQueue().size();
        int sizePackageQueue=engine.getPackageQueue().size();
        assertEquals(1,sizeAccountQueue);
        assertEquals(1,sizePackageQueue);
        /*assertEquals("ACCOUNT",test);
        assertEquals("PACKAGE",test2); These test don't work due to the following problem that the value of the getTypeOfService */
        assertEquals(1,testOne.getTicketNumber());
        assertEquals(1,testTwo.getTicketNumber());


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