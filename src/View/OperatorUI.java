package View;

import Controller.Engine;
import Model.Service;
import Model.Ticket;
import Model.Counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Queue;

public class OperatorUI {
    private JPanel panel;

    private JLabel CustomersDisplay;

    private JLabel LabelCounter1;
    private JLabel LabelCounter2;
    private JLabel LabelCounter3;

    private Counter Counter1;
    private Counter Counter2;
    private Counter Counter3;

    private JLabel Date_time;

    private JRadioButton RadioButtonCounter1;
    private JRadioButton RadioButtonCounter2;
    private JRadioButton RadioButtonCounter3;

    private JButton Next1;
    private JButton Next2;
    private JButton Next3;

    private Engine engine;

    private Queue<Ticket> ticketqueue;

    int number = 1;

    //private LocalTime myObj = LocalTime.now();
    private Date date = new Date();

    private boolean counter1_available = false;
    private boolean counter2_available = false;
    private boolean counter3_available = false;

    OperatorUI() {
        //engine.init(); //should be done by the manager
        //engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);  // Should be done by customers
        //engine.generateTicket(Service.TypeOfService.PACKAGE);  // Should be done by customers
        //engine.generateTicket(Model.Service.TypeOfService.ACCOUNT); // Should be done by customers

        //ticketqueue = engine.getAccountQueue();

        displayTime();
        displayCounters(counter1_available, counter2_available, counter3_available);
        RadioButtonCounter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(counter1_available){
                    counter1_available = false;
                }
                else{
                    counter1_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });

        RadioButtonCounter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(counter2_available){
                    counter2_available = false;
                }
                else{
                    counter2_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });

        RadioButtonCounter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(counter3_available){
                    counter3_available = false;
                }
                else{
                    counter3_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });
        Next1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter1_available){
                    //LabelCounter1.setText("Counter 1 : Ticket number "+ engine.callNextCustomer(Counter1).getTicketNumber());
                    LabelCounter1.setText("Counter 1 : Ticket number " + number);
                    number += 1;
                }
            }
        });
        Next2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter2_available) {
                    LabelCounter2.setText("Counter 2 : Ticket number " + number);
                    number += 1;
                }
            }
        });
        Next3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter3_available) {
                    LabelCounter3.setText("Counter 3 : Ticket number " + number);
                    number += 1;
                }
            }
        });
    }

    public static void main(String[] args) {
        OperatorUI operatorUI = new OperatorUI();
        JFrame Frame = new JFrame("OPERATOR");
        Frame.setContentPane(operatorUI.panel);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setSize(800, 600);
        Frame.setVisible(true);
    }


    private void displayCounters(boolean counter1_available, boolean counter2_available, boolean counter3_available) {
        if(counter1_available){
            LabelCounter1.setVisible(true);
        }
        else{
            LabelCounter1.setVisible(false);
        }

        if(counter2_available){
            LabelCounter2.setVisible(true);
        }
        else{
            LabelCounter2.setVisible(false);
        }

        if(counter3_available){
            LabelCounter3.setVisible(true);
        }
        else{
            LabelCounter3.setVisible(false);
        }
    }

    private void displayTime() {
        Date_time.setText(date.toString());
    }
}
