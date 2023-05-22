import commands.Command;
import decoder.CommandDecoder;

import java.util.ArrayList;

class HelloWorld {
    public static void main(String[] args) {
        //System.out.println(Parser.Parser.parser("TPicSim2.LST"));
        ArrayList<Command> program = new ArrayList<>();
        int input1 = 0x3EFF;
        program.add(CommandDecoder.decode(input1));
        program.get(0).execute();
    }
}