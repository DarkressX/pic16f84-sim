package de.darkress.pic16f84sim.commands;

import de.darkress.pic16f84sim.registers.Memory;

public class Sublw extends CommandUtils implements Command
{
    private final int literal;

    public Sublw(int input)
    {
        literal = input & 0x00FF;
    }

    @Override
    protected void checkCarryBit(int result)
    {
        if(result <= 255){
            Memory.clearCarryBit();
        } else{
            Memory.setCarryBit();
        }
    }

    @Override
    protected void checkDigitCarryBit(int literal)
    {
        if(((literal & 0x0F) - (Memory.workingRegister & 0x0F)) < 0){
            Memory.clearDigitCarryBit();
        } else{
            Memory.setDigitCarryBit();
        }
    }

    @Override
    public void execute()
    {
        int result = literal - Memory.workingRegister + 256;

        checkZeroBit(result);
        checkCarryBit(result);
        checkDigitCarryBit(literal);

        Memory.workingRegister = result % 256;
    }
}
