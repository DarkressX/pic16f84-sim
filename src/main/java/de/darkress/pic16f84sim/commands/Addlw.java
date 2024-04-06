package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;

public class Addlw implements Command
{
    private int literal;
    Memory memory;
    LiteralCommandUtils literalCommandUtils;

    public Addlw() {
    }

    @Override
    public Addlw opCodeCheck(int input) {
        if ((input & 0x3E00) == 0x3E00) {
            return new Addlw(input, Memory.Instance);
        }
        throw new IllegalArgumentException();
    }

    public Addlw(int input, Memory memory)
    {
        literal = input & 0x00FF;
        this.memory = memory;
        literalCommandUtils = new LiteralCommandUtils(memory);
    }

    @Override
    public void execute()
    {
        ProgramCounter.incPC();
        Cycles.incCycles();
        int result = literal + memory.workingRegister;

        literalCommandUtils.checkZeroBit(result);
        literalCommandUtils.checkCarryBit(result);
        literalCommandUtils.checkDigitCarryBit(literal);

        memory.workingRegister = result % 256;
    }
}
