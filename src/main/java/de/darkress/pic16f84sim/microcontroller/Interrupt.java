package de.darkress.pic16f84sim.microcontroller;

public class Interrupt
{
    static Memory memory = Memory.Instance;
    private static boolean globalInterruptEnabled() {
        return (memory.getRegister(0x0B) & 0x80) == 0x80; // Check GIE

    }
    public static boolean checkTimerInterruptConditions() {
        boolean timerInterruptEnabled = (memory.getRegister(0x0B) & 0x20) == 0x20;
        return globalInterruptEnabled() && timerInterruptEnabled;
    }
}
