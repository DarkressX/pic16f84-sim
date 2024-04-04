package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Clrf implements Command
{
    private final int address;
    private final boolean destinationBit;
    Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;

    public Clrf(int input, Memory memory)
    {
        this.memory = memory;
        this.fileRegisterCommandUtils = new FileRegisterCommandUtils(memory);
        address = input & 0x007F;
        destinationBit = true;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        final int result = 0;

        fileRegisterCommandUtils.checkZeroBit(result);

        fileRegisterCommandUtils.writeToDestination(destinationBit, address, result);
    }
}
