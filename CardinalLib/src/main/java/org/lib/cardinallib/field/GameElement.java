package org.lib.cardinallib.field;
import org.lib.cardinallib.math.Pose2d;

/**
 * Abstract base class representing an element on the game field.
 * 
 * <p>Game elements can represent various objects on the field such as game pieces,
 * goals, or the robot itself. This class provides a common interface for tracking
 * position and orientation.</p>
 * 
 * @see RobotElement
 * @see GoalElement
 */
public abstract class GameElement {
    /** X-coordinate of the element on the field */
    protected double x;
    /** Y-coordinate of the element on the field */
    protected double y;
    /** Orientation of the element in radians */
    protected double orientation;

    /**
     * Creates a new GameElement with the specified position and orientation.
     * 
     * @param x X-coordinate on the field
     * @param y Y-coordinate on the field
     * @param orientation Orientation in radians
     */
    public GameElement(double x, double y, double orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Updates the element's position and orientation.
     * 
     * @param x New X-coordinate
     * @param y New Y-coordinate
     * @param orientation New orientation in radians
     */
    public abstract void update(double x, double y, double orientation);

    /**
     * Gets the current pose (position and orientation) of the element.
     * 
     * @return A Pose2d representing the element's current pose
     */
    public abstract Pose2d getPose();
}