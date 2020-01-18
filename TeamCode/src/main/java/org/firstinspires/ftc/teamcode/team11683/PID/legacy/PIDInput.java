package org.firstinspires.ftc.teamcode.team11683.PID.legacy;

/**
 * Created by sambl on 12/8/2017.
 */
public abstract class PIDInput
{
    public abstract double getValue();
    public abstract double normalizeValue(double value);
    public abstract double normalizeError(double error);
}
