package org.firstinspires.ftc.teamcode.team4348.PID.legacy;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * Allows for easy objectification of the ADAFruitIMU.
 * Initializes it at construction. Assumes calibration has taken place.
 * Calibration Data File = "AdafruitIMUCalibration.json"
 */

public class ADAFruitIMU extends PIDInput
{
    // The IMU sensor object
    private AdafruitBNO055IMU imu;

    public ADAFruitIMU(HardwareMap hMap, String name)
    {
        // Set up the parameters with which we will use our IMU. Note that integration
        // algorithm here just reports accelerations to the logcat log; it doesn't actually
        // provide positional information.
        AdafruitBNO055IMU.Parameters parameters = new AdafruitBNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named name.
        imu = hMap.get(AdafruitBNO055IMU.class, name);
        imu.initialize(parameters);
    }
    public double getValue()
    {
        Orientation orent = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
        return orent.firstAngle;
    }

    @Override
    public double normalizeValue(double value)
    {
        while(value >= 360) {
            value -= 360;
        }
        while(value < 0) {
            value += 360;
        }
        return value;
    }

    @Override
    public double normalizeError(double error)
    {
        if(error < -180) {
            error += 360;
        }
        else if(error > 180) {
            error -= 360;
        }
        return error;
    }
}