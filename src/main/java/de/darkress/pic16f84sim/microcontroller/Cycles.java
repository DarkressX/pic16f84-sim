package de.darkress.pic16f84sim.microcontroller;

public class Cycles {
    private static int cycles = 0;

    public static void incCycles()
    {
        Timer.decreasePrescaler();
        cycles++;
    }

    public static int getCycles() {
        return cycles;
    }
}
