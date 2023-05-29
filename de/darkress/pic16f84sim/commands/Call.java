package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Call extends CommandUtils implements Command
{
    private final int literal;

    public Call(int input)
    {
        literal = input & 0x07FF;
    }

    @Override
    public void execute()
    {
        Stack.push(ProgramCounter.getPc() + 1);
        ProgramCounter.setPcFrom11BitLiteral(literal);
    }
}
