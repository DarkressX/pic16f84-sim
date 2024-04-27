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

    @Test
    void getRegisterFromIndirectAddressTest() {
        int fileSelectRegisterAddress = 0x4;
        int indirectRegisterAddress = 0xC;
        int someNumber = 1;
        memory.setRegister(fileSelectRegisterAddress, indirectRegisterAddress);
        memory.setRegister(indirectRegisterAddress, someNumber);

        int result = memory.getRegister(0);

        assertEquals(1, result);
    }

    @Test
    void getRegisterTest() {
        int registerAddress = 0xC;
        int someNumber = 1;
        memory.setRegister(registerAddress, someNumber);

        int result = memory.getRegister(registerAddress);

        assertEquals(someNumber, result);
    }

    @Test
    void getRegisterFromBank1Test() {
        int registerAddress = 12;
        int someNumber = 1;
        memory.setRegister(registerAddress, someNumber); //Write to Register in Bank0
        memory.setRegister(0x3, 0x38); //Select Bank1

        int result = memory.getRegister(registerAddress); //return result of Register in Bank1 which is mapped to Bank0

        assertEquals(someNumber, result);
    }
}
