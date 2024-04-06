package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

//Part of LiteralCommandUtils
public class Goto implements Command
{
    private int literal;

    public Goto() {
    }

    @Override
    public Goto opCodeCheck(int input) {
        if ((input & 0x3800) == 0x2800) {
            return new Goto(input);
        }
        throw new IllegalArgumentException();
    }

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
