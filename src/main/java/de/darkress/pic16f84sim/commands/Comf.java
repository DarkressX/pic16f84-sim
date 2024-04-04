package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Comf implements Command
{
	Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;
    private final int address;
    private final boolean destinationBit;

    public Comf(int input, Memory memory)
    {
        this.memory = memory;
        this.fileRegisterCommandUtils = new FileRegisterCommandUtils(memory);
        address = input & 0x007F;
        destinationBit = fileRegisterCommandUtils.checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = 255 - memory.getRegister(address); // Get inverse of 8Bit value

        fileRegisterCommandUtils.checkZeroBit(result);

        fileRegisterCommandUtils.writeToDestination(destinationBit, address, result);
    }
}
