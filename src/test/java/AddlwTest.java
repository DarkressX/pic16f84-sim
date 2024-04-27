import de.darkress.pic16f84sim.microcontroller.Cycles;
import de.darkress.pic16f84sim.microcontroller.Memory;
import de.darkress.pic16f84sim.microcontroller.ProgramCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.darkress.pic16f84sim.commands.Addlw;

import static org.junit.jupiter.api.Assertions.*;

public class AddlwTest
{
    Memory memory = Memory.Instance;

    @BeforeEach
    void cleanupMemory() {
        memory.resetMemory();
    }

    @Test
    void addlwSimpleAdditionTest() {
        final int literal = 1;
        Addlw addlw = new Addlw(literal, memory);

        addlw.execute();

        assertEquals(0, memory.getCarryBit());
        assertEquals(1, memory.workingRegister);
    }

    @Test
    void addlwOverflowTest() {
        memory.workingRegister = 255;
        final int literal = 2;
        Addlw addlw = new Addlw(literal, memory);

        addlw.execute();

        assertTrue(memory.getDigitCarryBit());
        assertEquals(1, memory.getCarryBit());
        assertEquals(1, memory.workingRegister);
    }

    @Test
    void addlwResultZeroTest() {
        final int literal = 0;
        Addlw addlw = new Addlw(literal, memory);

        addlw.execute();

        assertTrue(memory.getZeroBit());
        assertEquals(0, memory.workingRegister);
    }

    @Test
    void addlwIncreasePCTest() {
        final int literal = 0;
        final int currentPC = ProgramCounter.getPc();
        Addlw addlw = new Addlw(literal, memory);

        addlw.execute();

        assertEquals(currentPC+1, ProgramCounter.getPc());
        assertTrue(memory.getZeroBit());
        assertEquals(0, memory.workingRegister);
    }
}
