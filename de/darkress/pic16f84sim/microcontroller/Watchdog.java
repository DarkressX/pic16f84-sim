package de.darkress.pic16f84sim.microcontroller;

public class Watchdog
{
    private static int watchdogTimer = 18000;
    public static int getWatchdogTimer()
    {
        return watchdogTimer;
    }

    public static void resetWatchdogTimer() {
        watchdogTimer = 18000;
    }

    public static void decreaseWatchdogTimer()
    {
        watchdogTimer--;
        checkWatchdog();
    }

    private static void checkWatchdog()
    {
        if(watchdogTimer == 0)
        {
            System.out.println("Watchdog Time-Out");
            Memory.setRegister(0x03, Memory.getRegister(0x03) & 0xEF); //Clear !TO in StatusReg
        }
    }

    public static void resetProgram()
    {
        Memory.setRegister(0x03, Memory.getRegister(0x03) | 0x10); //Set !T0 in StatusReg
        ProgramCounter.resetProgramCounter();
        watchdogTimer = 18000;
    }

}
