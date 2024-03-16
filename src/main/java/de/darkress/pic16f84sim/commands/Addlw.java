package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Addlw extends LiteralCommandUtils implements Command
{
    private final int literal;
    Memory memory;

    public Addlw(int input, Memory memory)
    {
        literal = input & 0x00FF;
        this.memory = memory;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal + memory.workingRegister;

        checkZeroBit(result);
        checkCarryBit(result);
        checkDigitCarryBit(literal);

        memory.workingRegister = result % 256;
    }
}
