package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Memory;

public class BitOrientedCommandUtils
{
    protected int checkBitPlacement(int input)
    {
        return ((input & 0x0380) >>7);
    }
}
