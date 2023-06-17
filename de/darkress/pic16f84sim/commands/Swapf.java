package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Swapf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Swapf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = (Memory.getRegister(address) <<4) & 0xF0;
        int tmp = Memory.getRegister(address) >>4;
        result += tmp;

        writeToDestination(destinationBit, address, result);
    }
}
