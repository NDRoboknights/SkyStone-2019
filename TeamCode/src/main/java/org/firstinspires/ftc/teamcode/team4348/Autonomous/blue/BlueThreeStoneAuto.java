package org.firstinspires.ftc.teamcode.team4348.Autonomous.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.TrajectoryLoader;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDriveODO;

import java.io.File;

@Autonomous(name = "BlueThreeStone")
public class BlueThreeStoneAuto extends LinearOpMode
{

    @Override
    public void runOpMode() throws InterruptedException
    {
        HDriveODO driveODO= new HDriveODO(hardwareMap);
        driveODO.setPoseEstimate( new Pose2d(-28, 52, 0));

        waitForStart();

        driveODO.followTrajectorySync(TrajectoryLoader.load(new File("blue3stone.yaml")));

    }
}
