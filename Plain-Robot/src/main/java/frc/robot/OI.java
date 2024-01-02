package frc.robot;

import com.spikes2212.util.PlaystationControllerWrapper;
import edu.wpi.first.wpilibj.Joystick;

public class OI {

    private final PlaystationControllerWrapper ps = new PlaystationControllerWrapper(0);
    private final Joystick joystick = new Joystick(1);

    public OI() {

    }

    double getJoyStickY()
    {
        return joystick.getY() * RobotMap.CAN.PINCER_MULTIPLIER;
    }

    double getRightY()
    {
        return ps.getRightY() * RobotMap.CAN.LINEAR_MULTIPLIER;
    }

    double getLeftX()
    {
        return ps.getLeftX() * RobotMap.CAN.ROTATIONAL_MULTIPLIER;
    }
}
