package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Return extends LiteralCommandUtils implements Command
{
    @Override
    public void execute()
    {
        Cycles.incCycles();
        ProgramCounter.setPcFromStack(Stack.pop());
        Cycles.incCycles(); // Simulate 2-Cycle Instruction
    }
}
