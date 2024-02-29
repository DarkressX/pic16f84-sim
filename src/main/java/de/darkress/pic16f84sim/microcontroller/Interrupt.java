package de.darkress.pic16f84sim.microcontroller;

public class Interrupt
{
    private static boolean globalInterruptEnabled() {
        return (Memory.getRegister(0x0B) & 0x80) == 0x80; // Check GIE

    }
    public static boolean checkTimerInterruptConditions() {
        boolean timerInterruptEnabled = (Memory.getRegister(0x0B) & 0x20) == 0x20;
        return globalInterruptEnabled() && timerInterruptEnabled;
    }
}
