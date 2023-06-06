package de.darkress.pic16f84sim.commands;

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
        int carry = Memory.getCarryBit();
        int tmp = carry;
        carry = register >>7;
        register = ((register <<1) + tmp) & 0xFF;

        if(carry == 1)
        {
            Memory.setCarryBit();
        } else if(carry == 0){
            Memory.clearCarryBit();
        }

        writeToDestination(destinationBit, address, register);
        ProgramCounter.incPC();
    }
}
