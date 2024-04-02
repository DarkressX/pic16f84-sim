package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Andlw implements Command
{
    Memory memory;
    LiteralCommandUtils literalCommandUtils;
    private final int literal;

    public Andlw(int input, Memory memory)
    {
        literal = input & 0x00FF;
        this.memory = memory;
        this.literalCommandUtils = new LiteralCommandUtils(memory);
    }
    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal & memory.workingRegister;

        literalCommandUtils.checkZeroBit(result);

        memory.workingRegister = result % 256;
    }
}
