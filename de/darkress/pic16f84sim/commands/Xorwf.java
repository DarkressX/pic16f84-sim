package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Xorwf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Xorwf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        int result = Memory.getRegister(address) ^ Memory.workingRegister;

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result);
        ProgramCounter.incPC();
        Cycles.addToCycles(1);
    }
}
