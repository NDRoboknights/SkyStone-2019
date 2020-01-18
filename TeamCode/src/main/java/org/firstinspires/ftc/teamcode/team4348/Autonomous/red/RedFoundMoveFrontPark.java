package org.firstinspires.ftc.teamcode.team4348.Autonomous.red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDriveODO;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Autonomous(name="RedFoundFrontPark")
public class RedFoundMoveFrontPark extends LinearOpMode
{
    private IdealBot bot;

    @Override
    public void runOpMode()
    {
        HDriveODO hDrive = new HDriveODO(hardwareMap);
        bot = new IdealBot();
        bot.init(hardwareMap);
        hDrive.setPoseEstimate(new Pose2d(40, -52 ,0));
        waitForStart();
        hDrive.trajectoryBuilder()
                .forward(28)
                .addMarker(new Function0<Unit>() {
                    @Override
                    public Unit invoke()
                    {
                        bot.lFound.setPosition(0.3);
                        bot.rFound.setPosition(0.7);
                        return Unit.INSTANCE;
                    }
                })
                .splineTo(new Pose2d(40, -70, 0))
                .addMarker(new Function0<Unit>() {
                    @Override
                    public Unit invoke()
                    {
                        bot.lFound.setPosition(0);
                        bot.rFound.setPosition(0.9);
                        return Unit.INSTANCE;
                    }
                })
                .splineTo(new Pose2d(24, -52, 0))
                .splineTo(new Pose2d(24, -30,0 ))
                .splineTo(new Pose2d(0, -30, 0)).build().start();
    }
}
