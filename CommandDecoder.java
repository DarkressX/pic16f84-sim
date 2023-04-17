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
        }
    }
}
