package org.firstinspires.ftc.teamcode.team4348.PID.roadrunner.drive;

import com.acmerobotics.roadrunner.drive.Drive;
import com.acmerobotics.roadrunner.drive.DriveSignal;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.localization.Localizer;
import com.acmerobotics.roadrunner.localization.ThreeTrackingWheelLocalizer;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.team4348.Autonomous.CustomAutonomous;
import org.firstinspires.ftc.teamcode.team4348.bot.IdealBot;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


public class HDrive extends Drive
{
    private IdealBot bot = new IdealBot();
    private Localizer localizer = new HDriveLocalizer();

    @Override
    public Localizer getLocalizer()
    {
        return this.localizer;
    }

    @Override
    public void setLocalizer(Localizer localizer)
    {
        this.localizer = localizer;
    }

    @Override
    protected double getRawExternalHeading()
    {
        return Math.toRadians(bot.imu.getZAxisValue());
    }

    class HDriveLocalizer extends ThreeTrackingWheelLocalizer
    {
        ThreeTrackingWheelLocalizer localizer;

        HDriveLocalizer()
        {
            super(Arrays.asList(new Pose2d(0,7,0), new Pose2d(0, -7, 0), new Pose2d( 13.5, 0, Math.toRadians(90))));
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
            return Arrays.asList(encoderTicksToInches(bot.lMotorDummy.getCurrentPosition()), encoderTicksToInches(bot.rMotorDummy.getCurrentPosition()), encoderTicksToInches(bot.slideDummy.getCurrentPosition()));
        }
    }
    @Override
    public void setDrivePower(Pose2d pose2d)
    {
        Pose2d xPos = new Pose2d(pose2d.getX(), 0, pose2d.getHeading());
        Pose2d yPos = new Pose2d(0, pose2d.getY(), pose2d.getHeading());

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

    public HDrive(HardwareMap hardwareMap)
    {
        bot.init(hardwareMap);
        setLocalizer(localizer);
    }

}

