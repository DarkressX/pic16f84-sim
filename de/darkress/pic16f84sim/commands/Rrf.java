package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Rrf extends FileRegisterCommandUtils implements Command
{
    private final int address;
    private final boolean destinationBit;

    public Rrf(int input)
    {
        address = input & 0x007F;
        destinationBit = checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int register = Memory.getRegister(address);
        int newCarry = register & 0x01;
        int oldCarry = Memory.getCarryBit();
        register = (oldCarry << 7) + (register >>1);

        if(newCarry == 1)
        {
            Memory.setCarryBit();
        } else if(newCarry == 0){
            Memory.clearCarryBit();
        }

        writeToDestination(destinationBit, address, register);
    }
}
