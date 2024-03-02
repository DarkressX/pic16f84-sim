package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Addlw implements Command
{
    LiteralCommandUtils literalCommandUtils = new LiteralCommandUtils();
    private final int literal;

    public Addlw(int input)
    {
        literal = input & 0x00FF;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal + Memory.workingRegister;

        literalCommandUtils.checkZeroBit(result);
        literalCommandUtils.checkCarryBit(result);
        literalCommandUtils.checkDigitCarryBit(literal);

        Memory.workingRegister = result % 256;
    }
}


