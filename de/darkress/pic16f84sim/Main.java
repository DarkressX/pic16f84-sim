package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.decoder.CommandDecoder;
import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import de.darkress.pic16f84sim.parser.Parser;

import java.util.concurrent.TimeUnit;

class Main
{
    public static void main(String[] args) throws InterruptedException {

        Command[] program = Parser.parser("de/darkress/pic16f84sim/TPicSim101.LST");
        /*for(int i = 0; i < instructions.size(); i++)
        {
            program.add(CommandDecoder.decode(instructions.get(i)));
        }*/

        while(ProgramCounter.getPc() < 1024)
        {
            program[ProgramCounter.getPc()].execute();
            System.out.println(Memory.workingRegister + " " + Cycles.getCycles());
            System.out.println(Memory.getPCLATH() + " " + Memory.getPCL() + "\n");
        }
    }
}