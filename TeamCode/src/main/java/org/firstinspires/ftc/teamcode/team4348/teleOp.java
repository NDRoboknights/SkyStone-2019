package org.firstinspires.ftc.teamcode.team4348;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.Utilities;

/**
 * This is the teleOp class. This is where your bot variable will go to access hardware.
 * The init function is called first. It is mostly used to reset the bot from the autonomous phase.
 * You will also use gamepads to program input in the loop function.
 * The loop function is then called. Use of telemetry is highly recommended so you know what's happening with the bot.
 * If you would like samples, check FTCRobotController>src>main>java>...>external.samples
 * There you will find well documented sample pieces of code showing general form.
 */
@TeleOp(name="TeleOp")
public class teleOp extends OpMode
{
    //IdealBot used as a container for all the bot hardware
    private IdealBot bot = new IdealBot();

    private static final double stickThresh = 0.125;
    /**
     * This is the init function. It is used to initialize the bot for the teleop phase.
     * Use it to move servos into position, etc.
     */
    @Override
    public void init()
    {
        bot.init(hardwareMap);
        bot.clamp.setPosition(0.4);
    }

    /**
     * This is the loop function. It is repeatedly called during the teleop phase.
     * Most of the robot's functionality comes from this function, and it should get full attention.
     */

    public void loop()
    {
        double lStick = -gamepad1.left_stick_y;
        double rStick = gamepad1.right_stick_y;

        if(Math.abs(lStick)>stickThresh)
        {
            bot.lMotor.setPower(lStick);
        }else
            {
                bot.lMotor.setPower(0);
        }


        if(Math.abs(rStick)>stickThresh)
        {
            bot.rMotor.setPower(rStick);
        }else
            {
            bot.rMotor.setPower(0);
        }

        if(gamepad1.left_trigger > stickThresh)
        {
            bot.lExtend.setPower(Utilities.scalePower(gamepad1.left_trigger)[0]);
            bot.rExtend.setPower(Utilities.scalePower(gamepad1.left_trigger)[1]);
        }else
            {
            bot.lExtend.setPower(0);
            bot.rExtend.setPower(0);
        }

        if(gamepad1.right_trigger > stickThresh)
        {
            bot.lExtend.setPower(-Utilities.scalePower(gamepad1.right_trigger)[0]);
            bot.rExtend.setPower(-Utilities.scalePower(gamepad1.right_trigger)[1]);
            bot.rExtend.setPower(0);
            bot.lExtend.setPower(0);
        }

        if(gamepad1.dpad_up)
        {
            bot.lift.setPower(1);
        }else{
            bot.lift.setPower(0);
        }

        if(gamepad1.dpad_down){
            bot.lift.setPower(-1);
        }else{
            bot.lift.setPower(0);
        }

        if(gamepad1.x)
        {
            bot.clamp.setPosition(0.4);
        }

        if(gamepad1.b)
        {
            bot.clamp.setPosition(0.7);
        }
    }
}


