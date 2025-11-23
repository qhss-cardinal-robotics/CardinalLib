package org.lib.cardinallib.commands;

/**
 * Base class for all commands in the command-based programming framework.
 * 
 * <p>Commands represent discrete actions that the robot can perform. They follow a lifecycle:
 * <ol>
 *     <li>{@link #init()} - Called once when the command is scheduled</li>
 *     <li>{@link #update()} - Called repeatedly until the command finishes</li>
 *     <li>{@link #isFinished()} - Checked each update cycle to determine completion</li>
 * </ol>
 * </p>
 * 
 * <p>Commands are typically managed by a {@link CommandMachine} which handles scheduling
 * and execution.</p>
 * 
 * @see CommandMachine
 */
public abstract class Command {

    /**
     * Initializes the command. This method is called once when the command is scheduled.
     * Use this to set up any initial state, reset sensors, or prepare hardware.
     */
    public abstract void init();

    /**
     * Updates the command. This method is called repeatedly while the command is active.
     * Implement your command's logic here, such as setting motor powers, reading sensors,
     * or updating state.
     */
    public abstract void update();

    /**
     * Checks if the command has finished executing.
     * 
     * @return {@code true} if the command is complete and should be removed from the
     *         active command list, {@code false} otherwise
     */
    public abstract boolean isFinished();

}
