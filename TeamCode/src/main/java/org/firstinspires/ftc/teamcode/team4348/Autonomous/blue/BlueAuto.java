package org.firstinspires.ftc.teamcode.team4348.Autonomous.blue;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.Enums.Color;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.Utilities;
import org.firstinspires.ftc.teamcode.team4348.utils.GetColor;

/**
 * This class is the blue alliance autonomous. It consists of just the function runOpMode.
 * The @Autonomous tag is necessary to register it in the FTCRobotController app on the driver phone.
 * This will later be filled to make the robot complete autonomous function.
 * Your bot variable goes in this class to access hardware.
 */
@Autonomous(name="BlueAuto")
public class BlueAuto extends LinearOpMode
{
    private IdealBot bot = new IdealBot();


    /**
     * This is the function where all of your code should go for it to affect the bot during the autonomous phase.
     */



    public void runOpMode()
    {
        bot.init(hardwareMap);
        waitForStart();
        bot.lMotor.setPower(1);
        bot.rMotor.setPower(-1);
        Utilities.delay(1000);
        bot.lMotor.setPower(0);
        bot.rMotor.setPower(0);
    }
}
