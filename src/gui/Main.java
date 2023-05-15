package src.gui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static JFileChooser fc = new JFileChooser();

    public static void main(String[] args)
    {


        JFrame mainFrame = new JFrame("pic16f84-sim");

        mainFrame.setSize(900,800);
        mainFrame.add(new JLabel("Beispiel JLabel"));
        mainFrame.setVisible(true);

        JMenuBar mb = new JMenuBar();
        final JMenu fileMenu = new JMenu("FILE");
        mb.add(fileMenu);
        JMenuItem open = new JMenuItem("Open");
        fileMenu.add(open);

        JPanel ltePanel = new JPanel();
        mainFrame.add(ltePanel);

        JScrollPane lte = new JScrollPane();


        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

                int chooser = fc.showOpenDialog(null);
                if(chooser == JFileChooser.APPROVE_OPTION)
                    displayFile(fc.getSelectedFile(), ltePanel);

            }
        });




        mainFrame.getContentPane().add(BorderLayout.NORTH, mb);

    }

    public static void displayFile(File file, JPanel panel){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fc.getSelectedFile().getPath()));
            String line = reader.readLine();

            while (line != null) {
                panel.add(new JLabel(line + "\n"));
                line = reader.readLine();
            }


            reader.close();

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}


