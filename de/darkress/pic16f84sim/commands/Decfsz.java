package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Decfsz extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Decfsz(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = Memory.getRegister(address) + 255; // Allow underflow

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result % 256); // Catch underflow

        if((result % 256) == 0)
        {
            Nop nop = new Nop();
            nop.execute();
        }
    }
}
