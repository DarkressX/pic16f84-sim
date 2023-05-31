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
        program.add(CommandDecoder.decode(0x3011)); //Write 0x11 to W
        Memory.setRegister(0x14, 0x14);
        program.add(CommandDecoder.decode(0x0994));
        for(int i = 0; i < 2; i++)
        {
            program.get(ProgramCounter.getPc()).execute();
        }
    }
}