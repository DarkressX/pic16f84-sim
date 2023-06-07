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
        Memory.workingRegister = 0x01;
        Memory.setRegister(0x14, 0xA5); //240 << 224
        program.add(CommandDecoder.decode(0x0E94));
        for(int i = 0; i < program.size(); i++)
        {
            program.get(ProgramCounter.getPc()).execute();
        }
    }
}