package org.firstinspires.ftc.teamcode.team4348.PID;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.firstinspires.ftc.teamcode.team4348.Autonomous.CustomAutonomous;
import org.firstinspires.ftc.teamcode.team4348.Enums.Direction;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.firstinspires.ftc.teamcode.team4348.utils.CycleChecker;

import java.util.concurrent.TimeUnit;

@Disabled
@TeleOp(name="Calibration: PIDCalibration",group="Calibration")
public class PIDCalibration extends CustomAutonomous
{
    IdealBot bot = new IdealBot(hardwareMap);
    ADAFruitIMU imu = bot.imu;
    PIDController pidController;
    final double THRESHOLD = 0.5;
    final double DELTA_VAL = 0.001;

    @Override
    public void runOpMode() throws InterruptedException
    {
        bot.init(hardwareMap);
        imu = new ADAFruitIMU(hardwareMap, "imu");
        double p = 0.025;
        double i = 0.000;
        double d = 0.000;

        pidController = new PIDController(imu, new PIDCoefficients(p,i,d));
        PIDFunctions pidFunctions = new PIDFunctions(bot, pidController);
        CycleChecker cChecker = new CycleChecker(pidFunctions, PIDController.D_EXTRACYCLES);
        waitForStart();

        boolean prevA = false;

        while(opModeIsActive())
        {
            TimeUnit.MILLISECONDS.sleep(100);
            double leftStick = -gamepad1.left_stick_y;
            boolean a = gamepad1.a, x = gamepad1.x, b = gamepad1.b, y = gamepad1.y;

            //if press A, but not continuous, turn left 90 degrees
            if(a && !prevA)
            {
                pidController.setPidc(p, i, d);
                pidFunctions.turn(Direction.LEFT, 90, cChecker);
            }

            //while holding x, increment P by DELTA_VAL
            if(x && Math.abs(leftStick) > THRESHOLD)
            {
                if(leftStick < 0) {
                    p -= DELTA_VAL;
                }
                else {
                    p += DELTA_VAL;
                }
            }

            //while holding b, increase D by DELTA_VAL
            if(b && Math.abs(leftStick) > THRESHOLD)
            {
                if(leftStick < 0) {
                    d -= DELTA_VAL;
                }
                else {
                    d += DELTA_VAL;
                }
            }

            //while holding y, increase I by DELTA_VAL
            if(y && Math.abs(leftStick) > THRESHOLD)
            {
                if(leftStick < 0)
                {
                    i -= DELTA_VAL;
                }
                else
                {
                    i += DELTA_VAL;
                }
            }
            prevA = a;

//            telemetry.addData("IMU: ", bot.imu.getValue());
            telemetry.addData("P: ", p);
            telemetry.addData("I: ", i);
            telemetry.addData("D: ", d);
            telemetry.update();
        }
    }
}