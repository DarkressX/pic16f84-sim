package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Goto extends LiteralCommandUtils implements Command
{
    private final int literal;

    public Goto(int input)
    {
        literal = input & 0x07FF;
    }

    @Override
    public void execute()
    {
        Cycles.incCycles();
        ProgramCounter.setPcFrom11BitLiteral(literal);
        Cycles.incCycles();
    }
}
