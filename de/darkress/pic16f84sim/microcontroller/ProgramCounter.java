package de.darkress.pic16f84sim.microcontroller;

public class ProgramCounter

    //This class is not actual part of the µC. It is a storage for the current value of the PC
{
    private static int PC = 0;

    public static int getPC()
    {
        return PC;
    }

    public static void setPC(int PC)
    {
        ProgramCounter.PC = PC;
    }
}
