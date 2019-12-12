package org.firstinspires.ftc.teamcode.team4348.utils;

public class distTraveled
{
    public static final int torquenado60 = 1440;
    public static final double neverestorbital20 = 537.6;
    public static final int revcorehex40 = 1120;
    public static final int externalEncoder = 600;

    public static double arcLengthTravel(double encoderTicks, double ticksTraveled, double wheelRadius)
    {
        return 2* Math.PI * wheelRadius * (ticksTraveled/encoderTicks);
    }
}
