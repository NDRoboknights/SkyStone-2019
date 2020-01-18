package org.firstinspires.ftc.teamcode.team11683.utils;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.team11683.Enums.Color;


/**
 * This class is a color sensing class designed to make getting the color of an object very easy.
 * It returns enums, and has relatively easy use, however will require tuning based on sensor used and the color looking to be sensed.
 */
public class GetColor
{

    private ColorSensor cSensor;

    public GetColor(ColorSensor colorSensor)
    {
        this.cSensor = colorSensor;
    }

    public int getRed(){return cSensor.red();}
    public int getBlue(){return cSensor.blue();}
    public int getGreen(){return cSensor.green();}

    public double[] argb()
    {
        double[] argb = new double[4];
        argb[0] = cSensor.alpha();
        argb[1] = getRed();
        argb[2] = getBlue();
        argb[3] = getGreen();
        return argb;
    }
    public static Color interpretColor(int r, int b)
    {
        if(r-b > 500)
        {
            return Color.RED;
        }else if( b-r > 500)
        {
            return Color.BLUE;
        }else{
            return Color.UNKNOWN;
        }

    }
}