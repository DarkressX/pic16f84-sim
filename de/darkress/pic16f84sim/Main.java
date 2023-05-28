package de.darkress.pic16f84sim;

import de.darkress.pic16f84sim.microcontroller.Stack;

class Main
{
    public static void main(String[] args) {
        /*
        ArrayList<Command> program = new ArrayList<>();
        int input1 = 0x3EFF;
        program.add(CommandDecoder.decode(input1));
        program.get(0).execute();
        */


        for(int i = 0; i < 8; i++)
        {
            Stack.push(i);
        }

        for(int i = 0; i < 16; i++)
        {
            System.out.println(Stack.peek());
            Stack.pop();
        }


    }
}