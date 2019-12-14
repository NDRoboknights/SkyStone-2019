package org.firstinspires.ftc.teamcode.team4348;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.getColor;

@TeleOp(name="colorTele")
public class colorTest extends OpMode
{
    private IdealBot bot = new IdealBot();
    private getColor gc;
    public void init()
    {
        bot.init(hardwareMap);
        gc = new getColor(bot.bottomSensor);
    }
    public void loop(){telemetry.addData("cSensor: ",gc.argb().toString()); telemetry.update();}
}
