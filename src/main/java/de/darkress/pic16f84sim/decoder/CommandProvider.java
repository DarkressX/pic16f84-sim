package de.darkress.pic16f84sim.decoder;

import de.darkress.pic16f84sim.commands.Addlw;
import de.darkress.pic16f84sim.commands.Command;
import de.darkress.pic16f84sim.commands.Goto;
import de.darkress.pic16f84sim.commands.Nop;

import java.util.ArrayList;
import java.util.List;

public class CommandProvider extends ArrayList<Command> {
    public CommandProvider() {
        this.add(new Addlw());
        this.add(new Goto());
        this.add(new Nop());
    }
}
