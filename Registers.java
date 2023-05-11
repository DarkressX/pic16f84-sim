public class Registers
{
    private static short TMR0;
    private static short PCL;
    private static short STATUS;
    private static short FSR;
    private static short PORTA;
    private static short PORTB;
    private static short EEDATA;
    private static short EEADR;
    private static short PCLATH;
    private static short INTCON;

    public static short getTMR0()
    {
        return TMR0;
    }

    public static void setTMR0(short TMR0)
    {
        Registers.TMR0 = TMR0;
    }

    public static short getPCL()
    {
        return PCL;
    }

    public static void setPCL(short PCL)
    {
        Registers.PCL = PCL;
    }

    public static short getSTATUS()
    {
        return STATUS;
    }

    public static void setSTATUS(short STATUS)
    {
        Registers.STATUS = STATUS;
    }

    public static short getFSR()
    {
        return FSR;
    }

    public static void setFSR(short FSR)
    {
        Registers.FSR = FSR;
    }

    public static short getPORTA()
    {
        return PORTA;
    }

    public static void setPORTA(short PORTA)
    {
        Registers.PORTA = PORTA;
    }

    public static short getPORTB()
    {
        return PORTB;
    }

    public static void setPORTB(short PORTB)
    {
        Registers.PORTB = PORTB;
    }

    public static short getEEDATA()
    {
        return EEDATA;
    }

    public static void setEEDATA(short EEDATA)
    {
        Registers.EEDATA = EEDATA;
    }

    public static short getEEADR()
    {
        return EEADR;
    }

    public static void setEEADR(short EEADR)
    {
        Registers.EEADR = EEADR;
    }

    public static short getPCLATH()
    {
        return PCLATH;
    }

    public static void setPCLATH(short PCLATH)
    {
        Registers.PCLATH = PCLATH;
    }

    public static short getINTCON()
    {
        return INTCON;
    }

    public static void setINTCON(short INTCON)
    {
        Registers.INTCON = INTCON;
    }
}
