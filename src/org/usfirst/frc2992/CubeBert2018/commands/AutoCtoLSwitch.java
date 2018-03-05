package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCtoLSwitch extends CommandGroup {

    public AutoCtoLSwitch() {
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
    	
		addSequential(new AutoDriveFwd(30,0.8,2.5,true,0));
		addSequential(new AutoDriveTurn(-90,0.8,2.5));
		addSequential(new AutoDriveFwd(64,0.8,2.5,true,-90));
		addSequential(new AutoDriveTurn(0,0.8,2.5));

		addSequential(new intakeDeployed(true));
		addSequential(new liftHeight(Robot.constants.switchHeight+6, 4.0));
		addSequential(new AutoDriveFwd(74,0.5, 3,true,0));
		addSequential(new intakeOut(1.0));
    
    }
}
