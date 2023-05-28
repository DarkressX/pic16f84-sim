package de.darkress.pic16f84sim.registers;


public class Stack
{
    private static int[] stack = new int[8];
    private static int stackPointer = 0;

    public static void push(int data)
    {
        stack[stackPointer] = data;
        pointNext();
    }

    public static int pop()
    {
        int tmp = stack[stackPointer];
        pointPrevious();
        return tmp;
    }

    public static int peek()
    {
        return stack[(stackPointer + 7) % 8]; //Get TopOfStack -1 +8 = 7 and modulo 8 to avoid IndexOutOfBound
    }

    private static void pointNext()
    {
        if(stackPointer == 7)
        {
            stackPointer = 0;
            return;
        }
        stackPointer++;
    }

    private static void pointPrevious()
    {
        if(stackPointer == 0)
        {
            stackPointer = 7;
            return;
        }
        stackPointer--;
    }

    public static int getStackPointer()
    {
        return stackPointer;
    }
}
