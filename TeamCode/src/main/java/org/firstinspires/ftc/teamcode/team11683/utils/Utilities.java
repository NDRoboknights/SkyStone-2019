package org.firstinspires.ftc.teamcode.team11683.utils;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Useful functions including <code>delay(...)</code> and <code>scalePower(...)</code>
 */

public class Utilities
{
    final static Object monitor = new Object();
    /**
     * Waits untils <code>sChecker.checkStatus()</code> returns false.
     * @param sChecker Status Checker
     */
    public static void delay(StatusChecker sChecker)
    {
        synchronized (monitor) {
            while (sChecker.checkStatus()) {
                try {
                    monitor.wait(1);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }

    /**
     * Calls <code>wait(time)</code> on an initialized Object
     * @param time Time to wait
     */
    public static void delay(long time)
    {
        synchronized (monitor) {
            try {
                monitor.wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * If any power is over by the MAX (1.0), will divide through by the max power. Else, returns original
     * powers.
     * @param doubles All powers to scale with each other
     * @return An array of the new powers corresponding in order with original powers
     */
    public static double[] scalePower(double... doubles)
    {
        //find max
        double max = Math.abs(doubles[0]);
        for(Double d : doubles)
        {
            if(Math.abs(d) > max) {
                max = d;
            }
        }

        if(max <= 1.0) return doubles;

        //scale everything to max
        for(int x=0; x<doubles.length; x++)
        {
            doubles[x] /= max;
        }

        return doubles;
    }

    /**
     * For every motor in <code>motors</code>, stops and resets encoder values
     * @param motors motors to reset encoder values
     */
    public static void resetEncoderValues(DcMotor... motors)
    {
        for(DcMotor m : motors)
        {
            m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

}