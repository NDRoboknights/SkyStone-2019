package org.firstinspires.ftc.teamcode.team11683.bot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.team11683.PID.legacy.ADAFruitIMU;
import org.firstinspires.ftc.teamcode.team11683.PID.legacy.REVHubIMU;
import org.jetbrains.annotations.NotNull;

/**
 * This class contains all the variables corresponding to the hardware on the robot.
 * As of 8.21.19 this is reflective of last year's robot. Edit it according to yours.
 */
public class IdealBot extends Bot
{

    /** BOT HARDWARE **/
    //motors
    public DcMotorEx lMotor;
    public DcMotorEx rMotor;
    public DcMotorEx lift;

    //dummy motors just used for encoders for odometry

    //sensors
    private BNO055IMU revimu;
    public REVHubIMU imu;
    public ADAFruitIMU imu2;


    //Servos
    public Servo clamp;
    //constructor
    public IdealBot()
    {
        //identifies the hardwaremap variable as the one defined in this class
        //sets it equal to the one given by the code in the teleop class
        //hmap
    }

    //initializing hardware
    public void init(@NotNull HardwareMap hardwareMap)
    {
        rMotor = hardwareMap.get(DcMotorEx.class, "rMotor");
        rMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        lMotor = hardwareMap.get(DcMotorEx.class, "lMotor");
        lMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        lMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        lMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        imu = new REVHubIMU(hardwareMap, "imu", revimu);
    }

    public void resetAllEnc()
    {
        rMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        lMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
}