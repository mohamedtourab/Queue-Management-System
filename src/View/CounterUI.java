package View;

import Controller.Engine;
import Model.Service;
import Model.Ticket;

import javax.swing.*;

public class CounterUI {

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    private JButton packageButton;
    private JButton accountButton;
    private JPanel panel;
    private JLabel selectServiceLabel;
    Ticket ticket;
    CounterUI() {

        JFrame frame2 = new JFrame("POST OFFICE");
        frame2.setContentPane(panel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setSize(800, 600);
        frame2.setVisible(true);

        Engine engine = Engine.getEngineInstance();
        engine.init();
        this.packageButton.addActionListener(actionEvent -> {
                ticket = engine.generateTicket(Service.TypeOfService.PACKAGE);
                JOptionPane.showMessageDialog(null,("Ticket Number: "+
                ticket.getTypeOfService().getServiceType().toString().charAt(0)
                +ticket.getTicketNumber()
                +"\nService: "+ticket.getTypeOfService().getServiceType().toString()+"\nDate: "+ticket.getDateAndTime().toString()));
        });


        this.accountButton.addActionListener(actionEvent -> {
            ticket = engine.generateTicket(Service.TypeOfService.ACCOUNT);
            JOptionPane.showMessageDialog(null,("Ticket Number: "+
                    ticket.getTypeOfService().getServiceType().toString().charAt(0)
                    +ticket.getTicketNumber()
                    +"\nService: "+ticket.getTypeOfService().getServiceType().toString()+"\nDate: "+ticket.getDateAndTime().toString()));
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
