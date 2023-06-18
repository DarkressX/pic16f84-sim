package de.darkress.pic16f84sim.decoder;

import de.darkress.pic16f84sim.commands.*;

public class CommandDecoder
{
    public static Command decode(int input)
    {
        switch(input & 0x3F00)
        {
            case 0x700:
                return new Addwf(input);
            case 0x500:
                return new Andwf(input);
            case 0x900:
                return new Comf(input);
            case 0x300:
                return new Decf(input);
            case 0xB00:
                return new Decfsz(input);
            case 0xA00:
                return new Incf(input);
            case 0xF00:
                return new Incfsz(input);
            case 0x400:
                return new Iorwf(input);
            case 0x800:
                return new Movf(input);
            case 0xD00:
                return new Rlf(input);
            case 0xC00:
                return new Rrf(input);
            case 0x200:
                return new Subwf(input);
            case 0xE00:
                return new Swapf(input);
            case 0x600:
                return new Xorwf(input);
            case 0x3900:
                return new Andlw(input);
            case 0x3800:
                return new Iorlw(input);
            case 0x3A00:
                return new Xorlw(input);
        }

        switch(input & 0x3F80)
        {
            case 0x180:
                return new Clrf(input);
            case 0x100:
                return new Clrw();
            case 0x80:
                return new Movwf(input);
        }

        switch(input & 0x3C00)
        {
            case 0x1000:
                return new Bcf(input);
            case 0x1400:
                return new Bsf(input);
            case 0x1800:
                return new Btfsc(input);
            case 0x1C00:
               return new Btfss(input);
        }

        switch(input & 0x3E00)
        {
            case 0x3E00:
                return new Addlw(input);
            case 0x3C00:
                return new Sublw(input);
        }

        switch(input & 0x3800)
        {
            case 0x2000:
                return new Call(input);
            case 0x2800:
                return new Goto(input);
        }

        switch(input & 0x3C00)
        {
            case 0x3000:
                return new Movlw(input);
            case 0x3400:
                return new Retlw(input);
        }

        if ((input | 0x0060) == 0x0060)
        {
            return new Nop();
        }

        if (input == 0x0064)
        {
            return new Clrwdt();
        }

        if (input == 0x0009)
        {
            return new Retfie();
        }

        if (input == 0x0008)
        {
            return new Return();
        }

        if (input == 0x0063)
        {
            //sleep();
        }

        System.out.println("No command matched");
        return null;
    }
}
