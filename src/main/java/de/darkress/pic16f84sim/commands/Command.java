package de.darkress.pic16f84sim.commands;

public interface Command
{
    void execute();
    Command opCodeCheck(int input);
}
