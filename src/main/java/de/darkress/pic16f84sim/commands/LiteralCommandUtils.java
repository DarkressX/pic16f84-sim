package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class LiteralCommandUtils
{
    Memory memory;

    public LiteralCommandUtils(Memory memory) {
        this.memory = memory;
    }

    protected void checkZeroBit(int result)
    {
        if((result % 256) == 0){
            memory.setZeroBit();
        } else{
            memory.clearZeroBit();
        }
    }

    protected void checkCarryBit(int result)
    {
        if(result > 255){
            memory.setCarryBit();
        } else{
            memory.clearCarryBit();
        }
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
