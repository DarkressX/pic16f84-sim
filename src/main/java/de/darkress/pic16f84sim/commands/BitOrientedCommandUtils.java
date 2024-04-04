package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class BitOrientedCommandUtils
{
    Memory memory;
    public BitOrientedCommandUtils(Memory memory) {
        this.memory = memory;
    }

    protected int checkBitPlacement(int input)
    {
        return ((input & 0x0380) >>7);
    }
}
