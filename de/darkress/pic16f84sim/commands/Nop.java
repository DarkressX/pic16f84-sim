package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Nop extends LiteralCommandUtils implements Command
{

    @Override
    public void execute()
    {
        // Do nothing, just increment the PC
        ProgramCounter.incPC();
        Cycles.addToCycles(1);
    }
}
