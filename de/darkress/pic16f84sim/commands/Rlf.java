package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Rlf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Rlf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        int register = Memory.getRegister(address);
        int newCarry = register >>7;
        int oldCarry = Memory.getCarryBit();
        register = ((register <<1) + oldCarry) & 0xFF;

        if(newCarry == 1)
        {
            Memory.setCarryBit();
        } else if(newCarry == 0){
            Memory.clearCarryBit();
        }

        writeToDestination(destinationBit, address, register);
        ProgramCounter.incPC();
        Cycles.addToCycles(1);
    }
}
