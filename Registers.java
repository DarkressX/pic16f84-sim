import java.util.Arrays;

public class Registers
{
    private static final int MEMORY_SIZE = 0xFF;  //Addressable Memory
    //private static int bankSelect = 0;
    private static final int[] memory = new int[MEMORY_SIZE];
    private static final int[] bank0UniqueSpecialRegister = new int[] {0x01,0x05,0x06,0x08,0x09}; //and many more
    private static final int[] bank1UniqueSpecialRegister = new int[] {0x81,0x85,0x86,0x88,0x89}; //and many more

    public static int getRegister(int address)
    {
        return 5;
    }

    public static void setRegister(int address, int data)
    {

    }

    public static int getDataFromIndirectAddress(int address)
    {
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) || (Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
        {
            return memory[address];
        }
        return memory[address % 128]; // else: Registers which are mapped
    }

    public static void setDataFromIndirectAddress(int address, int data)
    {
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) || (Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
        {
            memory[address] = data;
        }
        memory[address % 128] = data; // else: Registers which are mapped
    }

    private static int checkRegisterBank()
    {
        //syncStatusRegister();
        if((memory[0x03] & 0x20) == 0x0)  //Check RP0 Bit of Bank0 Status Register
        {
            return 0;
        }
        return 1;
    }
}
