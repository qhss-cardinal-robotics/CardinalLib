package org.lib.cardinallib.field;
import org.lib.cardinallib.math.Pose2d;

public abstract class GameElement {
    protected double x;
    protected double y;
    protected double orientation;

    public GameElement(double x, double y, double orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public abstract void update(double x, double y, double orientation);
    public abstract Pose2d getPose();
}