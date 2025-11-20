package org.lib.cardinallib.math;

public class AngleFormula {
    private Pose2d robot;
    private Pose2d goal;

    public AngleFormula (Pose2d robot, Pose2d goal) {
        this.robot = robot;
        this.goal = goal;
    }

    public double getAngle() {
        double dx = robot.x-goal.x;
        double dy = robot.y-goal.y;
        return Math.atan2(dy/dx); // angle in radians
    }
}