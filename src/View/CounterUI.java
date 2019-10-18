package View;

import Controller.Engine;
import Model.Service;
import Model.Ticket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CounterUI {

    //private int accountCounter = 1;
    //private int packageCounter = 1;

    private JButton packageButton;
    private JButton accountButton;
    private JPanel panel;
    private JLabel selectServiceLabel;

    CounterUI() {
        Engine engine = new Engine();
        engine.init();
        this.packageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Ticket ticket = createNewTicket(Service.TypeOfService.PACKAGE, packageCounter);
                //JOptionPane.showMessageDialog(null, ticket, "Ticket", 1);
               // System.out.println(ticket);
               // packageCounter++;
                engine.generateTicket(Service.TypeOfService.PACKAGE);
            }
        });

        this.accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Ticket ticket = createNewTicket(Service.TypeOfService.ACCOUNT, accountCounter);
                //JOptionPane.showMessageDialog(null, ticket, "Ticket", 1);
                // System.out.println(ticket);
                // accountCounter++;
                engine.generateTicket(Service.TypeOfService.ACCOUNT);
            }
        });
    }

    public static void main(String[] args) {
        CounterUI counterUI = new CounterUI();
        JFrame Frame = new JFrame("POST OFFICE");
        Frame.setContentPane(counterUI.panel);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setSize(800, 600);
        Frame.setVisible(true);
    }

    /*private Ticket createNewTicket(Service.TypeOfService serviceType, int ticketNumber) {
        Service service = new Service(serviceType);
        Date dateAndTime = new Date();
        return new Ticket(dateAndTime, ticketNumber, service);
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
