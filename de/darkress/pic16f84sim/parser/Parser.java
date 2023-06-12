package de.darkress.pic16f84sim.parser;

import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.decoder.CommandDecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser
{
    public static Command[] parser(String filePath)
    {
        ArrayList<String> instructions = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if(!data.startsWith(" "))
                {
                    String commandAndParametersString = "0x" + data.split(" ")[1];
                    String instructionAddress = "0x" + data.split(" ")[0];
                    //int commandAndParameters = Integer.decode(commandAndParametersString);
                    //program.add(commandAndParameters);
                    instructions.add(instructionAddress + ", " + commandAndParametersString);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Command[] program = new Command[1024];

        for(int i = 0; i < instructions.size(); i++)
        {
            int instructionAddress = Integer.decode(instructions.get(i).split(", ")[0]);
            int instruction = Integer.decode(instructions.get(i).split(", ")[1]);
            program[instructionAddress] = CommandDecoder.decode(instruction);
        }

        return program;
    }
}
