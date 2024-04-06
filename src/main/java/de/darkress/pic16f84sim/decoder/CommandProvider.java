package de.darkress.pic16f84sim.decoder;

import de.darkress.pic16f84sim.commands.*;

import java.util.ArrayList;

public class CommandProvider extends ArrayList<Command> {
    public CommandProvider() {
        this.add(new Addlw());
        this.add(new Goto());
        this.add(new Nop());
        this.add(new Rlf());
    }
}
