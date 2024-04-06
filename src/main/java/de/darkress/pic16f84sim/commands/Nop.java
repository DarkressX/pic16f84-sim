package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

//Part of ByteOrientedCommandUtils
public class Nop implements Command
{
    @Override
    public Nop opCodeCheck(int input) {
        if ((input | 0x0060) == 0x0060)
        {
            return new Nop();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void execute()
    {
        // Do nothing, just increment the PC
        ProgramCounter.incPC();
        Cycles.incCycles();
    }
}
