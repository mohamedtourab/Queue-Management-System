package View;

import Controller.Engine;
import Model.Ticket;

import javax.swing.*;
import java.util.Date;


public class OperatorUI {
    private JPanel panel;


    private JLabel CustomersDisplay;


    private JLabel LabelCounter1 = new JLabel();
    private JLabel LabelCounter2 = new JLabel();
    private JLabel LabelCounter3 = new JLabel();

    private JLabel Date_time;

    private JButton Next1;
    private JButton Next2;
    private JButton Next3;

    private Date date = new Date();

    private boolean counter1_available = false;
    private boolean counter2_available = false;
    private boolean counter3_available = false;
    private Ticket returnedTicket;

    OperatorUI() {

        JFrame frame1 = new JFrame("OPERATOR");
        frame1.setContentPane(panel);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setSize(800, 600);
        frame1.setVisible(true);
        Engine engine = Engine.getEngineInstance();
        CallScreenGUI callScreenGUI = new CallScreenGUI();
        engine.init();

        Next1.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(0));
                callScreenGUI.refresh(returnedTicket, 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No customers to serve");
            }
        });
        Next2.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(1));
                callScreenGUI.refresh(returnedTicket, 2);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No customers to serve");
            }
        });
        Next3.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(2));
                callScreenGUI.refresh(returnedTicket, 3);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No customers to serve");
            }
        });
    }

    //display time
    private void displayTime() {
        Date_time.setText(date.toString());
    }

}