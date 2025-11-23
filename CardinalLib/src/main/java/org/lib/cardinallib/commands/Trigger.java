package org.lib.cardinallib.commands;

import java.util.function.BooleanSupplier;

public class Trigger {

    private final BooleanSupplier condition;
    private final Command command;
    private boolean lastState = false;

    public Trigger(BooleanSupplier condition, Command command) {
        this.condition = condition;
        this.command = command;
    }

    public Command check() {
        boolean current = condition.getAsBoolean();

        if (current && !lastState) {
            lastState = true;
            return command;
        }

        lastState = current;
        return null;
    }
}
