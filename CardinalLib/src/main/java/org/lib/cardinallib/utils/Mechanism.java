package org.lib.cardinallib.utils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Base class for robot mechanisms (subsystems) in the FTC framework.
 * 
 * <p>A mechanism represents a physical subsystem of the robot, such as an intake,
 * lift, drivetrain, or arm. This class provides a standardized interface for
 * initializing hardware and updating mechanism behavior during the op mode loop.</p>
 * 
 * <p>Subclasses should override {@link #init(HardwareMap)} to initialize hardware
 * and optionally override the loop methods to handle gamepad input and telemetry.</p>
 */
public abstract class Mechanism {

    /** The LinearOpMode instance that owns this mechanism */
    protected LinearOpMode opMode;

    /**
     * Initializes the mechanism's hardware components.
     * 
     * <p>This method is called once during op mode initialization to set up
     * hardware devices such as motors, servos, and sensors.</p>
     * 
     * @param hwMap The hardware map containing all robot hardware devices
     */
    public abstract void init(HardwareMap hwMap);

    /**
     * Updates the mechanism based on gamepad input.
     * 
     * <p>This method is called repeatedly during the op mode loop. Override this
     * to handle gamepad input for a single gamepad setup.</p>
     * 
     * @param gamepad The gamepad to read input from
     */
    public void loop(Gamepad gamepad) { }

    /**
     * Updates the mechanism based on gamepad input from two gamepads.
     * 
     * <p>This method is called repeatedly during the op mode loop. Override this
     * to handle gamepad input for a dual gamepad setup (e.g., driver and operator).</p>
     * 
     * @param gamepad1 The first gamepad (typically the driver gamepad)
     * @param gamepad2 The second gamepad (typically the operator gamepad)
     */
    public void loop(Gamepad gamepad1, Gamepad gamepad2) { }

    /**
     * Updates telemetry information for this mechanism.
     * 
     * <p>This method is called during the op mode loop to display mechanism state
     * on the driver station. Override this to add custom telemetry data.</p>
     * 
     * @param telemetry The telemetry object to send data to the driver station
     */
    public void telemetry(Telemetry telemetry) { }

}
