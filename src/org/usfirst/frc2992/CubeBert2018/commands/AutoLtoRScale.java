package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoLtoRScale extends CommandGroup {

    public AutoLtoRScale() {
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
    	addParallel(new liftHeight(Robot.constants.topScaleHeight+3,4));
    	addSequential(new AutoDriveFwd(Robot.constants.autoCrossLineDist,0.5,5,true,0));
    	addSequential(new AutoDriveTurn(90,0.5,2));
    	addSequential(new AutoDriveFwd(250,0.5,8,true,90));
    	addSequential(new AutoDriveTurn(0,0.5,2));
    	addSequential(new AutoDriveFwd(111,0.5,5,true,0));
    	addSequential(new AutoDriveTurn(-90,0.5,2));
    	addSequential(new AutoDriveFwd(28,0.5,5,true,-90));
    	addSequential(new intakeOut(0.5));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoDriveFwd(-28,0.5,5,true,-90));
    	addSequential(new AutoDriveTurn(-180,0.5,2));
    }
}
