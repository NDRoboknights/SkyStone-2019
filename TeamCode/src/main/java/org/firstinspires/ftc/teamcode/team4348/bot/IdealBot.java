package org.firstinspires.ftc.teamcode.team4348.bot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.team4348.PID.legacy.ADAFruitIMU;
import org.firstinspires.ftc.teamcode.team4348.PID.legacy.REVHubIMU;
import org.jetbrains.annotations.NotNull;

/**
 * This class contains all the variables corresponding to the hardware on the robot.
 * As of 8.21.19 this is reflective of last year's robot. Edit it according to yours.
 */
public class IdealBot extends org.firstinspires.ftc.teamcode.team4348.bot.Bot
{

    /** BOT HARDWARE **/
    //motors
    public DcMotorEx lMotor;
    public DcMotorEx rMotor;
    public DcMotorEx slide;
    public DcMotorEx rLift;
    public DcMotorEx lLift;


    //dummy motors just used for encoders for odometry
    public DcMotor lMotorDummy;
    public DcMotor rMotorDummy;
    public DcMotor slideDummy;

    //sensors
    private BNO055IMU revimu;
    public REVHubIMU imu;
    public ADAFruitIMU imu2;
    public ColorSensor bottomSensor;


    //Servos
    public Servo lClamp;
    public Servo lFound;
    public Servo rFound;
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

        slide = hardwareMap.get(DcMotorEx.class, "slide");
        slide.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        slide.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        lLift = hardwareMap.get(DcMotorEx.class, "lLift");
        lLift.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        rLift = hardwareMap.get(DcMotorEx.class, "rLift");
        rLift.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        lClamp = hardwareMap.servo.get("lClamp");
        lFound = hardwareMap.servo.get("lFound");
        rFound = hardwareMap.servo.get("rFound");

        lMotorDummy = hardwareMap.dcMotor.get("lOdo");
        rMotorDummy = hardwareMap.dcMotor.get("rOdo");
        slideDummy = hardwareMap.dcMotor.get("sOdo");


        bottomSensor = hardwareMap.colorSensor.get("cSensor");
        imu = new REVHubIMU(hardwareMap, "imu", revimu);
    }

    public void resetAllEnc()
    {
        rLift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        lLift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        rMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        lMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        slide.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        rMotorDummy.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lMotorDummy.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideDummy.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}