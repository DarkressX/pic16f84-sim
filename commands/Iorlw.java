package commands;

import registers.Memory;

public class Iorlw extends CommandUtils implements Command
{
    private final int literal;

    public Iorlw(int input)
    {
        literal = input & 0x00FF;
    }
    @Override
    public void execute()
    {
        int result = literal | Memory.workingRegister;

        checkZeroBit(result);

        Memory.workingRegister = result % 256;
    }
}
