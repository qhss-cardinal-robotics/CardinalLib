package org.lib.cardinallib.commands;

/**
 * A command that waits for a specified duration before finishing.
 * 
 * <p>This command is useful for creating delays in command sequences or
 * ensuring a mechanism has time to complete an action before proceeding.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * // Wait for 2.5 seconds
 * Command wait = new WaitCommand(2.5);
 * cmdMachine.schedule(wait);
 * }</pre>
 */
public class WaitCommand extends Command {

    /** The duration to wait in nanoseconds */
    private final long durationNanos;
    /** The system time when the command was initialized */
    private long startTime;

    /**
     * Creates a new WaitCommand with the specified duration.
     * 
     * @param seconds The duration to wait in seconds
     */
    public WaitCommand(double seconds) {
        this.durationNanos = (long)(seconds * 1e9);
    }

    /**
     * Initializes the wait command by recording the current time.
     */
    @Override
    public void init() {
        startTime = System.nanoTime();
    }

    /**
     * Updates the wait command. This implementation does nothing as the
     * command only needs to track time.
     */
    @Override
    public void update() {

    }

    /**
     * Checks if the wait duration has elapsed.
     * 
     * @return {@code true} if the specified duration has passed, {@code false} otherwise
     */
    @Override
    public boolean isFinished() {
        return System.nanoTime() - startTime >= durationNanos;
    }
}
