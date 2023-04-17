public class CommandDecoder
{
    public void CommandDecoder(String input) {
        int binaryInput = Integer.parseInt(input);

        if ((binaryInput & 0x3F00) == 0x700) {
            //ADDWF();
        } else if ((binaryInput & 0x3F00) == 0x500) {
            //ANDWF();
        }
    }
}
