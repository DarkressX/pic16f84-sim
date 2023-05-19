import java.util.Arrays;

public class Registers
{
    private static final int MEMORY_SIZE = 0xFF;  //Addressable Memory
    public static final int workingRegister = 0;
    private static final int[] memory = new int[MEMORY_SIZE];
    private static final int[] bank0UniqueSpecialRegister = new int[] {0x01,0x05,0x06,0x08,0x09}; //and many more
    private static final int[] bank1UniqueSpecialRegister = new int[] {0x81,0x85,0x86,0x88,0x89}; //and many more

    public static int getRegister(int address)
    {
        if(address == 0x0 || address == 0x80) //0x80 probably not needed because of 7-Bit address
        {
            int indirectAddress = getFSR();
            return getDataFromIndirectAddress(indirectAddress);
        }
        if(getRegisterBank() != 0)
        {
            if((Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
            {
                return memory[address + 128]; //Write to correct memory address
            }
        }
        return memory[address];
    }

    public static void setRegister(int address, int data)
    {
        if(address == 0x0 || address == 0x80)
        {
            int indirectAddress = getFSR();
            setDataFromIndirectAddress(indirectAddress, data);
            return;
        }
        if(getRegisterBank() != 0)
        {
            if((Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
            {
                memory[address + 128] = data; //Write to correct memory address
                return;
            }
        }
        memory[address] = data;
    }

    private static int getDataFromIndirectAddress(int address)
    {
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) || (Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
        {
            return memory[address];
        }
        return memory[address % 128]; // else: Registers which are mapped
    }

    private static void setDataFromIndirectAddress(int address, int data)
    {
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) || (Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
        {
            memory[address] = data;
        }
        memory[address % 128] = data; // else: Registers which are mapped
    }

    private static int getRegisterBank()
    {
        if((memory[0x03] & 0x20) == 0x0)  //Check RP0 Bit of Bank0 Status Register
        {
            return 0;
        }
        return 1;
    }

    private static int getFSR()
    {
        return memory[0x4];
    }

    public static boolean getZeroBit()
    {
        if((memory[0x03] & 0x04) == 0x04)
        {
            return true;
        }
        return false;
    }

    public static void setZeroBit()
    {
        memory[0x03] |= 0x04;
    }

    public static void clearZeroBit()
    {
        memory[0x03] &= 0xFB;
    }

    public static boolean getDigitCarryBit()
    {
        if((memory[0x03] & 0x02) == 0x02)
        {
            return true;
        }
        return false;
    }

    public static void setDigitCarryBit()
    {
        memory[0x03] |= 0x02;
    }

    public static void clearDigitCarryBit()
    {
        memory[0x03] &= 0xFD;
    }

    public static boolean getCarryBit()
    {
        if((memory[0x03] & 0x01) == 0x01)
        {
            return true;
        }
        return false;
    }

    public static void setCarryBit()
    {
        memory[0x03] |= 0x01;
    }

    public static void clearCarryBit()
    {
        memory[0x03] &= 0xFE;
    }
}
