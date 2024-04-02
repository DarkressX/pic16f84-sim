package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class FileRegisterCommandUtils
{
    Memory memory;

    public FileRegisterCommandUtils(Memory memory) {
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

    protected void checkDigitCarryBit(int address)
    {
        int literal = memory.getRegister(address);
        if(((memory.workingRegister & 0x0F) + (literal & 0x0F)) > 15){
            memory.setDigitCarryBit();
        } else{
            memory.clearDigitCarryBit();
        }
    }

    protected void writeToDestination(boolean destinationBit, int fileAddress, int result)
    {
        if(destinationBit)
        {
            //Store in FileRegister
            memory.setRegister(fileAddress, result);
        } else {
            //Store in WRegister
            memory.workingRegister = result;
        }
    }

    protected boolean checkDestinationBit(int input)
    {
        return (input & 0x0080) == 0x0080;
    }
}
