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
        }
    }
}
