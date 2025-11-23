package org.lib.cardinallib.math;

/**
 * Abstract base class for robot-specific conversion formulas.
 * 
 * <p>This class provides a framework for implementing robot-specific conversion
 * functions between physical quantities and control inputs. Since different robots
 * have different mechanical configurations (gear ratios, wheel sizes, motor types,
 * etc.), these conversions must be calibrated for each specific robot.</p>
 * 
 * <p><b>Purpose:</b> By abstracting these conversions, you can use the same
 * high-level code (e.g., "shoot at 5 m/s" or "drive 2 meters") across different
 * robots, with each robot providing its own implementation of these conversions.</p>
 * 
 * <p><b>Implementation:</b> To use this class, create a concrete subclass that
 * implements all abstract methods. The implementations should be based on:
 * <ul>
 *     <li>Physical measurements (wheel diameter, gear ratios, etc.)</li>
 *     <li>Empirical testing and calibration</li>
 *     <li>Motor and mechanism specifications</li>
 * </ul>
 * </p>
 * 
 * <p><b>Calibration:</b> These formulas typically require calibration through testing:
 * <ul>
 *     <li>Measure actual behavior at various inputs</li>
 *     <li>Fit curves or create lookup tables</li>
 *     <li>Account for non-linearities (friction, motor characteristics, etc.)</li>
 * </ul>
 * </p>
 * 
 * <p>Example implementation:</p>
 * <pre>{@code
 * public class MyRobotFormulas extends RobotFormulas {
 *     private static final double WHEEL_DIAMETER = 0.096; // meters
 *     private static final double TICKS_PER_REVOLUTION = 537.7;
 *     
 *     {@literal @}Override
 *     public double ticksToDistance(int ticks) {
 *         return (ticks / TICKS_PER_REVOLUTION) * Math.PI * WHEEL_DIAMETER;
 *     }
 *     // ... implement other methods
 * }
 * }</pre>
 * 
 * <p><b>Usage with MathFormulas:</b> These conversions work together with
 * {@link MathFormulas} to enable physics-based control. For example:
 * <ol>
 *     <li>Use {@link MathFormulas#calculateInitialVelocity(double, double)} to
 *         determine required projectile velocity</li>
 *     <li>Use {@link #velocityToPower(double)} or {@link #velocityToRpm(double)}
 *         to convert to motor control</li>
 * </ol>
 * </p>
 * 
 * @see MathFormulas
 */
public abstract class RobotFormulas {

    // ======================
    // Shooter / Projectile
    // ======================

    /**
     * Converts motor power to projectile launch velocity.
     * 
     * <p>This method maps motor power input (typically 0.0 to 1.0) to the resulting
     * projectile velocity. The relationship may be linear, quadratic, or follow
     * a more complex curve depending on your shooter mechanism.</p>
     * 
     * <p><b>Calibration:</b> Measure projectile velocities at various power levels
     * and fit a curve or create a lookup table. Consider factors like:
     * <ul>
     *     <li>Motor characteristics and gear ratios</li>
     *     <li>Flywheel inertia and spin-up time</li>
     *     <li>Friction and mechanical losses</li>
     * </ul>
     * </p>
     * 
     * @param power Motor power input, typically in range [0.0, 1.0] where
     *              0.0 = stopped, 1.0 = full power. May be negative for reverse.
     * @return Projectile initial velocity in meters per second
     */
    public abstract double powerToVelocity(double power);

    /**
     * Converts projectile launch velocity to required motor power.
     * 
     * <p>This is the inverse of {@link #powerToVelocity(double)}. Given a desired
     * projectile velocity, this method returns the motor power needed to achieve it.</p>
     * 
     * <p><b>Note:</b> For accurate results, this should be the mathematical inverse
     * of {@code powerToVelocity}, or derived from the same calibration data.</p>
     * 
     * @param velocity Desired projectile initial velocity in meters per second
     * @return Required motor power input, typically in range [0.0, 1.0]
     */
    public abstract double velocityToPower(double velocity);

    /**
     * Converts flywheel RPM to projectile launch velocity.
     * 
     * <p>This method is useful when controlling the shooter using closed-loop velocity
     * control (e.g., with encoders or velocity PID). The relationship depends on:
     * <ul>
     *     <li>Flywheel radius and geometry</li>
     *     <li>Contact mechanism (wheels, belts, etc.)</li>
     *     <li>Friction and slip</li>
     * </ul>
     * </p>
     * 
     * <p><b>Calibration:</b> Measure projectile velocities at various RPMs to
     * determine the relationship. This may be approximately linear for some mechanisms.</p>
     * 
     * @param rpm Flywheel revolutions per minute
     * @return Projectile initial velocity in meters per second
     */
    public abstract double rpmToVelocity(double rpm);

    /**
     * Converts projectile launch velocity to required flywheel RPM.
     * 
     * <p>This is the inverse of {@link #rpmToVelocity(double)}. Use this when you
     * know the desired projectile velocity and need to set a target RPM for
     * closed-loop control.</p>
     * 
     * <p><b>Usage:</b> Often used with velocity PID controllers that maintain
     * a target RPM setpoint.</p>
     * 
     * @param velocity Desired projectile initial velocity in meters per second
     * @return Required flywheel RPM (revolutions per minute)
     */
    public abstract double velocityToRpm(double velocity);

    // ======================
    // Drivetrain
    // ======================

    /**
     * Converts wheel encoder counts (ticks) into distance traveled.
     * 
     * <p>This conversion accounts for:
     * <ul>
     *     <li>Encoder resolution (ticks per revolution)</li>
     *     <li>Gear ratio between motor and wheel</li>
     *     <li>Wheel diameter or circumference</li>
     * </ul>
     * </p>
     * 
     * <p><b>Formula (typical):</b><br>
     * distance = (ticks / ticksPerRev) × (1 / gearRatio) × π × wheelDiameter</p>
     * 
     * <p><b>Calibration:</b> For best accuracy, measure actual distance traveled
     * over a known number of ticks and calculate the conversion factor empirically.</p>
     * 
     * @param ticks Number of encoder counts (ticks) recorded by the motor encoder
     * @return Distance traveled in meters
     */
    public abstract double ticksToDistance(int ticks);

    /**
     * Converts distance to travel into required wheel encoder ticks.
     * 
     * <p>This is the inverse of {@link #ticksToDistance(int)}. Use this for
     * position control or to calculate how many encoder ticks are needed to
     * travel a specific distance.</p>
     * 
     * <p><b>Usage:</b> Commonly used in autonomous routines to set position
     * targets for closed-loop control.</p>
     * 
     * @param distanceMeters Distance to travel in meters
     * @return Number of encoder counts (ticks) required to travel that distance
     */
    public abstract int distanceToTicks(double distanceMeters);

    /**
     * Converts motor power level to linear velocity of the robot.
     * 
     * <p>This method predicts the robot's forward velocity based on motor power.
     * The relationship may be approximately linear at moderate speeds, but can
     * be affected by:
     * <ul>
     *     <li>Friction and rolling resistance</li>
     *     <li>Motor characteristics (voltage, current limits)</li>
     *     <li>Robot mass and inertia</li>
     *     <li>Surface conditions</li>
     * </ul>
     * </p>
     * 
     * <p><b>Calibration:</b> Measure actual velocities at various power levels
     * using odometry or external sensors. Account for acceleration time if needed.</p>
     * 
     * @param power Motor power input, typically in range [-1.0, 1.0] where
     *              0.0 = stopped, 1.0 = full forward, -1.0 = full reverse
     * @return Linear velocity of the robot in meters per second
     */
    public abstract double powerToLinearVelocity(double power);

    /**
     * Converts desired linear velocity to required motor power.
     * 
     * <p>This is the inverse of {@link #powerToLinearVelocity(double)}. Use this
     * for velocity-based control where you want to maintain a specific speed.</p>
     * 
     * <p><b>Usage:</b> Useful for:
     * <ul>
     *     <li>Velocity PID control</li>
     *     <li>Maintaining constant speed during autonomous</li>
     *     <li>Feedforward control in motion profiling</li>
     * </ul>
     * </p>
     * 
     * @param velocity Desired linear velocity of the robot in meters per second
     * @return Required motor power input, typically in range [-1.0, 1.0]
     */
    public abstract double linearVelocityToPower(double velocity);

}
