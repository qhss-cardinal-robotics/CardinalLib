package org.lib.cardinallib.math;

/**
 * Abstract class for robot-specific conversions.
 * Includes shooter and drivetrain formulas.
 */
public abstract class RobotFormulas {

    // ======================
    // Shooter / Projectile
    // ======================

    /**
     * Converts motor power to projectile velocity.
     * Implementation is robot-specific.
     * @param power motor power input (0.0 = stopped, 1.0 = full power)
     * @return projectile initial velocity in meters/second
     */
    public abstract double powerToVelocity(double power);

    /**
     * Converts the initial projectile velocity to motor power
     * Implementation is robot-specific
     * @param velocity projectile initial velocity in meters/second
     * @return motor power input (0.0 = stopped, 1.0 = full power)
     */
    public abstract double velocityToPower(double velocity);

    /**
     * Converts flywheel RPM to projectile velocity.
     * Implementation is robot-specific.
     * @param rpm flywheel revolutions per minute
     * @return projectile initial velocity in meters/second
     */
    public abstract double rpmToVelocity(double rpm);

    /**
     * Converts projectile velocity to flywheel RPM.
     * Implementation is robot-specific.
     * @param velocity projectile initial velocity in meters/second
     * @return flywheel RPM
     */
    public abstract double velocityToRpm(double velocity);

    // ======================
    // Drivetrain
    // ======================

    /**
     * Converts wheel encoder counts into meters traveled.
     * Implementation is robot-specific
     * @param ticks number of encoder counts recorded by the motor
     * @return distance traveled in meters
     */
    public abstract double ticksToDistance(int ticks);

    /**
     * Converts meters traveled into wheel encoder ticks.
     * Implementation is robot-specific
     * @param distanceMeters distance traveled in meters
     * @return number of encoder counts recorded by the motor
     */
    public abstract int distanceToTicks(double distanceMeters);

    /**
     * Converts a power level to linear velocity (m/s) of the robot.
     * Implementation is robot-specific
     * @param power motor power input (0.0 = stopped, 1.0 = full power)
     * @return linear velocity of the robot in meters per second
     */
    public abstract double powerToLinearVelocity(double power);

    /**
     * Converts a linear velocity (m/s) of the robot to power level.
     * Implementation is robot-specific
     * @param velocity linear velocity of the robot in meters per second
     * @return motor power input (0.0 = stopped, 1.0 = full power)
     */
    public abstract double linearVelocityToPower(double velocity);

}
