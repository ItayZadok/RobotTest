package frc.robot;

public class RobotMap {

    public interface CAN {

        int TALON_LEFT_1 = 5;
        int TALON_LEFT_2 = 6;
        int TALON_RIGHT_1 = 8;
        int VICTOR_RIGHT_2 = 14;

        double LINEAR_MULTIPLIER = 0.75;
        double ROTATIONAL_MULTIPLIER = 0.75;

        int PINCER_TALON = 1;
        int SENSOR_CHANNEL = 0;
        double PINCER_MULTIPLIER = 0.75;
    }
    
    public interface DIO {

    }
    
    public interface PWM {

    }
    
    public interface AIN {
    
    }

    public interface PCM {

    }
}
