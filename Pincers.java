package frc.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Pincers extends SubsystemBase {

    protected MotorController motorController;
    protected AnalogEncoder sensor;


    public Pincers(MotorController motorController) {
        this.motorController = motorController;
        this.sensor = new AnalogEncoder(RobotMap.CAN.SENSOR_CHANNEL);

    }

    public double getRotation()
    {
        return sensor.get();
    }

    public void setSpeed(double speed)
    {
        motorController.set(speed);
    }

    public void stop()
    {
        motorController.stopMotor();
    }
}
