package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoLtoLScale extends CommandGroup {

    public AutoLtoLScale() {
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
    	addSequential(new AutoDriveFwd(262, 0.5, 4, true, 0));
    	addSequential(new AutoIntakeReady());
    	addSequential(new liftHeight(35.5, 4));
    	addParallel(new liftStop());
    	addSequential(new AutoDriveTurn(60, 0.8, 3));    	
    	addSequential(new AutoDriveFwd(12, 0.3, 3, true, 60));
    	addParallel(new intakeOut(1.0));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new AutoDriveFwd(-24, 0.3, 3, true, 60));
    	addParallel(new intakeStop());
    	addParallel(new liftHeight(0, 5));
    	addSequential(new AutoDriveTurn(135, 0.3, 3));
    	addParallel(new intakeArmsOpen(true));
    	addSequential(new AutoDriveFwd(30, 0.5, 3, true, 135));
    	addParallel(new AutoDriveFwd(6, 0.4, 3, true, 90));
    	addParallel(new intakeIn(1));
    	addSequential(new WaitCommand(1));
    	
    	
    	
    	
    	
    }
}
