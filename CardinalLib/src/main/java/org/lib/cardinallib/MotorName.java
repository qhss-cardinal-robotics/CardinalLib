package org.lib.cardinallib;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorName {

    private String privateName;

    public MotorName (String name) {
        privateName = name;
    }

    public void callName() {
        System.out.println(privateName);
    }

}
