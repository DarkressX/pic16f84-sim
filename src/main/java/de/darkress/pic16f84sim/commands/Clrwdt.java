package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.*;

public class Clrwdt extends LiteralCommandUtils implements Command
{
	Memory memory;
    public Clrwdt()
    {
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();

        memory.setRegister(0x03, memory.getRegister(0x03) | 0x18);
        if(Timer.getPrescalerAssignment()) {
            Timer.resetTimeToTimerIncrease();
            Watchdog.resetWatchdogTimer();
        }
    }
}
