package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class FileRegisterCommandUtils
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

    protected void checkDigitCarryBit(int address)
    {
        int literal = Memory.getRegister(address);
        if(((Memory.workingRegister & 0x0F) + (literal & 0x0F)) > 15){
            Memory.setDigitCarryBit();
        } else{
            Memory.clearDigitCarryBit();
        }
    }

    protected void writeToDestination(boolean destinationBit, int fileAddress, int result)
    {
        if(destinationBit)
        {
            //Store in FileRegister
            Memory.setRegister(fileAddress, result);
        } else {
            //Store in WRegister
            Memory.workingRegister = result;
        }
    }

    protected boolean checkDestinationBit(int input)
    {
        return (input & 0x0080) == 0x0080;
    }
}
