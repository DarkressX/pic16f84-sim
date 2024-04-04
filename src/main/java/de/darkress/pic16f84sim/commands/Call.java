package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

//Part of LiteralCommandUtils
public class Call implements Command
{
    private final int literal;

    public Call(int input)
    {
        literal = input & 0x07FF;
    }

    @Override
    public void execute()
    {
        Cycles.incCycles();
        Stack.push(ProgramCounter.getPc() + 1);
        ProgramCounter.setPcFrom11BitLiteral(literal);
        Cycles.incCycles(); //Simulate nop and 2-Cycle instruction
    }
}
