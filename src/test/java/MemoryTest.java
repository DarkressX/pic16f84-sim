import de.darkress.pic16f84sim.microcontroller.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemoryTest {
    Memory memory = Memory.Instance;

    @BeforeEach
    void cleanupMemory() {
        memory.resetMemory();
    }

    @Test
    void getRegisterAddressTooHighTest() {
        int address = 128;

        Exception exception = assertThrows(RuntimeException.class, () -> {
            memory.getRegister(address);
        });
        String resultMessage = exception.getMessage();
        String expectedMessage = "Guard statement triggered. The address must be 7Bit long and can therefore not exceed 127";

        assertEquals(expectedMessage, resultMessage);
    }
}
