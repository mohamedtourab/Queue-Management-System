package View;

import Model.Ticket;

import javax.swing.*;
import java.awt.*;


public class CallScreenGUI {

    JFrame frame;
    JTextArea text;
    public CallScreenGUI() {
        frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        text = new JTextArea("");
    }

    public void refresh(Ticket ticket,int counterID){
        String ticketNumber = ticket.getTypeOfService().getServiceType().toString().charAt(0)+String.valueOf(ticket.getTicketNumber());

        text.setText("\nTicket Number\n" +
                "          " +  ticketNumber + "\nPlease Proceed To\n" +
                "    Counter  " + counterID + "\n");
        text.setFont(new Font("Serif", Font.PLAIN, 25));
        text.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(text);

        frame.pack();
        frame.setVisible(true);
    }
}
