package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

public class ParallelCommand extends Command {
    private final List<Command> commands = new ArrayList<>();

    public ParallelCommand add(Command cmd) {
        commands.add(cmd);
        return this;
    }

    @Override
    public void init() {
        for(Command cmd : commands) {
            cmd.init();
        }
    }

    public void update() {
        commands.removeIf(Command::isFinished);
        for(Command cmd : commands) {
            if(!cmd.isFinished()) {
                cmd.update();
            }
        }
    }

    @Override
    public boolean isFinished() {
        for(Command cmd : commands) {
            if(!cmd.isFinished()) {
                return false;
            }
        }
        return true;
    }
}
