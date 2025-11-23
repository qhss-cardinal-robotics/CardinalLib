package org.lib.cardinallib.commands;

import java.util.ArrayList;

public class CommandSequence {
    private ArrayList<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    // runs the sequence
    public void update() {

    }
}
