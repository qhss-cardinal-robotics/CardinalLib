package org.lib.cardinallib.field;
import org.lib.cardinallib.math.Pose2d;

/**
 * Represents the robot as a game element on the field.
 * 
 * <p>This class tracks the robot's position and orientation, allowing it to be
 * treated as a game element for path planning, localization, and field awareness.</p>
 * 
 * <p>The robot's orientation can change, unlike goal elements which are fixed.</p>
 * 
 * @see GameElement
 * @see GoalElement
 */
public class RobotElement extends GameElement {
    /** The robot's current pose (position and orientation) */
    private Pose2d pose;

    /**
     * Creates a new RobotElement with the specified initial position and orientation.
     * 
     * @param x Initial X-coordinate on the field
     * @param y Initial Y-coordinate on the field
     * @param orientation Initial orientation in radians
     */
    public RobotElement(double x, double y, double orientation) {
        super(x, y, orientation);
        pose = new Pose2d(x, y, orientation);
    }

    /**
     * Updates the robot's position and orientation.
     * 
     * @param x New X-coordinate
     * @param y New Y-coordinate
     * @param orientation New orientation in radians
     */
    @Override
    public void update(double x, double y, double orientation) {
        pose.set(x, y, orientation);
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Gets the robot's current pose.
     * 
     * @return A Pose2d representing the robot's current position and orientation
     */
    @Override
    public Pose2d getPose() {
        return pose;
    }

}
