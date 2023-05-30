package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.decoder.CommandDecoder;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

import java.util.ArrayList;

class Main
{
    public static void main(String[] args) {

        ArrayList<Command> program = new ArrayList<>();
        int input1 = 0x27FF;
        program.add(CommandDecoder.decode(0x3011));
        program.add(CommandDecoder.decode(0x2003));
        program.add(CommandDecoder.decode(0x3022));
        program.add(CommandDecoder.decode(0x0008));
        while(true)
        {
            program.get(ProgramCounter.getPc()).execute();
        }
    }
}