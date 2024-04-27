package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Andwf implements Command
{
    Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;
    private final int address;
    private final boolean destinationBit;

    public Andwf(int input, Memory memory)
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
        int result = memory.getRegister(address) & memory.workingRegister;

        fileRegisterCommandUtils.checkZeroBit(result);

        fileRegisterCommandUtils.writeToDestination(destinationBit, address, result);
    }
}