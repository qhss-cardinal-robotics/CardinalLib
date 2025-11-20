package org.lib.cardinallib.math;

public class Pose2d {

    public double x;
    public double y;
    public double orientation;

    public Pose2d(double x, double y, double orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void set(double x, double y, double orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

}