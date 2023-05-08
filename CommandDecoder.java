public class CommandDecoder
{
    public void CommandDecoder(String input)
    {
        int binaryInput = Integer.parseInt(input);

        if ((binaryInput & 0x3F00) == 0x700)
        {
            //ADDWF();
        } else if ((binaryInput & 0x3F00) == 0x500)
        {
            //ANDWF();
        } else if ((binaryInput & 0x3F80) == 0x180)
        {
            //CLRF();
        } else if ((binaryInput & 0x3F80) == 0x100)
        {
            //CLRW();
        } else if ((binaryInput & 0x3F00) == 0x900)
        {
            //COMF();
        } else if ((binaryInput & 0x3F00) == 0x300)
        {
            //DECF();
        } else if ((binaryInput & 0x3F00) == 0xB00)
        {
            //DECFSZ();
        } else if ((binaryInput & 0x3F00) == 0xA00)
        {
            //INCF();
        } else if ((binaryInput & 0x3F00) == 0xF00)
        {
            //INCFSZ();
        } else if ((binaryInput & 0x3F00) == 0x400)
        {
            //IORWF();
        } else if ((binaryInput & 0x3F00) == 0x800)
        {
            //MOVF();
        } else if ((binaryInput & 0x3F80) == 0x80)
        {
            //MOVWF();
        } else if ((binaryInput & 0x7FF) == 0x0)
        {
            //NOP();
        } else if ((binaryInput & 0x3F00) == 0xD00)
        {
            //RLF();
        } else if ((binaryInput & 0x3F00) == 0xC00)
        {
            //RRF();
        } else if ((binaryInput & 0x3F00) == 0x200)
        {
            //SUBWF();
        } else if ((binaryInput & 0x3F00) == 0xE00)
        {
            //SWAPF();
        } else if ((binaryInput & 0x3F00) == 0x600)
        {
            //XORWF();
        } else if ((binaryInput & 0xF000) == 0x4000)
        {
            //BCF
        } else if ((binaryInput & 0xF000) == 0x5000)
        {
            //BSF
        } else if ((binaryInput & 0xF000) == 0x6000)
        {
            //BTFSC
        } else if ((binaryInput & 0xF000) == 0x7000)
        {
            //BTFSS
        } else if ((binaryInput & 0x3E00) == 0x3E00)
        {
            //ADDLW
        } else if ((binaryInput & 0x3F00) == 0x3900)
        {
            //ANDLW
        } else if ((binaryInput & 0x3800) == 0x2000)
        {
            //CALL
        } else if (binaryInput == 0x0064)
        {
            //Clear Watchdog Timer
        } else if ((binaryInput & 0x3800) == 0x2800)
        {
            //GOTO
        } else if ((binaryInput & 0x3F00) == 0x3800)
        {
            //IORLW
        } else if ((binaryInput & 0x3C00) == 0x3000)
        {
            //MOVLW
        } else if (binaryInput == 0x0009)
        {
            //RETFIE
        } else if ((binaryInput & 0x3C00) == 0x3400)
        {
            //RETLW    
        } else if (binaryInput == 0x0008)
        {
            //RETURN
        } else if (binaryInput == 0x0063)
        {
            //SLEEP
        } else if ((binaryInput & 0x3E00) == 0x3C00)
        {
            //SUBLW
        } else if ((binaryInput & 0x3F00) == 0x3A00)
        {
            //XORLW
        }
    }
}
