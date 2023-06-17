package de.darkress.pic16f84sim.microcontroller;

public class Timer
{
    public static int getCyclesToTimerIncrease()
    {
        return cyclesToTimerIncrease;
    }

    public static void setCyclesToTimerIncrease(int cyclesToTimerIncrease)
    {
        Timer.cyclesToTimerIncrease = cyclesToTimerIncrease;
    }

    private static int cyclesToTimerIncrease = 1;

    private static boolean timerEnabled()
    {
        return (Memory.getOption() & 0x20) != 0x20;
    }

    public static void resetTimeToTimerIncrease()
    {
        cyclesToTimerIncrease = getPrescalerFactor();
    }

    public static boolean getPrescalerAssignment() {
        return (Memory.getOption() & 0x08) == 0x08;
    }

    private static int getPrescalerFactor() {
        final int MULTIPLIER = 2;
        int prescalerPower = Memory.getOption() & 0x07;
        int prescaler = (int)Math.pow(2, prescalerPower);
        if(!getPrescalerAssignment())
        {
            return prescaler * MULTIPLIER;
        }
        return prescaler;
    }

    private static void increaseTimerRegister()
    {
        int timerRegister = Memory.getRegister(0x01);
        timerRegister = (timerRegister + 1) % 256;
        if(timerRegister == 0) //check for timer Overflow  --> interrupt
        {
            System.out.println("Timer Overflow");
        }
        Memory.setTimer(timerRegister);
    }

    public static void decreasePrescaler()
    {
        if(getPrescalerAssignment()) { // Assigned to WatchdogTimer
            cyclesToTimerIncrease--;
            if(cyclesToTimerIncrease == 0) {
                resetTimeToTimerIncrease();
                Watchdog.decreaseWatchdogTimer();
            }
        } else {
            Watchdog.decreaseWatchdogTimer();
        }
        if(timerEnabled()) {
            if(!getPrescalerAssignment()) { // Assigned to timer0
                cyclesToTimerIncrease--;
                if(cyclesToTimerIncrease == 0) {
                    resetTimeToTimerIncrease();
                    Timer.increaseTimerRegister();
                }
            } else {
                Timer.increaseTimerRegister();
            }
        }
    }
}
