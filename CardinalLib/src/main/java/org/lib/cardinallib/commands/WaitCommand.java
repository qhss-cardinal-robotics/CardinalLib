package org.lib.cardinallib.commands;

public class WaitCommand extends Command {
    private long waitDuration;
    private long startTime;
    private boolean isStarted = false;

    public WaitCommand(double seconds) {
        this.waitDuration = (long) (seconds * 1e9);
    }

    @Override
    public void init() {
        startTime = System.nanoTime();
        isStarted = true;
    }

    @Override
    public void run() {
        // Nothing extra needed, time is tracked via isFinished()
    }

    @Override
    public boolean isFinished() {
        return isStarted && System.nanoTime() - startTime >= waitDuration;
    }
}
