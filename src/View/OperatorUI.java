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

    private JLabel LabelWaitAccount;
    private JLabel LabelWaitPackage;

    private JLabel Date_time;

    private JRadioButton RadioButtonCounter1;
    private JRadioButton RadioButtonCounter2;
    private JRadioButton RadioButtonCounter3;

    private JButton Next1;
    private JButton Next2;
    private JButton Next3;

    //private LocalTime myObj = LocalTime.now();
    private Date date = new Date();

    private boolean counter1_available = false;
    private boolean counter2_available = false;
    private boolean counter3_available = false;

    OperatorUI() {
        Engine engine = new Engine();
        engine.init(); //should be done by the manager

        engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);   // Should be done by customers aka CounterUI
        engine.generateTicket(Model.Service.TypeOfService.PACKAGE);   // Should be done by customers
        engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);   // Should be done by customers
        engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);   //should implement a while loop to get the new clients while using the GUI
        engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);
        engine.generateTicket(Model.Service.TypeOfService.ACCOUNT);
        engine.generateTicket(Model.Service.TypeOfService.PACKAGE);
        engine.generateTicket(Model.Service.TypeOfService.PACKAGE);

        //LabelWaitMixed.setText();
        LabelWaitAccount.setText("People Waiting for an ACCOUNT Service : " + Integer.toString(engine.getAccountQueue().size()));
        LabelWaitPackage.setText("People Waiting for an PACKAGE Service : " + Integer.toString(engine.getPackageQueue().size()));

        displayTime();
        displayCounters(counter1_available, counter2_available, counter3_available);
        RadioButtonCounter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (counter1_available) {
                    counter1_available = false;
                } else {
                    counter1_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });

        RadioButtonCounter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (counter2_available) {
                    counter2_available = false;
                } else {
                    counter2_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });

        RadioButtonCounter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (counter3_available) {
                    counter3_available = false;
                } else {
                    counter3_available = true;
                }
                displayCounters(counter1_available, counter2_available, counter3_available);
            }
        });

        Next1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter1_available) {
                    //service provided
                    if (selectCounterSize(engine,0) != 0) {

                        LabelCounter1.setText("Counter 1 : Ticket number " + selectTicket(engine, 0).toString().substring(22, 26));

                        LabelWaitAccount.setText("People Waiting for an ACCOUNT Service : " + Integer.toString(engine.getAccountQueue().size()));
                        LabelWaitPackage.setText("People Waiting for an PACKAGE Service : " + Integer.toString(engine.getPackageQueue().size()));
                        engine.callNextCustomer(engine.getCounters().get(0));
                    }
                    else{
                        LabelCounter1.setText("NO CUSTOMER LEFT");
                    }
                }
            }
        });
        Next2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter2_available) {
                    if (selectCounterSize(engine,1) != 0) {
                        LabelCounter2.setText("Counter 2 : Ticket number " + selectTicket(engine, 1).toString().substring(22, 26));

                        LabelWaitAccount.setText("People Waiting for an ACCOUNT Service : " + Integer.toString(engine.getAccountQueue().size()));
                        LabelWaitPackage.setText("People Waiting for an PACKAGE Service : " + Integer.toString(engine.getPackageQueue().size()));
                        engine.callNextCustomer(engine.getCounters().get(1));
                    }
                    else{
                        LabelCounter2.setText("NOT TODAY");
                    }
                }
            }
        });
        Next3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter3_available) {
                    if (selectCounterSize(engine,2) != 0) {
                        LabelCounter3.setText("Counter 3 : Ticket number " + selectTicket(engine, 2).toString().substring(22, 26));

                        LabelWaitAccount.setText("People Waiting for an ACCOUNT Service : " + Integer.toString(engine.getAccountQueue().size()));
                        LabelWaitPackage.setText("People Waiting for an PACKAGE Service : " + Integer.toString(engine.getPackageQueue().size()));
                        engine.callNextCustomer(engine.getCounters().get(2));
                    }
                    else{
                        LabelCounter3.setText("NOT TODAY");
                    }
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

    //select the good counter according to the ticket of the customer
    private Ticket selectTicket(Engine engine, int number_counter) {
        if (engine.getCounters().get(number_counter).getServiceProvided() == Counter.serviceProvidedByCounter.PACKAGE) {
            return engine.getPackageQueue().element();
        }
        if (engine.getCounters().get(number_counter).getServiceProvided() == Counter.serviceProvidedByCounter.MIXED) {
            if (engine.getAccountQueue().size() > engine.getPackageQueue().size()) {
                return engine.getAccountQueue().element();
            } else {
                return engine.getPackageQueue().element();
            }
        } else {
            return engine.getAccountQueue().element();
        }
    }

    private int selectCounterSize(Engine engine, int number_counter){
        int size = 0;
        if (engine.getCounters().get(number_counter).getServiceProvided() == Counter.serviceProvidedByCounter.PACKAGE){
            size = engine.getPackageQueue().size();
        }
        if (engine.getCounters().get(number_counter).getServiceProvided() == Counter.serviceProvidedByCounter.ACCOUNT){
            size = engine.getAccountQueue().size();
        }
        if (engine.getCounters().get(number_counter).getServiceProvided() == Counter.serviceProvidedByCounter.MIXED){
            size = engine.getAccountQueue().size() + engine.getPackageQueue().size();
        }
        return size;
    }
}
