package org.lib.cardinallib.math;

/**
 * MathFormulas provides utility functions for calculating
 * geometric and physical relationships between positions.
 *
 * <p>Includes functions to calculate:</p>
 * <ul>
 *     <li>Angle between two positions</li>
 *     <li>Distance between two positions</li>
 * </ul>
 */
public class MathFormulas {

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
        double dy = bg.y - a.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

//    public static double PowerConversion() {}

}