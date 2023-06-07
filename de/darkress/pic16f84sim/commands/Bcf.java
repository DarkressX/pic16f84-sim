package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Bcf extends BitOrientedCommandUtils implements Command
{
    private final int address;
    private int bitPlacement;

    public Bcf(int input)
    {
        address = input & 0x007F;
        bitPlacement = checkBitPlacement(input);
    }

    @Override
    public void execute()
    {
        int result = Memory.getRegister(address);
        result &= ~(1 << bitPlacement); //Mask n-th bit with 0

        Memory.setRegister(address, result);
        ProgramCounter.incPC();
    }
}
