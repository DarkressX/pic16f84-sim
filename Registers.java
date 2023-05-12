public class Registers
{
    private static final int MEMORY_SIZE = 0xFF;  //Addressable Memory
    private static int bankSelect = 0;
    private static int[] bank0 = new int[MEMORY_SIZE];
    //private static int[] bank1 = new int[MEMORY_SIZE];

    public static int getRegister(int address)
    {
        if(Registers.bankSelect == 0)
        {
            return Registers.bank0[address];
        }
        return Registers.bank0[address + 0x80];

    }

    public static void setRegister(int data, int address)
    {
        if(bankSelect == 0)
        {
            bank0[address] = data;
        }
        bank0[address + 0x80] = data;
    }

    private static int checkRegisterBank()
    {
        //syncStatusRegister();
        if((bank0[0x03] & 0x20) == 0x0)  //Check RP0 Bit of Bank0 Status Register
        {
            return 0;
        }
        return 1;
    }

    private static void syncStatusRegister()
    {
        if(bankSelect == 0)
        {

        }
    }
}
