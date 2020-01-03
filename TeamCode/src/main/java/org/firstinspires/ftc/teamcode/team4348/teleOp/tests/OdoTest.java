package org.firstinspires.ftc.teamcode.team4348.teleOp.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;

@TeleOp(name = "OdoTest", group = "testing")
public class OdoTest extends OpMode
{
    IdealBot bot = new IdealBot();
    public void init()
    {
        bot.init(hardwareMap);
        bot.resetAllEnc();
    }
    public void loop()
    {
        telemetry.addData("lOdo: ", bot.lMotorDummy.getCurrentPosition());
        telemetry.addData("rOdo: ", bot.rMotorDummy.getCurrentPosition());
        telemetry.addData("sOdo: ", bot.slideDummy.getCurrentPosition());
        telemetry.update();
    }
}
