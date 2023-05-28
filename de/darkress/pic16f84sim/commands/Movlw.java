package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.registers.Memory;

public class Movlw extends CommandUtils implements Command
{
    private final int literal;

    public Movlw(int input)
    {
        literal = input & 0x00FF;
    }

    @Override
    public void execute()
    {
        Memory.workingRegister = literal;
    }
}
