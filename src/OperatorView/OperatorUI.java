package OperatorView;

import Model.Service;
import Model.Ticket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalTime;

public class OperatorUI {
    private JPanel panel;
    private JLabel CustomersDisplay;
    private JLabel Counter1;
    private JLabel Counter2;
    private JLabel Counter3;
    private JLabel Date_time;
    private JRadioButton RadioButtonCounter1;
    private JRadioButton RadioButtonCounter2;
    private JRadioButton RadioButtonCounter3;

    //private LocalTime myObj = LocalTime.now();
    private Date date = new Date();

    private boolean counter1_available = false;
    private boolean counter2_available = false;
    private boolean counter3_available = false;


    OperatorUI() {
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
    }

    public static void main(String[] args) {
        OperatorUI operatorUI = new OperatorUI();
        JFrame Frame = new JFrame("OPERATOR");
        Frame.setContentPane(operatorUI.panel);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setSize(500, 400);
        Frame.setVisible(true);
    }

    private void displayCounters(boolean counter1_available, boolean counter2_available, boolean counter3_available) {
        if(counter1_available){
            Counter1.setVisible(true);
        }
        else{
            Counter1.setVisible(false);
        }

        if(counter2_available){
            Counter2.setVisible(true);
        }
        else{
            Counter2.setVisible(false);
        }

        if(counter3_available){
            Counter3.setVisible(true);
        }
        else{
            Counter3.setVisible(false);
        }
    }

    private void displayTime() {
        Date_time.setText(date.toString());
        //myObj
    }
}
