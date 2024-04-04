package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Clrw implements Command
{
	Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;

    public Clrw(Memory memory) {
        this.memory = memory;
        this.fileRegisterCommandUtils = new FileRegisterCommandUtils(memory);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        final int result = 0;

        fileRegisterCommandUtils.checkZeroBit(result);

        memory.setWorkingRegister(result);
    }
}
