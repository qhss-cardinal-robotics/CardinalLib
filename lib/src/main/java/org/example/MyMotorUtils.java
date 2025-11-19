package org.example;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class MyMotorUtils {

    // Set motor power
    public static void setMotorPower(DcMotor motor, double power) {
        motor.setPower(power);
    }

    // Stop a motor
    public static void stopMotor(DcMotor motor) {
        motor.setPower(0);
    }

    // Move a servo to a specific position
    public static void setServoPosition(Servo servo, double position) {
        servo.setPosition(position);
    }
}
