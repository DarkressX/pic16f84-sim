package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Clrf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Clrf(int input)
    {
        address = input & 0x007F;
        destinationBit = true;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        final int result = 0;

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result);
    }
}
