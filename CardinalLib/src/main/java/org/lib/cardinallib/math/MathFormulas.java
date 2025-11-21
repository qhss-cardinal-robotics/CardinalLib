package org.lib.cardinallib.math;

/**
 * MathFormulas provides utility functions for calculating
 * geometric and physical relationships between positions on the field.
 *
 * <p>Includes functions that calculate:</p>
 * <ul>
 *     <li>The angle between two positions (in radians)</li>
 *     <li>The distance between two positions (in meters)</li>
 *     <li>The distance traveled by a projectile using the range formula</li>
 *     <li>The initial velocity required for a projectile to travel a given distance</li>
 *     <li>The height of a projectile at a given horizontal distance</li>
 * </ul>
 */
public class MathFormulas {
    /** Gravitational constant (m/s^2) */
    private static final double GRAVITY = 9.81;
    /** Small tolerance used to avoid floating-point divide-by-zero errors */
    private static final double EPSILON = 1e-9;

    /**
     * Calculates the angle from the first position to the second position.
     * The returned angle is in radians.
     *
     * @param a The Pose2d representing the first position (e.g., the robot)
     * @param b  The Pose2d representing the second position (e.g., the goal)
     * @return The angle in radians from the first position to the second position
     */
    public static double AngleFormula(Pose2d a, Pose2d b) {

        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.atan2(dy, dx);

    }

    /**
     * Calculates the Euclidean distance between two positions.
     *
     * @param a The Pose2d representing the first position
     * @param b  The Pose2d representing the second position
     * @return The straight-line distance between the two positions (same units as Pose2d)
     */
    public static double DistFormula(Pose2d a, Pose2d b) {

        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx * dx + dy * dy);

    }

    /**
     * Calculates the distance traveled by a projectile given
     * that the projectile lands at the same height
     * @param v initial velocity (in meters/second) of projectile
     * @param theta angle (in radians) above the normal that the projectile is being launched at
     * @return distance (in meters) of the total distance the object traveled
     */
    public static double calculateRange(double v, double theta) {

        double vSquared = v * v;
        return vSquared * Math.sin(2 * theta) / GRAVITY;

    }

    /**
     * Calculates the initial velocity required for a projectile to
     * travel a given distance at a given angle
     * @param R distance (in meters) traveled by projectile
     * @param theta angle (in radians) above the normal that the projectile is being launched at
     * @return initial velocity (in meters/second) of projectile
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
     * @param v initial velocity in meters/second
     * @param theta launch angle in radians above the horizontal
     * @param x horizontal distance in meters
     * @return height in meters of the projectile above its initial position at distance x
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

//    public static double PowerConversion() {}

}