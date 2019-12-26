package org.firstinspires.ftc.teamcode.team4348.utils;

import org.firstinspires.ftc.teamcode.team4348.PID.legacy.PIDFunctions;

/**
 * Created by sambl on 12/3/2017.
 */

/**
 * checks the cycles of the PID functions
 */
public class CycleChecker extends StatusChecker
{
    int extraCycles;
    PIDFunctions func;

    public CycleChecker(PIDFunctions func, int extraCycles)
    {
        this.func = func;
        this.extraCycles = extraCycles;
    }

    public boolean checkStatus(){return func.pidController.cycles < extraCycles;}
}