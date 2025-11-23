package org.lib.cardinallib.commands;
public class WaitCommand extends Command {

    private final long durationNanos;
    private long startTime;

    public WaitCommand(double seconds) {
        this.durationNanos = (long)(seconds * 1e9);
    }

    @Override
    public void init() {
        startTime = System.nanoTime();
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isFinished() {
        return System.nanoTime() - startTime >= durationNanos;
    }
}
