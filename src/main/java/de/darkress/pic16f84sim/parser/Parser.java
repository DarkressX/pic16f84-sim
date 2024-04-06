package de.darkress.pic16f84sim.parser;

import de.darkress.pic16f84sim.commands.Addlw;
import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.commands.Goto;
import de.darkress.pic16f84sim.commands.Nop;
import de.darkress.pic16f84sim.decoder.CommandProvider;
import de.darkress.pic16f84sim.microcontroller.Memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser
{
    public static Command[] parser(String filePath, Memory memory)
    {
        ArrayList<String> instructions = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if(!data.startsWith(" "))
                {
                    String[] parametersFromString = data.split(" ");
                    String commandAndParametersString = "0x" + parametersFromString[1];
                    String instructionAddress = "0x" + parametersFromString[0];
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

        CommandProvider implementedCommands = new CommandProvider();

        Command[] program = new Command[1024];

        for(int i = 0; i < instructions.size(); i++)
        {
            int instructionAddress = Integer.decode(instructions.get(i).split(", ")[0]);
            int instruction = Integer.decode(instructions.get(i).split(", ")[1]);
            for(int k = 0; k < implementedCommands.size(); k++) {
                try {
                    program[instructionAddress] = implementedCommands.get(k).opCodeCheck(instruction);
                    break;
                } catch (IllegalArgumentException ignored) {
                }
            }
        }

        return program;
    }
}
