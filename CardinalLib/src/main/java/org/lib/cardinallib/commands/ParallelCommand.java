package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * A command that executes multiple commands simultaneously (in parallel).
 * 
 * <p>ParallelCommand runs all added commands concurrently, updating them all
 * each cycle. The parallel command finishes when all of its constituent commands
 * have finished. This is useful for coordinating multiple mechanisms or actions
 * that should happen at the same time.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * ParallelCommand parallel = new ParallelCommand()
 *     .add(new IntakeCommand())
 *     .add(new LiftCommand());
 * cmdMachine.schedule(parallel);
 * }</pre>
 * 
 * @see Command
 * @see CommandSequence
 */
public class ParallelCommand extends Command {
    /** The list of commands to execute in parallel */
    private final List<Command> commands = new ArrayList<>();

    /**
     * Adds a command to be executed in parallel with the others.
     * 
     * <p>This method supports method chaining for convenient parallel command construction.</p>
     * 
     * @param cmd The command to add to the parallel execution
     * @return This ParallelCommand instance for method chaining
     */
    public ParallelCommand add(Command cmd) {
        commands.add(cmd);
        return this;
    }

    /**
     * Initializes all commands in the parallel group simultaneously.
     */
    @Override
    public void init() {
        for(Command cmd : commands) {
            cmd.init();
        }
    }

    /**
     * Updates all active commands in the parallel group. Finished commands
     * are automatically removed from the active list.
     */
    public void update() {
        commands.removeIf(Command::isFinished);
        for(Command cmd : commands) {
            if(!cmd.isFinished()) {
                cmd.update();
            }
        }
    }

    /**
     * Checks if all commands in the parallel group have finished.
     * 
     * @return {@code true} if all commands have completed, {@code false} otherwise
     */
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
