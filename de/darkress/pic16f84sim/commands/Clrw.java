package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Clrw extends FileRegisterCommandUtils implements Command
{
    @Override
    public void execute()
    {
        final int result = 0;

        checkZeroBit(result);

        Memory.workingRegister = result;
        ProgramCounter.incPC();
        Cycles.addToCycles(1);
    }
}
