import Commands.Addlw;
import Commands.Command;
import Registers.Memory;

import java.util.ArrayList;

class HelloWorld {
    public static void main(String[] args) {
        //System.out.println(Parser.parser("TPicSim2.LST"));
        ArrayList<Command> program = new ArrayList<>();
        int input1 = 0x3EFE;
        program.add(CommandDecoder.decode(input1));
        program.get(0).execute();
    }
}