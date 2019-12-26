package org.firstinspires.ftc.teamcode.team4348.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * This is an abstract class that forces requirements on descendant classes. Do not edit it.
 * The color threshold variable works for the Modern Robotics color sensor.
 */
public abstract class CustomAutonomous extends LinearOpMode
{
    //amount of color required to be sensed
    public static final int MR_COLOR_THRESHOLD = 1; //old mr color sensors. why are you using this?
    public static final int REV_COLOR_THRESHOLD = 25; // use this color sensor.
    public static final int TORQUENADO_60_TICKS = 1440;
    public static final int TORQUENADO_40_TICKS = 720;
    public static final int TORQUENADO_20_TICKS = 360;
    public static final int NEVEREST_ORBITAL_20_TICKS = 538;
    public static final int USDIGITAL_E4T_TICKS = 360; //ticks can vary but are printed in tiny text on the hubdisk
    public static final int USDIGITAL_E4P_TICKS = 360; //ticks can vary but are printed in tiny text on the hubdisk
    public static final int REV_CORE_HEX_TICKS = 288;
    public static final int REV_HD_HEX_20_TICKS = 560;
    public static final int REV_HED_HEX_40_TICKS = 1120;
    public static final int WHEEL_RADIUS_OMNI = 4; //in
}