package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Movwf implements Command
{
    private int address;
    private boolean destinationBit;
    Memory memory;
    FileRegisterCommandUtils fileRegisterCommandUtils;

    public Movwf(){}
    @Override
    public Movwf opCodeCheck(int input) {
        if ((input & 0x3F80) == 0x80) {
            return new Movwf(input, Memory.Instance);
        }
        throw new IllegalArgumentException();
    }
    public Movwf(int input, Memory memory)
    {
        this.memory = memory;
        this.fileRegisterCommandUtils = new FileRegisterCommandUtils(memory);
        address = input & 0x007F;
        destinationBit = true;
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = memory.workingRegister;

        fileRegisterCommandUtils.writeToDestination(destinationBit, address, result);
    }
}