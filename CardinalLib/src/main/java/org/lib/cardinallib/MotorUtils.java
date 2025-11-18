package org.lib.cardinallib;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorUtils {

    /**
     * Stop all motors in the array immediately
     */
    public static void stopAll(DcMotor... motors) {
        for (DcMotor motor : motors) {
            if (motor != null) {
                motor.setPower(0);
            }
        }
    }

}
