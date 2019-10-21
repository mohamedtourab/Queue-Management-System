package View;

import javax.swing.*;
import java.awt.*;


public class CallScreenGUI {

    public static JTable createTable() {
        String[] columnNames = {"Ticket No.", "Counter No.", "Service Type", "Time"};
        Object[][] data = new Object[13][4];
        JTable table = new JTable(data, columnNames);
        table.setRowHeight(30);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.LIGHT_GRAY);

        return table;
    }

    public static void main(String[] args){
        int ticket_number = 2;
        int counter_number = 3;
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //table
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);

        //text
        JTextArea text = new JTextArea("");
        text.setText("\nTicket Number\n" +
                "          " + ticket_number + "\nPlease Proceed To\n" +
                "    Counter  " + counter_number + "\n");
        text.setFont(new Font("Serif", Font.PLAIN, 55));
        text.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(text);

        frame.pack();
        frame.setVisible(true);
    }
}
