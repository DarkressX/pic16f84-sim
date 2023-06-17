package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Subwf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Subwf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    protected void checkCarryBit(int result)
    {
        if(result <= 255){
            Memory.clearCarryBit();
        } else{
            Memory.setCarryBit();
        }
    }

    @Override
    protected void checkDigitCarryBit(int literal)
    {
        if(((literal & 0x0F) - (Memory.workingRegister & 0x0F)) < 0){
            Memory.clearDigitCarryBit();
        } else{
            Memory.setDigitCarryBit();
        }
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = Memory.getRegister(address) - Memory.workingRegister + 256;

        checkZeroBit(result);
        checkCarryBit(result);
        checkDigitCarryBit(Memory.getRegister(address));

        writeToDestination(destinationBit, address, result % 256);
    }
}
