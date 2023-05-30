package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Return extends CommandUtils implements Command
{
    @Override
    public void execute()
    {
        ProgramCounter.setPcFrom11BitLiteral(Stack.pop());
    }
}
