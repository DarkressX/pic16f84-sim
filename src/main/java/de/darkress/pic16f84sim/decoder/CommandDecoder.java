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
            case 0x500:
                return new Andwf(input, memory);
            case 0x900:
                return new Comf(input, memory);
        }

        switch(input & 0x3F80)
        {
            case 0x180:
                return new Clrf(input, memory);
            case 0x100:
                return new Clrw(memory);
        }

        switch(input & 0x3C00)
        {
            case 0x1000:
                return new Bcf(input, memory);
            case 0x1400:
                return new Bsf(input, memory);
            case 0x1800:
                return new Btfsc(input, memory);
            case 0x1C00:
               return new Btfss(input, memory);
        }

        switch(input & 0x3E00)
        {
            case 0x3E00:
                return new Addlw(input, memory);
        }

        switch(input & 0x3800)
        {
            case 0x2000:
                return new Call(input);
        }

        if (input == 0x0064)
        {
            return new Clrwdt(memory);
        }

        if (input == 0x0063)
        {
            //sleep();
        }

        System.out.println("No command matched");
        return null;
    }
}
