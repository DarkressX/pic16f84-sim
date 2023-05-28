package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class Iorlw extends CommandUtils implements Command
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
    }
}
