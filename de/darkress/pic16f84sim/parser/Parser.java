package de.darkress.pic16f84sim.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser
{
    public static List<Integer> parser(String filePath)
    {
        ArrayList<Integer> program = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if(!data.startsWith(" "))
                {
                    String commandAndParametersString = "0x" + data.split(" ")[1];
                    int commandAndParameters = Integer.decode(commandAndParametersString);
                    program.add(commandAndParameters);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return program;
    }
}
