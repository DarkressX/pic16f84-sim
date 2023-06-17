package de.darkress.pic16f84sim.microcontroller;

public class ProgramCounter

    //This class is not actual part of the µC. It is a storage for the current value of the PC
{
    private static int pc = 0;

    public static int getPc()
    {
        return pc;
    }

    public static void setPcFrom11BitLiteral(int data)
    {
        int pcl = data & 0x00FF;
        int pch = Memory.getPCLATH();
        pch = ((pch & 0xF8) <<8) + (data & 0x700);
        Memory.setPCL(pcl);
        pc = (pch) + pcl;
    }

    public static void setPcFromStack(int stack)
    {
        pc = stack;
        Memory.setPCL(pc & 0x00FF);
    }

    public static void loadPc()
    {
        pc = (Memory.getPCLATH() <<8) + Memory.getPCL();
    }

    public static void incPC() //is called after every instruction execution
    {
        pc++;
        Memory.setPCL(pc & 0x00FF);
    }

    public static void resetProgramCounter() {
        pc = 0;
        Memory.setPCL(0x0);
    }
}
