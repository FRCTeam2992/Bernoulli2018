package org.usfirst.frc2992.CubeBert2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoIntakeReady extends CommandGroup {

    public AutoIntakeReady() {
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
    	
    	// Sequence of steps to get the intake safely deployed off the start hook
		addSequential(new liftHeight(7, 4.0));
		addSequential(new intakeDeployed(true));
		addSequential(new WaitCommand(0.75));

    }
}
