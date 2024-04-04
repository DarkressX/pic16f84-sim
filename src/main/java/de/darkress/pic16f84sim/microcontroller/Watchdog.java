package de.darkress.pic16f84sim.microcontroller;

public class Watchdog
{
    static Memory memory = Memory.Instance;
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
            memory.setRegister(0x03, memory.getRegister(0x03) & 0xEF); //Clear !TO in StatusReg
        }
    }

    public static void resetProgram()
    {
        memory.setRegister(0x03, memory.getRegister(0x03) | 0x10); //Set !T0 in StatusReg
        ProgramCounter.setProgramCounter(0);
        watchdogTimer = 18000;
    }

}
