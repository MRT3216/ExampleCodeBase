/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.settings.RobotMap.ROBO_RIO.PNEUMATICS;

/**
 * Add your docs here.
 */
public class PanelManipulator extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private static PanelManipulator instance;

    private final DoubleSolenoid.Value forward = DoubleSolenoid.Value.kForward; // forward position and open
    private final DoubleSolenoid.Value reverse = DoubleSolenoid.Value.kReverse; // reversed position and closed

    private DoubleSolenoid leverArm;
    private DoubleSolenoid release;

    public static PanelManipulator getInstance() {
        if (instance == null) {
            instance = new PanelManipulator();
        }
        return instance;
    }

    private PanelManipulator() {
        leverArm = new DoubleSolenoid(PNEUMATICS.LEVER_ARM_O, PNEUMATICS.LEVER_ARM_C);
        leverArm.set(forward);

        release = new DoubleSolenoid(PNEUMATICS.RELEASE_O, PNEUMATICS.RELEASE_C);
        release.set(reverse);
    }

    public void grabPanel(boolean grab) {
        if (grab) {
            if (leverArm.get() != forward) {
                leverArm.set(forward);
            }
        } else {
            if (leverArm.get() != reverse) {
                leverArm.set(reverse);
            }
        }
    }

    public void releasePanel(boolean extend) {
        if (extend) {
            if (release.get() != forward) {
                release.set(forward);
            }
        } else {
            if (release.get() != reverse) {
                release.set(reverse);
            }
        }
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
