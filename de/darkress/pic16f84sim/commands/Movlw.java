package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Movlw extends LiteralCommandUtils implements Command
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
        ProgramCounter.incPC();
        Cycles.addToCycles(1);
    }
}
