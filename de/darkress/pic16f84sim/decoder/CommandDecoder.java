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
                //iorwf();
                break;
            case 0x800:
                //movf();
                break;
            case 0xD00:
                //rlf();
                break;
            case 0xC00:
                //rrf();
                break;
            case 0x200:
                //subwf();
                break;
            case 0xE00:
                //swapf();
                break;
            case 0x600:
                //xorwf();
                break;
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
                //clrf();
                break;
            case 0x100:
                //clrw();
                break;
            case 0x80:
                //movwf();
                break;
        }

        switch(input & 0x3C00)
        {
            case 0x1000:
                //bcf();
                break;
            case 0x1400:
                //bsf();
                break;
            case 0x1800:
                //btfsc();
                break;
            case 0x1C00:
                //btfss();
                break;
        }

        switch(input & 0x3E00)
        {
            case 0x3E00:
                //addlw();
                return new Addlw(input);
                //break;
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
            //clrwdt();
        }

        if (input == 0x0009)
        {
            //retfie();
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
