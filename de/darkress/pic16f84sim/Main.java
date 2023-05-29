package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.decoder.CommandDecoder;
import de.darkress.pic16f84sim.microcontroller.Memory;
import java.util.ArrayList;

class Main
{
    public static void main(String[] args) {
        ArrayList<Command> program = new ArrayList<>();
        Memory.workingRegister = 0xAA;
        int input1 = 0x3AFF;
        program.add(CommandDecoder.decode(input1));
        program.get(0).execute();

    }
}