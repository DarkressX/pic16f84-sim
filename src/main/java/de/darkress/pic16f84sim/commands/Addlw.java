package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Addlw implements Command
{
    private final int literal;
    Memory memory;
    LiteralCommandUtils literalCommandUtils;

    public Addlw(int input, Memory memory)
    {
        literal = input & 0x00FF;
        this.memory = memory;
        literalCommandUtils = new LiteralCommandUtils(memory);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal + memory.getWorkingRegister();

        literalCommandUtils.checkZeroBit(result);
        literalCommandUtils.checkCarryBit(result);
        literalCommandUtils.checkDigitCarryBit(literal);

        memory.setWorkingRegister(result % 256);
    }
}
