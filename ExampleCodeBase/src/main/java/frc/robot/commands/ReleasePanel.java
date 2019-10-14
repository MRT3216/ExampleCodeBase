package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.PanelManipulator;;

public class ReleasePanel extends InstantCommand {
    private boolean extend;
    private PanelManipulator hatchManipulator = PanelManipulator.getInstance();

    public ReleasePanel(boolean extend) {
        super();
        requires(hatchManipulator);
        // Use requires() here to declare subsystem dependencies
        this.extend = extend;
    }

    @Override
    protected void initialize() {
        hatchManipulator.releasePanel(extend);
    }
}