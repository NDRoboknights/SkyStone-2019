package org.firstinspires.ftc.teamcode.team4348.bot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

import static org.firstinspires.ftc.teamcode.team4348.utils.Utilities.delay;

/**
 * This abstract class is to be used for inheritance for the new bot classes to store hardware variables.
 * Do not edit it.
 */
public abstract class Bot
{

   //dcmotor lists (for keeping track and fullstop();)
   public ArrayList<DcMotor> leftMotors = new ArrayList<>();
   public ArrayList<DcMotor> rightMotors = new ArrayList<>();
   public ArrayList<DcMotor> otherMotors = new ArrayList<>();

   //motor max speed
   public double MAX_SPEED = 1.0;

   //abstract init (required for all child classes)
   public abstract void init(HardwareMap hardwareMap);

   //sets drive power for duration
   // sets power individually left and right
   //could be used for turning purposes?
   //if so would be less accurate than pid
   public void setDrivePowerTimed(double leftPower, double rightPower, long time)
   {
       setDrivePower(leftPower, rightPower);
       delay(time);
       setDrivePower(0,0);
   }
    //sets drive power indefinitely until fullstop();
    public void setDrivePower(double lPower, double rPower)
    {
        for(DcMotor m : leftMotors)
        {
            m.setPower(lPower);
        }
        for(DcMotor m : rightMotors)
        {
            m.setPower(rPower);
        }
    }
    //stops all motors
    public void fullStop()
    {
        for(DcMotor m : leftMotors)
        {
            m.setPower(0);
        }
        for(DcMotor m : rightMotors)
        {
            m.setPower(0);
        }
        for(DcMotor m : otherMotors)
        {
            m.setPower(0);
        }
    }
}