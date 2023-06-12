package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Iorlw extends LiteralCommandUtils implements Command
{
    private final int literal;

    public Iorlw(int input)
    {
        literal = input & 0x00FF;
    }
    @Override
    public void execute()
    {
        int result = literal | Memory.workingRegister;

        checkZeroBit(result);

        Memory.workingRegister = result % 256;
        ProgramCounter.incPC();
    }
}
