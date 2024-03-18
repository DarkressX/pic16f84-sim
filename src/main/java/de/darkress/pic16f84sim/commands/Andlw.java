package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Andlw extends LiteralCommandUtils implements Command
{
    Memory memory;
    private final int literal;

    public Andlw(int input, Memory memory)
    {
        literal = input & 0x00FF;
        this.memory = memory;
    }
    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal & memory.workingRegister;

        checkZeroBit(result);

        memory.workingRegister = result % 256;
    }
}
