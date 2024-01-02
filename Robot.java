// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.spikes2212.command.drivetrains.TankDrivetrain;
import com.spikes2212.command.drivetrains.commands.DriveArcade;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MoveArms;
import frc.robot.subsystems.Pincers;

public class Robot extends TimedRobot {

  private TankDrivetrain driveTrain;
  private Pincers pincers;

  @Override
  public void robotInit() {

      driveTrain = new TankDrivetrain(
                "drivetrain",
                new MotorControllerGroup( // ROTATIONAL
                        new WPI_TalonSRX(RobotMap.CAN.TALON_LEFT_1),
                        new WPI_TalonSRX(RobotMap.CAN.TALON_LEFT_2)
                ),

                new MotorControllerGroup( // LINEAR
                        new WPI_TalonSRX(RobotMap.CAN.TALON_RIGHT_1),
                        new WPI_VictorSPX(RobotMap.CAN.VICTOR_RIGHT_2)
                )
        );

      pincers = new Pincers(new WPI_TalonSRX(RobotMap.CAN.PINCER_TALON));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {

      OI oi = new OI();
      driveTrain.setDefaultCommand(new DriveArcade(driveTrain, oi::getLeftX, oi::getRightY));
      pincers.setDefaultCommand(new MoveArms(pincers, oi::getJoyStickY, 45, 315));

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {

  }

  @Override
  public void simulationInit() {

  }

  @Override
  public void simulationPeriodic() {

  }
}
