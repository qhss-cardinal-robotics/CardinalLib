package org.lib.cardinallib.utils;

/**
 * Centralized constants for robot configuration values.
 * 
 * <p>This class serves as a single location to store tunable parameters such as
 * motor speeds, PID gains, timeouts, and other configuration values. Centralizing
 * constants makes it easier to tune robot behavior without modifying code throughout
 * the codebase.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * motor.setPower(Constants.intakeSpeed);
 * }</pre>
 */
public class Constants {

    /**
     * The default speed for the intake mechanism.
     * 
     * <p>Value should be between -1.0 and 1.0, where positive values typically
     * represent intake direction and negative values represent outtake direction.</p>
     */
    public double intakeSpeed;

}
