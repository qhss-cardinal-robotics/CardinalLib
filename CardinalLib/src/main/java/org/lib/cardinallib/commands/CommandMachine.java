package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandMachine {

    private final List<Command> activeCommands = new ArrayList<>();
    private final List<Trigger> triggers = new ArrayList<>();

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    public void schedule(Command command) {
        command.init();
        activeCommands.add(command);
    }

    public void update() {
        activeCommands.removeIf(cmd -> {
            cmd.update();
            return cmd.isFinished();
        });

        for (Trigger t : triggers) {
            Command triggered = t.check();
            if (triggered != null) {
                schedule(triggered);
            }
        }
    }
}
