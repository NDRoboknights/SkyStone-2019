package org.firstinspires.ftc.teamcode.team4348.Autonomous.red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.TrajectoryLoader;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDriveODO;

import java.io.File;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Autonomous(name = "red2stone")
public class RedThreeStoneAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException
    {
        HDriveODO driveODO = new HDriveODO(hardwareMap);
        driveODO.setPoseEstimate(new Pose2d(-28, -52, 0));
        waitForStart();
        driveODO.followTrajectorySync(driveODO.trajectoryBuilder().forward(26).addMarker(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                driveODO.bot.lClamp.setPosition(0.7);
                return Unit.INSTANCE;
            }
        }).forward(-6).strafeLeft(30)
                .addMarker(new Function0<Unit>()
                {
                    @Override
                    public Unit invoke() {
                        driveODO.bot.lClamp.setPosition(0.2);
                        return Unit.INSTANCE;
                    }
                }).strafeRight(-54).forward(6).addMarker(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                driveODO.bot.lClamp.setPosition(0.8);
                return Unit.INSTANCE;
            }
        }).forward(-6).strafeLeft(54).addMarker(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                driveODO.bot.lClamp.setPosition(0.2);
                return Unit.INSTANCE;
            }

        }).build());
    }
}
