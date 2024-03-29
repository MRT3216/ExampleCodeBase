/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.settings;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static class ROBO_RIO {
        public static class DRIVETRAIN {
            public static final int LEFT_MASTER_MOTOR = 0;
            public static final int LEFT_SLAVE_MOTOR = 1;
            public static final int RIGHT_MASTER_MOTOR = 2;
            public static final int RIGHT_SLAVE_MOTOR = 3;

        }

        public static class PNEUMATICS {
            public static final int LEVER_ARM_O = 0;
            public static final int LEVER_ARM_C = 1;

            public static final int RELEASE_O = 2;
            public static final int RELEASE_C = 3;
        }
    }

    public static class DRIVE_STATION {
        public static final int USB_GAMEPAD = 0;
    }
}