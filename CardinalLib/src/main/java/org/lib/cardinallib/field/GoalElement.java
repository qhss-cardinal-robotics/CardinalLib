package org.lib.cardinallib.field;
import org.lib.cardinallib.math.Pose2d;

/**
 * Represents a goal or target element on the field.
 * 
 * <p>Goal elements are fixed-position targets that the robot may need to navigate
 * to or interact with. Unlike robot elements, goal elements have a fixed orientation
 * (always 0) since they represent stationary field features.</p>
 * 
 * <p>Examples of goal elements include scoring locations, alliance markers, or
 * other fixed field features.</p>
 * 
 * @see GameElement
 * @see RobotElement
 */
public class GoalElement extends GameElement {
    /** The goal's pose (position with fixed orientation of 0) */
    private Pose2d pose;

    /**
     * Creates a new GoalElement at the specified position.
     * 
     * <p>The orientation is always set to 0 for goal elements since they are
     * stationary field features.</p>
     * 
     * @param x X-coordinate of the goal on the field
     * @param y Y-coordinate of the goal on the field
     */
    public GoalElement (double x, double y) {
        super(x, y, 0);
        pose = new Pose2d(x, y, 0);
    }

    /**
     * Updates the goal's position.
     * 
     * <p>Note: The orientation parameter is ignored for goal elements, as they
     * always maintain an orientation of 0.</p>
     * 
     * @param x New X-coordinate
     * @param y New Y-coordinate
     * @param orientation Ignored (goal elements always have orientation 0)
     */
    @Override
    public void update(double x, double y, double orientation) {
        pose.set(x, y, 0);
        this.x = x;
        this.y = y;
        this.orientation = 0;
    }

    /**
     * Gets the goal's current pose.
     * 
     * @return A Pose2d representing the goal's position (orientation is always 0)
     */
    @Override
    public Pose2d getPose() {
        return pose;
    }

}
