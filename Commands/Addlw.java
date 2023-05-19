package Commands;

import Registers.Memory;

public class Addlw implements Command
{
    private int literal = 0;

    public Addlw(int input)
    {
        literal = input & 0x00FF;
    }

    @Override
    public void execute()
    {
        int result = literal + Memory.workingRegister;

        if(result == 0){
            Memory.setZeroBit();
        } else{
            Memory.clearZeroBit();
        }

        if(result > 255){
            Memory.setCarryBit();
        } else{
            Memory.clearCarryBit();
        }

        if(((Memory.workingRegister & 0x0F) + (literal & 0x0F)) > 15){
            Memory.setDigitCarryBit();
        } else{
            Memory.clearDigitCarryBit();
        }

        Memory.workingRegister = result % 256;
    }
}
