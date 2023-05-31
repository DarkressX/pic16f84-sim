package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Stack;

public class Retlw extends CommandUtils implements Command
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
        ProgramCounter.setPcFrom11BitLiteral(Stack.pop());
        //TODO: This may need some rework since it does not really load all 13 Bit into the PC. Only 8 Bit are
        // effectively set
    }
}
