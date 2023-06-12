package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Retlw extends LiteralCommandUtils implements Command
{
    private final int literal;

    public Retlw(int input)
    {
        literal = input & 0x00FF;
    }

    @Override
    public void execute()
    {
        Memory.workingRegister = literal;
        ProgramCounter.setPcFromStack(Stack.pop());
        Cycles.addToCycles(2);
    }
}
