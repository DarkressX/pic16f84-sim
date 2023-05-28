package de.darkress.pic16f84sim.decoder;

import de.darkress.pic16f84sim.commands.*;

public class CommandDecoder
{
    public static Command decode(int input)
    {
        switch(input & 0x3F00)
        {
            case 0x700:
                //addwf();
                break;
            case 0x500:
                //andwf();
                break;
            case 0x900:
                //comf();
                break;
            case 0x300:
                //decf();
                break;
            case 0xB00:
                //decfsz();
                break;
            case 0xA00:
                //incf();
                break;
            case 0xF00:
                //incfsz();
                break;
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
                //xorlw();
                break;
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
                //call();
                break;
            case 0x2800:
                //goto();
                break;
        }

        switch(input & 0x3C00)
        {
            case 0x3000:
                return new Movlw(input);
            case 0x3400:
                //retlw();
                break;
        }

        if ((input | 0x0060) == 0x0060)
        {
            //nop();
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
            //return();
            //This is the function name. Do not mistake this for a normal return!
        }

        if (input == 0x0063)
        {
            //sleep();
        }

        System.out.println("No command matched");
        return null;
    }
}
