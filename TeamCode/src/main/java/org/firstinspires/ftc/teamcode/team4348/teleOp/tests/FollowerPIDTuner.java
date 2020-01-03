package org.firstinspires.ftc.teamcode.team4348.teleOp.tests;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDrive;

public class FollowerPIDTuner extends LinearOpMode
{
    public static double DISTANCE = 48;

    @Override
    public void runOpMode() throws InterruptedException
    {
        HDrive drive = new HDrive(hardwareMap, new Pose2d(0,0,0));

        drive.setPoseEstimate(new Pose2d(-DISTANCE / 2, -DISTANCE / 2, 0));

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested()) {
            drive.followTrajectorySync(
                    drive.trajectoryBuilder()
                            .forward(DISTANCE)
                            .build()
            );
            drive.turnSync(Math.toRadians(90));
        }
    }
}
