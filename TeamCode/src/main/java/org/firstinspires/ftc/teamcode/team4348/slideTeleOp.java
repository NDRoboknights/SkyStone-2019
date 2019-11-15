package org.firstinspires.ftc.teamcode.team4348;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.bot.TestSlideBot;

/**
 * This is the teleOp class. This is where your bot variable will go to access hardware.
 * The init function is called first. It is mostly used to reset the bot from the autonomous phase.
 * You will also use gamepads to program input in the loop function.
 * The loop function is then called. Use of telemetry is highly recommended so you know what's happening with the bot.
 * If you would like samples, check FTCRobotController>src>main>java>...>external.samples
 * There you will find well documented sample pieces of code showing general form.
 */
@TeleOp(name="SlideTele")
public class slideTeleOp extends OpMode
{
    //IdealBot used as a container for all the bot hardware
    private TestSlideBot bot = new TestSlideBot();

    private static final double stickThresh = 0.125;
    /**
     * This is the init function. It is used to initialize the bot for the teleop phase.
     * Use it to move servos into position, etc.
     */
    @Override
    public void init()
    {
        bot.init(hardwareMap);
    }

    /**
     * This is the loop function. It is repeatedly called during the teleop phase.
     * Most of the robot's functionality comes from this function, and it should get full attention.
     */

    public void loop()
    {
        double lStick = -gamepad1.left_stick_y;
        double rStick = gamepad1.right_stick_x;

        if(Math.abs(rStick)>stickThresh)
        {
            bot.lMotor.setPower(lStick);
            bot.rMotor.setPower(-lStick);
        }else
            {
                bot.lMotor.setPower(0);
                bot.rMotor.setPower(0);
        }


        if(Math.abs(rStick)>stickThresh)
        {
            bot.slide.setPower(rStick);
        }else
            {
            bot.slide.setPower(0);
        }

        telemetry.addData("Nick Chung: ", true);
        telemetry.update();
    }
}


