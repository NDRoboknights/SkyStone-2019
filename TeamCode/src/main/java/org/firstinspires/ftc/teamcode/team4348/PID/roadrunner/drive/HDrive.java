package org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.drive.DriveSignal;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.localization.Localizer;
import com.acmerobotics.roadrunner.localization.ThreeTrackingWheelLocalizer;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


import org.firstinspires.ftc.teamcode.team4348.Autonomous.CustomAutonomous;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive.DriveConstants.getMotorVelocityF;


public class HDrive extends HDriveBase
{
    public IdealBot bot = new IdealBot();
    private HDriveLocalizer localizer;

    @NotNull
    @Override
    public Localizer getLocalizer()
    {
        return this.localizer;
    }

    @Override
    public void setLocalizer(@NotNull Localizer localizer)
    {
        this.localizer = (HDriveLocalizer) localizer;
    }

    @Override
    protected double getRawExternalHeading()
    {
        return Math.toRadians(bot.imu.getZAxisValue());
    }

    @Deprecated
    /*
      does nothing. resolves errors.
     */
    public void setMotorPowers(double v, double v1, double v2, double v3) {

    }

    public class HDriveLocalizer extends ThreeTrackingWheelLocalizer implements Localizer
    {

        HDriveLocalizer(Pose2d pose2d)
        {
            super(Arrays.asList(new Pose2d(0,7,0), new Pose2d(0, -7, 0), new Pose2d( 13.5, 0, Math.toRadians(90))));

            ThreeTrackingWheelLocalizer localizer = new ThreeTrackingWheelLocalizer(Arrays.asList(pose2d)) {
                @NotNull
                @Override
                public List<Double> getWheelPositions() {
                    return Arrays.asList(encoderTicksToInches(bot.lMotorDummy.getCurrentPosition()), encoderTicksToInches(bot.rMotorDummy.getCurrentPosition()*-1), encoderTicksToInches(bot.slideDummy.getCurrentPosition()));

                }
            };
        }


        @NotNull
        @Override
        public Pose2d getPoseEstimate() {
            return localizer.getPoseEstimate();
        }

        @Override
        public void setPoseEstimate(@NotNull Pose2d pose2d)
        {
            localizer.setPoseEstimate(pose2d);
        }

        @Override
        public void update()
        {
            localizer.update();
        }

        double encoderTicksToInches(int ticks)
        {
            return 4 * 2 * Math.PI * 1 * ticks / CustomAutonomous.USDIGITAL_E4T_TICKS;
        }

        @NotNull
        @Override
        public List<Double> getWheelPositions() {
            return Arrays.asList(encoderTicksToInches(bot.lMotorDummy.getCurrentPosition()), encoderTicksToInches(bot.rMotorDummy.getCurrentPosition()*-1), encoderTicksToInches(bot.slideDummy.getCurrentPosition()));
        }
    }
    @Override
    public void setDrivePower(Pose2d pose2d)
    {
        Pose2d xPos = new Pose2d(pose2d.getX(), 0, pose2d.getHeading());
        Pose2d yPos = new Pose2d(0, pose2d.getY(), 0);

        List<Double> xPow = TankKinematics.robotToWheelVelocities(xPos, 14);
        List<Double> yPow = TankKinematics.robotToWheelAccelerations(yPos, 14);

        bot.lMotor.setPower(xPow.get(0));
        bot.rMotor.setPower(xPow.get(1));
        bot.slide.setPower(yPow.get(0));
    }

    @Override
    public void setDriveSignal(DriveSignal driveSignal)
    {
        setDrivePower(driveSignal.getVel());
    }

    public HDrive(@NotNull HardwareMap hardwareMap, @NotNull Pose2d startPose)
    {
        super();
        bot.init(hardwareMap);
        localizer = new HDriveLocalizer(startPose);
        setLocalizer(localizer);
    }

    public PIDCoefficients getPIDCoefficients(DcMotor.RunMode runMode)
    {
        PIDFCoefficients coefficients = bot.lMotor.getPIDFCoefficients(runMode);
        return new PIDCoefficients(coefficients.p, coefficients.i, coefficients.d);
    }

    public void setPIDCoefficients(DcMotor.RunMode runMode, PIDCoefficients coefficients) {
        bot.lMotor.setPIDFCoefficients(runMode, new PIDFCoefficients(
                coefficients.kP, coefficients.kI, coefficients.kD, getMotorVelocityF()
        ));
        bot.rMotor.setPIDFCoefficients(runMode, new PIDFCoefficients(
                coefficients.kP, coefficients.kI, coefficients.kD, getMotorVelocityF()
        ));
        bot.slide.setPIDFCoefficients(runMode, new PIDFCoefficients(
                coefficients.kP, coefficients.kI, coefficients.kD, getMotorVelocityF()
        ));
    }

    @NotNull
    public List<Double> getWheelPositions(){ return localizer.getWheelPositions();}
}
