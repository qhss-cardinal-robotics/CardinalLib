package org.lib.cardinallib.commands;

import java.util.function.BooleanSupplier;

/**
 * A trigger that schedules a command when a condition becomes true.
 * 
 * <p>Triggers are used to automatically schedule commands based on conditions.
 * The trigger fires on the rising edge of the condition (when it transitions
 * from false to true), ensuring the command is only scheduled once per condition
 * activation.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * Trigger buttonTrigger = new Trigger(
 *     () -> gamepad.a,
 *     new MyCommand()
 * );
 * cmdMachine.addTrigger(buttonTrigger);
 * }</pre>
 * 
 * @see CommandMachine
 * @see Command
 */
public class Trigger {

    /** The condition to check */
    private final BooleanSupplier condition;
    /** The command to schedule when the condition becomes true */
    private final Command command;
    /** The previous state of the condition (for edge detection) */
    private boolean lastState = false;

    /**
     * Creates a new trigger with the specified condition and command.
     * 
     * @param condition A supplier that returns true when the trigger should fire
     * @param command The command to schedule when the condition becomes true
     */
    public Trigger(BooleanSupplier condition, Command command) {
        this.condition = condition;
        this.command = command;
    }

    /**
     * Checks the trigger condition and returns the command if it should be scheduled.
     * 
     * <p>This method detects the rising edge of the condition (false to true transition)
     * and returns the associated command. On subsequent calls while the condition
     * remains true, this method returns null to prevent re-scheduling.</p>
     * 
     * @return The command to schedule if the condition just became true, or null otherwise
     */
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
