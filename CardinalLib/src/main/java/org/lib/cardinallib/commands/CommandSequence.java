package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * A command that executes a sequence of commands one after another.
 * 
 * <p>CommandSequence executes commands sequentially, starting the next command
 * only after the previous one has finished. This is useful for creating complex
 * behaviors that require multiple steps in order.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * CommandSequence sequence = new CommandSequence()
 *     .add(new DriveForwardCommand(24))
 *     .add(new TurnCommand(90))
 *     .add(new DriveForwardCommand(12));
 * cmdMachine.schedule(sequence);
 * }</pre>
 * 
 * @see Command
 * @see ParallelCommand
 */
public class CommandSequence extends Command {

    /** The list of commands to execute in sequence */
    private final List<Command> commands = new ArrayList<>();
    /** The index of the currently executing command */
    private int index = 0;

    /**
     * Adds a command to the end of the sequence.
     * 
     * <p>This method supports method chaining for convenient sequence construction.</p>
     * 
     * @param command The command to add to the sequence
     * @return This CommandSequence instance for method chaining
     */
    public CommandSequence add(Command command) {
        commands.add(command);
        return this;
    }

    /**
     * Initializes the sequence by resetting to the first command and initializing it.
     */
    @Override
    public void init() {
        index = 0;
        if (!commands.isEmpty()) {
            commands.get(0).init();
        }
    }

    /**
     * Updates the current command in the sequence. When a command finishes,
     * the next command in the sequence is automatically initialized and started.
     */
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

    /**
     * Checks if all commands in the sequence have finished.
     * 
     * @return {@code true} if all commands have completed, {@code false} otherwise
     */
    @Override
    public boolean isFinished() {
        return index >= commands.size();
    }
}
