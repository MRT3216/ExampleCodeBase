/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.settings.Constants;
import frc.robot.settings.RobotMap.ROBO_RIO.DRIVETRAIN;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {

	private CANSparkMax left_master;
	private CANSparkMax left_slave;
	private CANSparkMax right_master;
	private CANSparkMax right_slave;

	private static Drivetrain instance = null;

	public static Drivetrain getInstance() {
		if (instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}

	private Drivetrain() {
	left_master = new CANSparkMax(DRIVETRAIN.LEFT_MASTER_MOTOR, Constants.kBrusheless);
	left_slave = new CANSparkMax(DRIVETRAIN.LEFT_SLAVE_MOTOR, Constants.kBrusheless);
	right_master = new CANSparkMax(DRIVETRAIN.RIGHT_MASTER_MOTOR, Constants.kBrusheless);
	right_slave = new CANSparkMax(DRIVETRAIN.RIGHT_SLAVE_MOTOR, Constants.kBrusheless);

	left_master.setInverted(true);
	left_slave.setInverted(true);

	left_slave.follow(left_master);
	right_slave.follow(right_master);
	}


	public void setPower(double left, double right) {
		left = safetyCheck(left);
		right = safetyCheck(right);
		left_master.set(left);
		right_master.set(right);
	}

	private double safetyCheck(double power) {
        power = Math.min(1.0, power);
        power = Math.max(-1.0, power);
        return power;
    }

	public void stop() {
		left_master.stopMotor();
		right_master.stopMotor();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
