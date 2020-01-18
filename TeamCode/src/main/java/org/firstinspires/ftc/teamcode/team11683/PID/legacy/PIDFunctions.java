package org.firstinspires.ftc.teamcode.team11683.PID.legacy;

import org.firstinspires.ftc.teamcode.team11683.Enums.Direction;
import org.firstinspires.ftc.teamcode.team11683.bot.Bot;
import org.firstinspires.ftc.teamcode.team11683.utils.StatusChecker;

import static org.firstinspires.ftc.teamcode.team4348.utils.Utilities.scalePower;


public class PIDFunctions {
    Bot bot;
    public PIDController pidController;

    public PIDFunctions(Bot bot, PIDController pidController) {
        this.bot = bot;
        this.pidController = pidController;
    }

    /**
     * Go directly straight until <code>statusChecker.checkStatus()</code> returns false
     *
     * @param power         Power to go straight
     * @param statusChecker
     */
    public void straight(double power, StatusChecker statusChecker) {
        pidController.setTarget(pidController.getValue());
        pidController.start();
        while (statusChecker.checkStatus()) {
            //find direction
            double raw = pidController.getError();

            double left = 1;
            double right = 1;

            if (raw > 0) {
                right = -1;
            } else if (raw < 0) {
                left = -1;
            }

            //set power
            double lPower = power + left * Math.abs(pidController.getOutput());
            double rPower = power + right * Math.abs(pidController.getOutput());

            //scale to make sure not over 1.0 max
            double[] powers = scalePower(lPower, rPower);

            bot.setDrivePower(powers[0], powers[1]);
        }
        bot.setDrivePower(0, 0);
        pidController.stop();
    }

    /**
     * @param angle         The angle to go to, whether turning left or right
     * @param statusChecker Used as a timeout
     */
    public void goToAngle(double angle, StatusChecker statusChecker) {
        pidController.setTarget(angle);
        pidController.start();
        while (statusChecker.checkStatus()) {
            //find direction
            double raw = pidController.getError();

            double left = 1;
            double right = 1;

            if (raw > 0) {
                right = -1;
            } else if (raw < 0) {
                left = -1;
            }

            //set power
            double lPower = left * Math.abs(pidController.getOutput());
            double rPower = right * Math.abs(pidController.getOutput());

            //scale to make sure not over 1.0 max
            double[] powers = scalePower(lPower, rPower);

            bot.setDrivePower(powers[0], powers[1]);
        }
        bot.setDrivePower(0, 0);
        pidController.stop();
    }

    /**
     * @param dir      The direction to turn (LEFT or RIGHT)
     * @param angle    The angle to turn to
     * @param sChecker Used as a timeout
     */
    public void turn(Direction dir, double angle, StatusChecker sChecker) {
        pidController.setTarget(pidController.pidInput.normalizeValue(pidController.pidInput.getValue() + dir.v * angle));
        pidController.start();
        while (sChecker.checkStatus()) {
            double lPower = -dir.v * pidController.getOutput();
            double rPower = dir.v * pidController.getOutput();

            double[] powers = scalePower(lPower, rPower);
            bot.setDrivePower(powers[0], powers[1]);
        }
        bot.setDrivePower(0, 0);
        pidController.stop();
    }

    /**
     * The straight thread used to go straight while also doing other things.
     */
    public static class PIDStraightThread {
        PIDFunctions func;
        public Thread thread;
        boolean isRunning = false;
        double power;

        public PIDStraightThread(PIDFunctions func, double power) {
            this.func = func;
            thread = new Thread(new PIDStraightRunnable());
            this.power = power;
        }

        class PIDStraightRunnable implements Runnable {
            RunningChecker rChecker = new RunningChecker();

            @Override
            public void run() {
                func.straight(power, rChecker);
            }
        }

        public void setRunning(boolean nValue) {
            isRunning = nValue;
        }

        class RunningChecker extends StatusChecker {
            @Override
            public boolean checkStatus() {
                return isRunning;
            }
        }
    }
}