package org.firstinspires.ftc.teamcode.team4348.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.team4348.Enums.Color;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.GetColor;


/**
 * This class is the red alliance autonomous. It consists of just the function runOpMode.
 * The @Autonomous tag is necessary to register it in the FTCRobotController app on the driver phone.
 * This will later be filled to make the robot complete autonomous function.
 * Your bot variable goes in this class to access hardware.
 */
@Autonomous(name="RedAuto")
public class RedAuto extends LinearOpMode
{
    /**
     * This is the function where all of your code should go for it to affect the bot during the autonomous phase.
     */
    private IdealBot bot = new IdealBot();

    public void runOpMode()
    {
        bot.init(hardwareMap);
        waitForStart();
        while(GetColor.interpretColor(bot.bottomSensor.red(), bot.bottomSensor.blue()) != Color.RED)
        {
            bot.slide.setPower(-0.5);
        }
        bot.slide.setPower(0);
    }
}
