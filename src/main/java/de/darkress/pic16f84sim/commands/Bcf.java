package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Bcf implements Command
{
    Memory memory;
    BitOrientedCommandUtils bitOrientedCommandUtils;
    private final int address;
    private int bitPlacement;

    public Bcf(int input, Memory memory)
    {
        this.memory = memory;
        this.bitOrientedCommandUtils = new BitOrientedCommandUtils(memory);
        address = input & 0x007F;
        bitPlacement = bitOrientedCommandUtils.checkBitPlacement(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = memory.getRegister(address);
        result &= ~(1 << bitPlacement); //Mask n-th bit with 0

        memory.setRegister(address, result);
    }
}
