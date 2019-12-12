package org.firstinspires.ftc.teamcode.team4348.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.team4348.PID.ADAFruitIMU;

/**
 * This class contains all the variables corresponding to the hardware on the robot.
 * As of 8.21.19 this is reflective of last year's robot. Edit it according to yours.
 */
public class IdealBot extends org.firstinspires.ftc.teamcode.team4348.bot.Bot
{

    private HardwareMap hardware;

    /** BOT HARDWARE **/
    //motors
    public DcMotor lMotor;
    public DcMotor rMotor;
    public DcMotor slide;
    public DcMotor rLift;
    public DcMotor lLift;


    //dummy motors just used for encoders for odometry
    public DcMotor lMotorDummy;
    public DcMotor rMotorDummy;
    public DcMotor slideDummy;

    //sensors
    public ADAFruitIMU imu;
    public ColorSensor bottomSensor;

    //Servos
    public Servo rClamp;
    public Servo lClamp;

    //constructor
    public IdealBot()
    {
        //identifies the hardwaremap variable as the one defined in this class
        //sets it equal to the one given by the code in the teleop class
        //hmap
    }

    //initializing hardware
    public void init(HardwareMap hardwareMap)
    {
        this.hardware = hardwareMap;

        //motors, all set to use encoders
        rMotor = hardware.dcMotor.get("rMotor");
        rMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lMotor = hardware.dcMotor.get("lMotor");
        lMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide = hardware.dcMotor.get("slide");
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lLift = hardwareMap.dcMotor.get("lLift");
        lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rLift = hardwareMap.dcMotor.get("rLift");
        rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rClamp = hardware.servo.get("lClamp");
        lClamp = hardwareMap.servo.get("rClamp");

        bottomSensor = hardwareMap.colorSensor.get("cSensor");

    }
}