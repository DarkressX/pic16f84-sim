package de.darkress.pic16f84sim.cli;

import de.darkress.pic16f84sim.microcontroller.*;

public class Cli
{
    static Memory memory = Memory.Instance;
    public static void showRegisters() {
        printf(memory.workingRegister, "W-Reg", true);
        printf(Cycles.getCycles(), "Cycles", false);
        System.out.printf("%n");
        printf(memory.getRegister(0x03), "Status", true);
        printf(memory.getOption(), "Option", true);
        System.out.printf("%n");
        printf(memory.getFSR(), "FSR", true);
        printf(Stack.getStackPointer(), "Stackpointer", true);
        System.out.printf("%n");
        printf(memory.getTimer(), "Timer", true);
        printf(Timer.getCyclesToTimerIncrease(), "Prescaler", true);
        System.out.printf("%n");
        printf(memory.getPCLATH(), "PCLATH", true);
        printf(memory.getPCL(), "PCL", true);
        System.out.printf("%n");
        System.out.printf("%s:\t\t%s\t", "PortA", Integer.toBinaryString(memory.getPortA()));
        System.out.printf("%s:\t\t%s\t", "PortB", Integer.toBinaryString(memory.getPortB()));
        System.out.printf("%n");
        printf(memory.getRegister(0x0B), "IntCon", true);
        System.out.printf("%n");
        printf(ProgramCounter.getPc(), "PC", false);
        printf(Watchdog.getWatchdogTimer(), "Watchdog", false);
        System.out.printf("%n");
    }

    private static void printf(int value, String description, boolean hex) {
        if(hex) {
            System.out.printf("%s:\t\t%s\t", description, Integer.toHexString(value));
        } else {
            System.out.printf("%s:\t\t%d\t", description, value);
        }

    }
}
