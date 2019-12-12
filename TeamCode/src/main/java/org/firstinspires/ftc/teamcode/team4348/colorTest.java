package org.firstinspires.ftc.teamcode.team4348;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;

@TeleOp(name="colorTele")
public class colorTest extends OpMode
{
    private IdealBot bot = new IdealBot();
    public void init(){bot.init(hardwareMap);}
    public void loop(){telemetry.addData("cSensor: ", bot.bottomSensor.argb()); telemetry.update();}
}
