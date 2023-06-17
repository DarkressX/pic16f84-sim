package de.darkress.pic16f84sim.cli;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.Stack;
import de.darkress.pic16f84sim.microcontroller.Timer;

public class Cli
{
    public static void showRegisters() {
        printf(Memory.workingRegister, "W-Reg", true);
        printf(Cycles.getCycles(), "Cycles", false);
        System.out.printf("%n");
        printf(Memory.getRegister(0x03), "Status", true);
        printf(Memory.getOption(), "Option", true);
        System.out.printf("%n");
        printf(Memory.getFSR(), "FSR", true);
        printf(Stack.getStackPointer(), "Stackpointer", true);
        System.out.printf("%n");
        printf(Memory.getTimer(), "Timer", true);
        printf(Timer.getCyclesToTimerIncrease(), "Prescaler", true);
        System.out.printf("%n");
        printf(Memory.getPCLATH(), "PCLATH", true);
        printf(Memory.getPCL(), "PCL", true);
        System.out.printf("%n");
        System.out.printf("%s:\t\t%s\t", "PortA", Integer.toBinaryString(Memory.getPortA()));
        System.out.printf("%s:\t\t%s\t", "PortB", Integer.toBinaryString(Memory.getPortB()));
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
