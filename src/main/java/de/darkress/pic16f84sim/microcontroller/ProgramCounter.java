package de.darkress.pic16f84sim.microcontroller;

public class ProgramCounter

    //This class is not actual part of the µC. It is a storage for the current value of the PC
{
    static Memory memory = Memory.Instance;
    private static int pc = 0;

    public static int getPc()
    {
        return pc;
    }

    public static void setPcFrom11BitLiteral(int data)
    {
        int pcl = data & 0x00FF;
        int pch = memory.getPCLATH();
        pch = ((pch & 0xF8) <<8) + (data & 0x700);
        memory.setPCL(pcl);
        pc = (pch) + pcl;
    }

    public static void setPcFromStack(int stack)
    {
        pc = stack;
        memory.setPCL(pc & 0x00FF);
    }

    public static void loadPc()
    {
        pc = (memory.getPCLATH() <<8) + memory.getPCL();
    }

    public static void incPC() //is called after every instruction execution
    {
        pc++;
        memory.setPCL(pc & 0x00FF);
    }

    public static void setProgramCounter(int value) {
        if(value <= 0xFF && value >= 0)
        {
            pc = value;
            memory.setPCL(pc);
        }
    }
}
