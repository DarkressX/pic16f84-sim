package de.darkress.pic16f84sim.microcontroller;

import java.util.Arrays;

public interface Memory {
    int MEMORY_SIZE = 0xFF;  //Addressable Memory

    int[] memory = new int[MEMORY_SIZE];

    int getWorkingRegister();

    void setWorkingRegister(int data);

    int getRegister(int address);

    void setRegister(int address, int data);

    int getFSR();

    int getPCL();

    void setPCL(int data);

    int getPCLATH();

    void setPCLATH(int data);

    int getOption();

    int getPortB();

    int getPortA();
    int getTimer();
    void setTimer(int data);

    boolean getZeroBit();

    void setZeroBit();

    void clearZeroBit();

    boolean getDigitCarryBit();

    void setDigitCarryBit();

    void clearDigitCarryBit();

    int getCarryBit();

    void setCarryBit();

    void clearCarryBit();
}
