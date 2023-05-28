package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.registers.Memory;

public class Andlw extends CommandUtils implements Command
{
    private final int literal;

    public Andlw(int input)
    {
        literal = input & 0x00FF;
    }
    @Override
    public void execute()
    {
        int result = literal & Memory.workingRegister;

        checkZeroBit(result);

        Memory.workingRegister = result % 256;
    }
}
