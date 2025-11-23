package org.lib.cardinallib.math;

/**
 * Utility class for geometric and projectile motion calculations.
 * 
 * <p>Provides methods for calculating angles, distances, and projectile trajectories.
 * Projectile formulas assume standard gravity (9.81 m/s²), no air resistance, and
 * launch/landing at the same height.</p>
 * 
 * @see Pose2d
 * @see RobotFormulas
 */
public class MathFormulas {
    /** Standard gravitational acceleration constant (9.81 m/s²) */
    private static final double GRAVITY = 9.81;
    /** Small tolerance value used to avoid floating-point divide-by-zero errors */
    private static final double EPSILON = 1e-9;

    /**
     * Calculates the bearing angle from one position to another.
     * 
     * @param a Starting position (e.g., robot's current pose)
     * @param b Target position (e.g., goal or waypoint)
     * @return Bearing angle in radians from {@code a} to {@code b}, in range [-π, π]
     */
    public static double AngleFormula(Pose2d a, Pose2d b) {

        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.atan2(dy, dx);

    }

    /**
     * Calculates the Euclidean distance between two positions.
     * 
     * @param a First position
     * @param b Second position
     * @return Straight-line distance in the same units as Pose2d coordinates
     */
    public static double DistFormula(Pose2d a, Pose2d b) {

        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx * dx + dy * dy);

    }

    /**
     * Calculates the horizontal range of a projectile.
     * 
     * <p>Formula: R = (v² × sin(2θ)) / g. Maximum range occurs at 45°.</p>
     * 
     * @param v Initial velocity in m/s
     * @param theta Launch angle in radians above horizontal
     * @return Horizontal distance traveled in meters
     */
    public static double calculateRange(double v, double theta) {

        double vSquared = v * v;
        return vSquared * Math.sin(2 * theta) / GRAVITY;

    }

    /**
     * Calculates the initial velocity required to achieve a given range.
     * 
     * <p>Inverse of {@link #calculateRange(double, double)}. Formula: v = √(R × g / sin(2θ))</p>
     * 
     * @param R Desired horizontal distance in meters
     * @param theta Launch angle in radians above horizontal
     * @return Required initial velocity in m/s
     * @throws IllegalArgumentException if sin(2θ) = 0 (θ = 0 or π/2)
     */
    public static double calculateInitialVelocity(double R, double theta) {

        double denominator = Math.sin(2 * theta);

        if (Math.abs(denominator) < EPSILON) {

            throw new IllegalArgumentException("Angle results in undefined projectile motion (sin(2θ) = 0).");

        }

        return Math.sqrt(R * GRAVITY / denominator);

    }

    /**
     * Calculates the height of a projectile at a given horizontal distance.
     * 
     * <p>Formula: y = x × tan(θ) - (g × x²) / (2 × v² × cos²(θ))</p>
     * 
     * @param v Initial velocity in m/s
     * @param theta Launch angle in radians above horizontal
     * @param x Horizontal distance from launch point in meters
     * @return Height in meters above launch position (can be negative)
     * @throws IllegalArgumentException if cos(θ) ≈ 0 (θ ≈ π/2)
     */
    public static double heightAtDistance(double v, double theta, double x) {

        double linearTerm = Math.tan(theta) * x;
        double denominator = 2 * v * v * Math.pow(Math.cos(theta), 2);

        if (Math.abs(denominator) < EPSILON) {
            throw new IllegalArgumentException("Angle results in undefined projectile motion (sin(2θ) = 0).");
        }

        double quadraticTerm = (GRAVITY * x * x) / denominator;
        return linearTerm - quadraticTerm;

    }

    /**
     * Calculates the required flywheel RPM to achieve a given projectile range.
     * 
     * <p>Assumes projectile velocity equals flywheel tangential velocity (v = ω × r).
     * Real-world results may vary due to friction and energy losses.</p>
     * 
     * @param rBall Ball/projectile radius in meters
     * @param distance Desired horizontal distance in meters
     * @param theta Launch angle in radians above horizontal
     * @return Required flywheel RPM
     * @throws IllegalArgumentException if sin(2θ) = 0 (θ = 0 or π/2)
     */
    public static double findRequiredRPM(double rBall, double distance, double theta) {
        return (60 / (2 * Math.PI * rBall)) * Math.sqrt((distance * GRAVITY) / Math.sin(2*theta));
    }

}