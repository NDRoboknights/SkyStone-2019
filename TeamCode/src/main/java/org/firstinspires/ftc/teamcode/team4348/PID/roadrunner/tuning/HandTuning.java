package org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.tuning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDriveODO;

@TeleOp(name = "Hand Odo tuning")
public class HandTuning extends OpMode
{
    private HDriveODO drive;
    @Override
    public void init()
    {
        drive = new HDriveODO(hardwareMap);
    }

    @Override
    public void loop()
    {
        drive.update();

        telemetry.addData("pose est: ", drive.getLocalizer().getPoseEstimate());
        telemetry.addData("x: ", drive.getLocalizer().getPoseEstimate().getX());
        telemetry.addData("y: ", drive.getLocalizer().getPoseEstimate().getY());
    }
}
