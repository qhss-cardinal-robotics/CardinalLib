package org.lib.cardinallib.math;

/**
 * Represents a 2D pose (position and orientation) on the field.
 * 
 * <p>A pose consists of:
 * <ul>
 *     <li>X-coordinate: horizontal position on the field</li>
 *     <li>Y-coordinate: vertical position on the field</li>
 *     <li>Heading: orientation angle in radians</li>
 * </ul>
 * </p>
 * 
 * <p>This class is commonly used to represent:
 * <ul>
 *     <li>Robot position and orientation for localization</li>
 *     <li>Target positions for path planning</li>
 *     <li>Waypoints in autonomous routines</li>
 *     <li>Field element positions</li>
 * </ul>
 * </p>
 * 
 * <p><b>Coordinate System:</b> The coordinate system follows standard FTC conventions:
 * <ul>
 *     <li>X-axis: typically increases from left to right (or west to east)</li>
 *     <li>Y-axis: typically increases from bottom to top (or south to north)</li>
 *     <li>Heading: measured in radians, typically 0 points along the positive X-axis,
 *         with positive rotation being counterclockwise</li>
 * </ul>
 * </p>
 * 
 * <p><b>Units:</b> The units for x, y, and heading should be consistent throughout
 * your application. Common choices are:
 * <ul>
 *     <li>Inches (common in FTC)</li>
 *     <li>Meters (SI units, useful for physics calculations)</li>
 *     <li>Field tiles (relative to field dimensions)</li>
 * </ul>
 * </p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * // Create a pose at (24, 36) inches with heading of 90 degrees (π/2 radians)
 * Pose2d robotPose = new Pose2d(24.0, 36.0, Math.PI / 2);
 * 
 * // Update the pose
 * robotPose.set(30.0, 40.0, Math.PI);
 * 
 * // Access individual components
 * double x = robotPose.x;
 * double y = robotPose.y;
 * double heading = robotPose.heading;
 * }</pre>
 * 
 * @see MathFormulas#AngleFormula(Pose2d, Pose2d)
 * @see MathFormulas#DistFormula(Pose2d, Pose2d)
 */
public class Pose2d {

    /**
     * The X-coordinate of the pose on the field.
     * 
     * <p>This represents the horizontal position. Units should be consistent
     * with your field coordinate system (e.g., inches or meters).</p>
     */
    public double x;

    /**
     * The Y-coordinate of the pose on the field.
     * 
     * <p>This represents the vertical position. Units should be consistent
     * with your field coordinate system (e.g., inches or meters).</p>
     */
    public double y;

    /**
     * The heading (orientation) of the pose in radians.
     * 
     * <p>The heading represents the direction the pose is facing. Typically:
     * <ul>
     *     <li>0 radians points along the positive X-axis</li>
     *     <li>π/2 radians (90°) points along the positive Y-axis</li>
     *     <li>π radians (180°) points along the negative X-axis</li>
     *     <li>-π/2 radians (-90°) points along the negative Y-axis</li>
     * </ul>
     * Positive rotation is typically counterclockwise.</p>
     * 
     * <p><b>Note:</b> The heading is stored in radians, not degrees. Use
     * {@link Math#toRadians(double)} to convert from degrees if needed.</p>
     */
    public double heading;

    /**
     * Creates a new Pose2d with the specified coordinates and heading.
     * 
     * @param x The X-coordinate on the field
     * @param y The Y-coordinate on the field
     * @param heading The heading (orientation) in radians
     */
    public Pose2d(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    /**
     * Updates this pose with new coordinates and heading.
     * 
     * <p>This method modifies the current pose in place rather than creating
     * a new instance. Useful for updating a pose that is being tracked over time.</p>
     * 
     * @param x The new X-coordinate
     * @param y The new Y-coordinate
     * @param heading The new heading in radians
     */
    public void set(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

}