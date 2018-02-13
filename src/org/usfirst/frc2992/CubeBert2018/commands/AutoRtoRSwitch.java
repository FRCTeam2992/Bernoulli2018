package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRtoRSwitch extends CommandGroup {

    public AutoRtoRSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new intakeDeployed(true));
    	addParallel(new liftHeight(Robot.constants.switchHeight, 2));
    	addSequential(new AutoDriveFwd(168, 0.5, 3, true, 0));
    	addSequential(new AutoDriveTurn(-90, 0.5, 3));
    	addSequential(new AutoDriveFwd(35, 0.5, 3, true, -90));
    	addSequential(new intakeOut(0.5));
    }
}
