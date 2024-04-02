package de.darkress.pic16f84sim.microcontroller;

import java.util.Arrays;

public enum Memory
{
    Instance;

    Memory()
    {
        memory[0x81] = 0xFF; //Option
        memory[0x85] = 0x1F; //TrisA
        memory[0x86] = 0xFF; //TrisB
        setRegister(0x03, 0x18); //Status
    }
    private final int MEMORY_SIZE = 0xFF;  //Addressable Memory
    public int workingRegister = 0;
    private final int[] memory = new int[MEMORY_SIZE];
    private final int[] bank0UniqueSpecialRegister = new int[] {0x01,0x05,0x06,0x08,0x09}; //and many more
    private final int[] bank1UniqueSpecialRegister = new int[] {0x81,0x85,0x86,0x88,0x89}; //and many more

    public int getRegister(int address)
    {
        if(address + 128 > 255) //Guard statement to check for early errors in command de.darkress.pic16f84sim.decoder or implementation
        {
            System.err.println("Guard statement triggered. The address must be 7Bit long and can therefore not exceed" +
                    " 127");
            System.exit(1);
        }
        if(address == 0x0)
        {
            int indirectAddress = getFSR();
            return getDataFromIndirectAddress(indirectAddress);
        }
        if(getRegisterBank() != 0)
        {
            if((Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address))) //Check if register ist mapped
            {
                return memory[address + 128]; //Ensure data is read from bank 1
            }
        }
        return memory[address];
    }

    public void setRegister(int address, int data)
    {
        if(address + 128 > 255) //Guard statement to check for early errors in command de.darkress.pic16f84sim.decoder or implementation
        {
            System.err.println("Guard statement triggered. The address must be 7Bit long and can therefore not exceed" +
                    " 127");
            System.exit(1);
        }
        if(address == 0x0)
        {
            int indirectAddress = getFSR();
            setDataFromIndirectAddress(indirectAddress, data);
            return;
        }
        if(address == 0x01 && !Timer.getPrescalerAssignment()) //Reset PrescalerCounter if change on Option or Timer
            // Register
        {
            Timer.resetTimeToTimerIncrease();
            Timer.setCyclesToTimerIncrease(Timer.getCyclesToTimerIncrease() - 1); //Decrease by one to account for
            // this command execution
        }
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) && getRegisterBank() == 0)
        {
            memory[address] = data;
            return;
        }
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) && getRegisterBank() == 1) //bank0
            // because of 7 Bit address
        {
            memory[address + 128] = data;
            return;
        }
        memory[address] = data;
        memory[address + 128] = data; //Ensure data is written to both banks to simulate mapping
        if(address == 0x2) //Check if PCL is destination
        {
            ProgramCounter.loadPc();
        }
    }

    private int getDataFromIndirectAddress(int address)
    {
        return memory[address];
    }

    private void setDataFromIndirectAddress(int address, int data)
    {
        if((address == 0x81 || address == 0x01) && !Timer.getPrescalerAssignment()) //Reset PrescalerCounter if change on Option or Timer Register
        {
            Timer.resetTimeToTimerIncrease();
            Timer.setCyclesToTimerIncrease(Timer.getCyclesToTimerIncrease() - 1); //Decrease by one to account for
            // this command execution
        }
        if((Arrays.stream(bank0UniqueSpecialRegister).anyMatch(x -> x == address)) || (Arrays.stream(bank1UniqueSpecialRegister).anyMatch(x -> x == address)))
        {
            memory[address] = data;
            return;
        }
        memory[address % 128] = data; // else: Registers.Registers which are mapped
        memory[address % 128 + 128] = data; //Ensure data is written to both banks to simulate mapping
    }

    private int getRegisterBank()
    {
        if((memory[0x03] & 0x20) == 0x0)  //Check RP0 Bit of Bank0 Status Register
        {
            return 0;
        }
        return 1;
    }

    public int getFSR()
    {
        return memory[0x4];
    }

    public int getPCL()
    {
        return memory[0x2];
    }

    public void setPCL(int data)
    {
        memory[0x2] = data;
        memory[0x82] = data;
    }

    public int getPCLATH()
    {
        return memory[0xA] & 0x1F;
    }

    public void setPCLATH(int data)
    {
        memory[0xA] = data & 0x1F;
        memory[0x8A] = data & 0x1F;
    }

    public int getOption()
    {
        return memory[0x81];
    }

    public int getPortB() {
        return memory[0x06];
    }

    public int getPortA() {
        return memory[0x05] & 0x1F;
    }
    public int getTimer()
    {
        return memory[0x01];
    }

    public void setTimer(int data)
    {
        memory[0x01] = data;
    }

    public boolean getZeroBit()
    {
        return (memory[0x03] & 0x04) == 0x04;
    }

    public void setZeroBit()
    {
        memory[0x03] |= 0x04;
        memory[0x83] |= 0x04;
    }

    public void clearZeroBit()
    {
        memory[0x03] &= 0xFB;
    }

    public boolean getDigitCarryBit()
    {
        return (memory[0x03] & 0x02) == 0x02;
    }

    public void setDigitCarryBit()
    {
        memory[0x03] |= 0x02;
        memory[0x83] |= 0x02;
    }

    public void clearDigitCarryBit()
    {
        memory[0x03] &= 0xFD;
    }

    public int getCarryBit()
    {
        if((memory[0x03] & 0x01) == 0x01)
        {
            return 1;
        }
        else return 0;
    }

    public void setCarryBit()
    {
        memory[0x03] |= 0x01;
        memory[0x83] |= 0x01;
    }

    public void clearCarryBit()
    {
        memory[0x03] &= 0xFE;
    }
}
