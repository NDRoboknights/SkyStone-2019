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

    //color enum
    public Color rightColor;
    public Color leftColor;

    //gets color values
    public int getRightBlue(){return bot.rSensor.blue();}
    public int getRightRed(){return bot.rSensor.red();}
    public int getRightGreen(){return bot.rSensor.green();}
    public int getLeftRed(){return bot.lSensor.red();}
    public int getLeftBlue(){return bot.lSensor.blue();}
    public int getLeftGreen(){return bot.lSensor.green();}

    public Color rightColor()
    {
        if(getRightBlue() > 20 && getRightRed() > 50 && getRightGreen() > 50 && getRightRed()-getRightBlue()>15)
        {
            rightColor = Color.GOLD;
            return rightColor;
        }
        if (getLeftRed() > 80 && getLeftBlue() > 80 && getRightGreen() > 80)
        {
            leftColor = Color.WHITE;
            return rightColor;
        }else{
            rightColor = Color.UNKNOWN;
            return rightColor;
        }
    }

    public Color leftColor()
    {
        if (getLeftRed() > 80 && getLeftBlue() > 80 && getRightGreen() > 80) {
            leftColor = Color.WHITE;
            return leftColor;
        }
        if(getLeftBlue() > 20 && getLeftRed() > 50 && getLeftGreen() > 50 && getLeftRed()-getLeftBlue()>15)
        {
            leftColor = Color.GOLD;
            return leftColor;
        }else
        {
            leftColor = Color.UNKNOWN;
            return leftColor;
        }
    }
}