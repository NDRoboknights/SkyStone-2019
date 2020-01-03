package org.firstinspires.ftc.teamcode.team4348.teleOp.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.GetColor;

@TeleOp(name="colorTele")
public class colorTest extends OpMode
{
    private IdealBot bot = new IdealBot();
    private GetColor gc;
    public void init()
    {
        bot.init(hardwareMap);
        gc = new GetColor(bot.bottomSensor);
    }
    public void loop(){telemetry.addData("cSensor R: ",gc.getRed()); telemetry.addData("cSensor B: ", gc.getBlue()); telemetry.update();}
}
