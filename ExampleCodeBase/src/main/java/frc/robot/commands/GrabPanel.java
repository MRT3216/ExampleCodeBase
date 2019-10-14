/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.PanelManipulator;

/**
 * Add your docs here.
 */
public class GrabPanel extends InstantCommand {
  private PanelManipulator hatchManipulator = PanelManipulator.GetInstance();

  private boolean grab;


  public GrabPanel(boolean grab) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(hatchManipulator);
    this.grab = grab;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    hatchManipulator.grabPanel(grab);
  }

}
