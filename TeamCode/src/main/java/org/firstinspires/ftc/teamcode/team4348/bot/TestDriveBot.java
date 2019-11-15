package org.firstinspires.ftc.teamcode.team4348.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.team4348.PID.ADAFruitIMU;

/**
 * This class contains all the variables corresponding to the hardware on the robot.
 * As of 8.21.19 this is reflective of last year's robot. Edit it according to yours.
 */
public class TestDriveBot extends Bot
{

    private HardwareMap hardware;

    /** BOT HARDWARE **/
    //motors
    public DcMotor lMotor;
    public DcMotor rMotor;
    public DcMotor slide;

    //sensors
    public ADAFruitIMU imu;
    public ColorSensor rSensor;
    public ColorSensor lSensor;

    //Servos

    //constructor
    public TestDriveBot()
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
        lMotor = hardware.dcMotor.get("lMotor");
        lMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}