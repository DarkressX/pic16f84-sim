package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Retfie extends LiteralCommandUtils implements Command
{
    @Override
    public void execute()
    {
        Cycles.incCycles();
        Memory.setRegister(0x0B, Memory.getRegister(0x0B) | 0x80); //Set GIE
        ProgramCounter.setPcFromStack(Stack.pop() + 1);
        Cycles.incCycles(); // Simulate 2-Cycle Instruction
    }
}
