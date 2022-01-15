package frc.robot.Subsystem;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.VelocityMap;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Shooter {
    public TalonFX lTalon;
    public TalonFX rTalon;

    public Shooter() {
        lTalon = new TalonFX(RobotMap.LEFT_SHOOTER_ID);
        rTalon = new TalonFX(RobotMap.RIGHT_SHOOTER_ID);
        lTalon.configFactoryDefault();
        rTalon.configFactoryDefault();
    }

    public void shoot() {
        double distance = Robot.limelight.getDistance();
        double speed = calcSpeed(distance);
        lTalon.set(ControlMode.Velocity, speed);
        rTalon.set(ControlMode.Velocity, speed);
    }

    public void stop() {
        lTalon.set(ControlMode.PercentOutput, 0);
        rTalon.set(ControlMode.PercentOutput, 0);
    }

    private double calcSpeed(double distance) {
        if (distance < 0 || distance > 12) {
            return 0.0;
        } else {
            // Distance between values
           return VelocityMap.map.floorEntry((int)Math.round(distance)).getValue();
        }
    }
}
