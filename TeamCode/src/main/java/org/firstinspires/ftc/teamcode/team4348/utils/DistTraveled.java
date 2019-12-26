package org.firstinspires.ftc.teamcode.team4348.utils;

public class DistTraveled
{
    public static double arcLengthTravel(double deltaEncoderTicks, double ticksTraveled, double wheelRadius)
    {
        return 2* Math.PI * wheelRadius * (ticksTraveled/deltaEncoderTicks);
    }
}
