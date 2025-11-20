package org.lib.cardinallib.utils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Mechanism {

    protected LinearOpMode opMode;

    public abstract void init(HardwareMap hwMap);

    public void loop(Gamepad gamepad) { }

    public void loop(Gamepad gamepad1, Gamepad gamepad2) { }

    public void telemetry(Telemetry telemetry) { }

}
