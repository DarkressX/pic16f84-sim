package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Comf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Comf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = 255 - Memory.getRegister(address); // Get inverse of 8Bit value

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result);
    }
}
