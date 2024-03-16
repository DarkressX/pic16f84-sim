package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.cli.Cli;
import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.microcontroller.Watchdog;
import de.darkress.pic16f84sim.parser.Parser;

class Main
{
    public static void main(String[] args) {
        Memory memory = new Memory();
        Command[] program = Parser.parser("src/main/java/de/darkress/pic16f84sim/TestPrograms/TPicSim1.LST", memory);

        while(ProgramCounter.getPc() < 1024)
        {
            if((memory.getRegister(0x03) & 0x10) == 0x00) { // Checking WDT in Status Register
                System.out.println("Resetting device");
                Watchdog.resetProgram();
            }
            String[] instructionName = program[ProgramCounter.getPc()].getClass().toString().split("\\.");
            System.out.println("Command: " + instructionName[instructionName.length -1]);
            program[ProgramCounter.getPc()].execute();
            Cli.showRegisters();
        }
    }
}