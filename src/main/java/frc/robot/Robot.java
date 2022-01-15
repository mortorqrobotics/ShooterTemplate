// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Subsystem.Limelight;
import frc.robot.Subsystem.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code
   */

  Shooter shooter;
  OI oi;

  public static Limelight limelight;

  @Override
  public void robotInit() {
    shooter = new Shooter();
    limelight = new Limelight();
    oi = new OI();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopPeriodic() {
    boolean isPressed = oi.joystick.getRawButton(0);
    if(isPressed) {
      shooter.shoot();
    }
  }
}