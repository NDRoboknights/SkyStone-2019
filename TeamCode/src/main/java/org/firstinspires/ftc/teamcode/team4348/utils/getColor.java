package org.firstinspires.ftc.teamcode.team4348.utils;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.team4348.Enums.Color;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;

/**
 * This class is a color sensing class designed to make getting the color of an object very easy.
 * It returns enums, and has relatively easy use, however will require tuning based on sensor used and the color looking to be sensed.
 */
public class getColor
{
    //bot instantiator
    public IdealBot bot;

    public getColor(HardwareMap hardwareMap)
    {
        bot = new IdealBot();
        bot.init(hardwareMap);
    }

    public int getRed(){return bot.bottomSensor.red();}
    public int getBlue(){return bot.bottomSensor.blue();}
    public int getGreen(){return bot.bottomSensor.green();}

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