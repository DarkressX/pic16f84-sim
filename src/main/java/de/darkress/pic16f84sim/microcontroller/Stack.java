package de.darkress.pic16f84sim.microcontroller;


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
        pointPrevious();
        return stack[stackPointer];
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
