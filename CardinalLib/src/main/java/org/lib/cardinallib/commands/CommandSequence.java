package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandSequence extends Command {

    private final List<Command> commands = new ArrayList<>();
    private int index = 0;

    public CommandSequence add(Command command) {
        commands.add(command);
        return this;
    }

    @Override
    public void init() {
        index = 0;
        if (!commands.isEmpty()) {
            commands.get(0).init();
        }
    }

    @Override
    public void update() {
        if (index >= commands.size()) return;

        Command current = commands.get(index);
        current.update();

        if (current.isFinished()) {
            index++;
            if (index < commands.size()) {
                commands.get(index).init();
            }
        }
    }

    @Override
    public boolean isFinished() {
        return index >= commands.size();
    }
}
