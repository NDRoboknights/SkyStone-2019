package org.firstinspires.ftc.teamcode.team4348.Autonomous.red;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.HDrive;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;



import kotlin.Unit;
import kotlin.jvm.functions.Function0;


/**
 * This class is the red alliance autonomous. It consists of just the function runOpMode.
 * The @Autonomous tag is necessary to register it in the FTCRobotController app on the driver phone.
 * This will later be filled to make the robot complete autonomous function.
 * Your bot variable goes in this class to access hardware.
 */
@Autonomous(name="RedFoundMoveBuildSite")
public class RedAuto extends LinearOpMode
{
    /**
     * This is the function where all of your code should go for it to affect the bot during the autonomous phase.
     */

    private IdealBot bot = new IdealBot();
    public void runOpMode()
    {
        HDrive drive = new HDrive(hardwareMap);
        bot.init(hardwareMap);
        drive.setPoseEstimate(new Pose2d(40, -24, 0));
        waitForStart();
        drive.followTrajectorySync
                (drive.trajectoryBuilder()
                .addMarker(new Function0<Unit>()
                {
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
                                .splineTo(new Pose2d(0, -70, 0)).build()
                );
    }
}
