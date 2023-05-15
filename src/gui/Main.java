package src.gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("pic16f84-sim");

        mainFrame.setSize(200,200);
        mainFrame.add(new JLabel("Beispiel JLabel"));
        mainFrame.setVisible(true);
    }
}


