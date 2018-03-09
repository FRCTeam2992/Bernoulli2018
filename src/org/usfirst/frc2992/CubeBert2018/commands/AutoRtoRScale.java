package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoRtoRScale extends CommandGroup {

    public AutoRtoRScale() {
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
    	addSequential(new AutoDriveFwd(300, 0.8, 3, true, 0));
    	addSequential(new AutoIntakeReady());
    	addSequential(new liftHeight(Robot.constants.topScaleHeight, 2.5));
    	addParallel(new liftStop());    	
    	addSequential(new AutoDriveTurn(-90, 0.8, 3));
    	addSequential(new AutoDriveFwd(24, 0.3, 3, true, -90));
    	addParallel(new intakeOut(1.0));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new AutoDriveFwd(-24, 0.3, 3, true, -90));
    	addParallel(new intakeStop());
    }
}
