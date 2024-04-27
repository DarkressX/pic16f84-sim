import de.darkress.pic16f84sim.commands.Clrf;
import de.darkress.pic16f84sim.microcontroller.Memory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ClrfTest
{
    @Test
    void clrfTest() {
        Memory mockedMemory = Mockito.mock(Memory.class);
        final int address = 0x0C;
        doNothing().when(mockedMemory).setRegister(0x0C,0);
        doNothing().when(mockedMemory).setZeroBit();
        Clrf clrf = new Clrf(address, mockedMemory);

        clrf.execute();

        verify(mockedMemory).setRegister(0x0C,0);
        verify(mockedMemory).setZeroBit();
    }
}