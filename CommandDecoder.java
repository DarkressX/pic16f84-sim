public class CommandDecoder
{
    public void CommandDecoder(String input) {
        int binaryInput = Integer.parseInt(input);

        if ((binaryInput & 0x3F00) == 0x700) {
            //ADDWF();
        } else if ((binaryInput & 0x3F00) == 0x500) {
            //ANDWF();
        } else if ((binaryInput & 0x7F00) == 0x3)
        {
            //CLRF();
        } else if ((binaryInput & 0x7F00) == 0x2)
        {
            //CLRW();
        } else if ((binaryInput & 0x3F00) == 0x900)
        {
            //COMF();
        } else if ((binaryInput & 0x3F00) == 0x300)
        {
            //DECF();
        }
    }
}
