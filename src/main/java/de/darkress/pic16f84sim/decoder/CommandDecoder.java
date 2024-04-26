package de.darkress.pic16f84sim.decoder;

import de.darkress.pic16f84sim.commands.*;
import de.darkress.pic16f84sim.microcontroller.Memory;

public class CommandDecoder
{
    public static Command decode(int input, Memory memory)
    {
        switch(input & 0x3F00)
        {
            case 0x700:
                return new Addwf(input, memory);
        }

        switch(input & 0x3F80)
        {
            case 0x180:
                return new Clrf(input, memory);
            case 0x100:
                return new Clrw(memory);
        }

        switch(input & 0x3E00)
        {
            case 0x3E00:
                return new Addlw(input, memory);
        }

        switch(input & 0x3800)
        {
            case 0x2800:
                return new Goto(input);
        }


        System.out.println("No command matched");
        return null;
    }
}
