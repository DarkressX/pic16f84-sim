package commands;

import registers.Memory;

public class CommandUtils
{
    protected void checkZeroBit(int result)
    {
        if((result % 256) == 0){
            Memory.setZeroBit();
        } else{
            Memory.clearZeroBit();
        }
    }

    protected void checkCarryBit(int result)
    {
        if(result > 255){
            Memory.setCarryBit();
        } else{
            Memory.clearCarryBit();
        }
    }

    protected void checkDigitCarryBit(int literal)
    {
        if(((Memory.workingRegister & 0x0F) + (literal & 0x0F)) > 15){
            Memory.setDigitCarryBit();
        } else{
            Memory.clearDigitCarryBit();
        }
    }
}
