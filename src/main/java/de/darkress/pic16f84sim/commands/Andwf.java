package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Andwf extends FileRegisterCommandUtils implements Command
{
    Memory memory;
    private final int address;
    private final boolean destinationBit;

    public Andwf(int input, Memory memory)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
        this.memory = memory;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = memory.getRegister(address) & memory.workingRegister;

        checkZeroBit(result);

        writeToDestination(destinationBit, address, result);
    }
}
