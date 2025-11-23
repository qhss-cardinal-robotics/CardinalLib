package org.lib.cardinallib.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the execution of commands and triggers in a command-based programming framework.
 * 
 * <p>The CommandMachine is responsible for:
 * <ul>
 *     <li>Scheduling and executing commands</li>
 *     <li>Managing active commands and removing them when finished</li>
 *     <li>Checking triggers and scheduling commands when conditions are met</li>
 * </ul>
 * </p>
 * 
 * <p>Typical usage in an op mode:</p>
 * <pre>{@code
 * CommandMachine cmdMachine = new CommandMachine();
 * cmdMachine.schedule(new MyCommand());
 * cmdMachine.addTrigger(new MyTrigger());
 * 
 * // In loop:
 * cmdMachine.update();
 * }</pre>
 * 
 * @see Command
 * @see Trigger
 */
public class CommandMachine {

    /** List of commands currently being executed */
    private final List<Command> activeCommands = new ArrayList<>();
    /** List of triggers that can automatically schedule commands */
    private final List<Trigger> triggers = new ArrayList<>();

    /**
     * Adds a trigger to be checked during each update cycle.
     * 
     * <p>Triggers are checked every time {@link #update()} is called. If a trigger's
     * condition is met, the associated command will be automatically scheduled.</p>
     * 
     * @param trigger The trigger to add
     */
    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    /**
     * Schedules a command for execution.
     * 
     * <p>This method initializes the command and adds it to the active commands list.
     * The command will be updated each cycle until it finishes.</p>
     * 
     * @param command The command to schedule
     */
    public void schedule(Command command) {
        command.init();
        activeCommands.add(command);
    }

    /**
     * Updates all active commands and checks all triggers.
     * 
     * <p>This method should be called repeatedly in the op mode loop. It:
     * <ol>
     *     <li>Updates all active commands</li>
     *     <li>Removes commands that have finished</li>
     *     <li>Checks all triggers and schedules commands if conditions are met</li>
     * </ol>
     * </p>
     */
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
