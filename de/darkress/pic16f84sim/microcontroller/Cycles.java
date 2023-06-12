package de.darkress.pic16f84sim.microcontroller;

public class Cycles {
    private static int cycles = 0;

    public static void addToCycles(int increase)
    {
        cycles += increase;
    }

    public static int getCycles() {
        return cycles;
    }
}
