package org.lib.cardinallib.commands;

public abstract class Command {

    public abstract void init();
    public abstract void update();

    public abstract boolean isFinished();

}
