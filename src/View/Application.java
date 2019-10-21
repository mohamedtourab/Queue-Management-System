package View;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        OperatorUI operatorUI = new OperatorUI();
        JFrame Frame1 = new JFrame("OPERATOR");
        Frame1.setContentPane(operatorUI.getPanel());
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame1.pack();
        Frame1.setSize(800, 600);
        Frame1.setVisible(true);

        CounterUI counterUI = new CounterUI();
        JFrame Frame2 = new JFrame("POST OFFICE");
        Frame2.setContentPane(counterUI.getPanel());
        Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame2.pack();
        Frame2.setSize(800, 600);
        Frame2.setVisible(true);

    }




}
