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

	private CANSparkMax leftMaster;
	private CANSparkMax leftSlave;
	private CANSparkMax rightMaster;
	private CANSparkMax rightSlave;

	private static Drivetrain instance = null;

	public static Drivetrain getInstance() {
		if (instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}

	private Drivetrain() {
		leftMaster = new CANSparkMax(DRIVETRAIN.LEFT_MASTER_MOTOR, Constants.kBrusheless);
		leftSlave = new CANSparkMax(DRIVETRAIN.LEFT_SLAVE_MOTOR, Constants.kBrusheless);
		rightMaster = new CANSparkMax(DRIVETRAIN.RIGHT_MASTER_MOTOR, Constants.kBrusheless);
		rightSlave = new CANSparkMax(DRIVETRAIN.RIGHT_SLAVE_MOTOR, Constants.kBrusheless);

		leftMaster.setInverted(true);
		leftSlave.setInverted(true);

		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);
	}

	public void setPower(double left, double right) {
		left = safetyCheck(left);
		right = safetyCheck(right);
		leftMaster.set(left);
		rightMaster.set(right);
	}

	private double safetyCheck(double power) {
		power = Math.min(1.0, power);
		power = Math.max(-1.0, power);
		return power;
	}

	public void stop() {
		leftMaster.stopMotor();
		rightMaster.stopMotor();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
