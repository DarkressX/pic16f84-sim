package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Incfsz extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Incfsz(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        int result = Memory.getRegister(address) + 1;

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result % 256);

        if((result % 256) == 0)
        {
            ProgramCounter.incPC();
        }
        ProgramCounter.incPC();
    }
}
