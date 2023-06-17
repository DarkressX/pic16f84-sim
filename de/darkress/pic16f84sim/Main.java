package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.decoder.CommandDecoder;
import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Watchdog;
import de.darkress.pic16f84sim.parser.Parser;

import java.util.concurrent.TimeUnit;

class Main
{
    public static void main(String[] args) throws InterruptedException {

        Command[] program = Parser.parser("de/darkress/pic16f84sim/TestPrograms/TPicSim11.LST");

        Memory.initMemory();

        while(ProgramCounter.getPc() < 1024)
        {
            if((Memory.getRegister(0x03) & 0x10) == 0x00) { // Checking WDT in Status Register
                System.out.println("Resetting device");
                Watchdog.resetProgram();
            }
            System.out.println("Command: " + program[ProgramCounter.getPc()].toString());
            program[ProgramCounter.getPc()].execute();

            System.out.println(Integer.toHexString(Memory.workingRegister) + " " + Cycles.getCycles());
            System.out.println(Integer.toHexString(Memory.getOption()) + " " + Integer.toHexString(Memory.getTimer()));

            System.out.println(Integer.toHexString(Memory.getRegister(0x20)) + " " + Integer.toHexString(Memory.getRegister(0x21)));
            System.out.println(Integer.toHexString(Memory.getRegister(0x22)) + " " + Integer.toHexString(Memory.getRegister(0x23)));

            System.out.println(Integer.toHexString(Memory.getPCLATH()) + " " + Integer.toHexString(Memory.getPCL()) + "\n");

            if(ProgramCounter.getPc() == 0x10) {
                System.out.println(Memory.getRegister(0x20));
            }
        }
    }
}