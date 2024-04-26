package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class LiteralCommandUtils extends CommandUtils
{
    Memory memory;

    public LiteralCommandUtils(Memory memory) {
        super(memory);
        this.memory = memory;
    }

    protected void checkDigitCarryBit(int literal)
    {
        if(((memory.workingRegister & 0x0F) + (literal & 0x0F)) > 15){
            memory.setDigitCarryBit();
        } else{
            memory.clearDigitCarryBit();
        }
    }
}
