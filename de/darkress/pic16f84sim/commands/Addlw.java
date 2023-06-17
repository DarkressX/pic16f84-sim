package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Addlw extends LiteralCommandUtils implements Command
{
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

        checkZeroBit(result);
        checkCarryBit(result);
        checkDigitCarryBit(literal);

        Memory.workingRegister = result % 256;
    }
}
