package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.*;

public class Clrwdt extends LiteralCommandUtils implements Command
{

    public Clrwdt()
    {
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();

        Memory.setRegister(0x03, Memory.getRegister(0x03) | 0x18);
        if(Timer.getPrescalerAssignment()) {
            Timer.resetTimeToTimerIncrease();
            Watchdog.resetWatchdogTimer();
        }
    }
}
