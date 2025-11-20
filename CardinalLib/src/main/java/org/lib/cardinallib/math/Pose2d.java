package org.lib.cardinallib.math;

/**
 * Pose2d represents a 2D position and orientation on the field.
 *
 * <p>Includes:</p>
 * <ul>
 *     <li>X-coordinate</li>
 *     <li>Y-coordinate</li>
 *     <li>Heading (orientation) in radians</li>
 * </ul>
 *
 * <p>Units for x and y should be consistent with your field dimensions (e.g., inches or meters).</p>
 */
public class Pose2d {

    /** X-coordinate on the field*/
    public double x;
    /** Y-coordinate on the field*/
    public double y;
    /** Heading (orientation) in radians */
    public double heading;

    /**
     * Creates a Pose2d with the specified coordinates and heading.
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param heading Heading in radians
     */
    public Pose2d(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    /**
     * Update this Pose2d with the specified coordinate and heading
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param heading Heading in radians
     */
    public void set(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

}