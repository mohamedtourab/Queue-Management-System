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
        Engine engine = Engine.getEngineInstance();
        engine.init(); //should be done by the manager

        Next1.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(0));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"No customers to serve");
            }
    });
        Next2.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(1));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"No customers to serve");
            }
        });
        Next3.addActionListener(e -> {
            try {
                returnedTicket = engine.callNextCustomer(engine.getCounters().get(2));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"No customers to serve");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


    //display the counter whether it is available or not
    private void displayCounters(boolean counter1_available, boolean counter2_available, boolean counter3_available) {
        if (counter1_available) {
            LabelCounter1.setVisible(true);
        } else {
            LabelCounter1.setVisible(false);
        }

        if (counter2_available) {
            LabelCounter2.setVisible(true);
        } else {
            LabelCounter2.setVisible(false);
        }

        if (counter3_available) {
            LabelCounter3.setVisible(true);
        } else {
            LabelCounter3.setVisible(false);
        }
    }

    //display time
    private void displayTime() {
        Date_time.setText(date.toString());
    }

}