package View;

import Controller.Engine;
import Model.Service;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsGUI {
    private JPanel mainPanel;
    private JButton accountsButton;
    private JButton shippingButton;
    public int Queue = 0;

    public StatisticsGUI() {
        Engine engine = new Engine();
        engine.init();
        accountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Queue = engine.getAccountQueue().size();
                String m = getStatistics(Service.TypeOfService.ACCOUNT);
                System.out.println(m);
            }
        });
        shippingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Queue = engine.getPackageQueue().size();
                String m = getStatistics(Service.TypeOfService.PACKAGE);
                System.out.println(m);
            }
        });
    }

    public String getStatistics(Service.TypeOfService serviceType){
        return String.format("%s Service was requested %s times today.", serviceType.toString(), Queue);
    }

    public static void main(String[] args) {
        StatisticsGUI st = new StatisticsGUI();
        JFrame Frame = new JFrame("Statistics");
        Frame.setContentPane(st.mainPanel);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setSize(800, 600);
        Frame.setVisible(true);
    }
}
