package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Rlf implements Command
{
    private int address;
    private boolean destinationBit;
    Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;

    public Rlf() {
    }

    @Override
    public Rlf opCodeCheck(int input) {
        if ((input & 0x3F00) == 0xD00) {
            return new Rlf(input, Memory.Instance);
        }
        throw new IllegalArgumentException();
    }
    public Rlf(int input, Memory memory)
    {
        this.memory = memory;
        fileRegisterCommandUtils = new FileRegisterCommandUtils(memory);
        address = input & 0x007F;
        destinationBit = fileRegisterCommandUtils.checkDestinationBit(input);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int register = memory.getRegister(address);
        int newCarry = register >>7;
        int oldCarry = memory.getCarryBit();
        register = ((register <<1) + oldCarry) & 0xFF;

        if(newCarry == 1)
        {
            memory.setCarryBit();
        } else if(newCarry == 0){
            memory.clearCarryBit();
        }

        fileRegisterCommandUtils.writeToDestination(destinationBit, address, register);
    }
}
