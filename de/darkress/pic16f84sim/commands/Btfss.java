package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Btfss extends BitOrientedCommandUtils implements Command
{
    private final int address;
    private int bitPlacement;

    public Btfss(int input)
    {
        address = input & 0x007F;
        bitPlacement = checkBitPlacement(input);
    }

    @Override
    public void execute()
    {
        int result = Memory.getRegister(address);

        if((result & (1 << bitPlacement)) > 0) //Test if bit is set
        {
            ProgramCounter.incPC();
        }

        ProgramCounter.incPC();
    }
}
