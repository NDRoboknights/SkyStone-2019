package org.firstinspires.ftc.teamcode.team4348.PID.roadrunner;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import static org.firstinspires.ftc.teamcode.team4348.utils.Utilities.delay;

@TeleOp(name = "rrtest", group = "testing")
public class RRTest extends OpMode
{
    private double kp = 0;
    private double ki = 0;
    private double kd = 0;

    private IdealBot bot = new IdealBot();
    public void init(){bot.init(hardwareMap);}

    private PIDFController controller = new PIDFController(new PIDCoefficients(kp, ki, kd));

    public void loop()
    {
        if(gamepad1.x){ kp += 1; delay(100);}
        if(gamepad1.y){ ki += 1; delay(100);}
        if(gamepad1.b){ kd += 1; delay(100);}
        if(gamepad1.a){ controller.setTargetPosition(90); delay(1000); }

        telemetry.addData("imu x: ", bot.imu.getXAxisValue());
        telemetry.addData("imu y: ", bot.imu.getYAxisValue());
        telemetry.addData("imu z: ", bot.imu.getZAxisValue());
        telemetry.update();
    }
}
