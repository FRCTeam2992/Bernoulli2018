package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto2CubeLScaleSwitch extends CommandGroup {

    public Auto2CubeLScaleSwitch() {
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
    	addSequential(new AutoLtoLScale());
    	//next lines are for getting switch
    	addSequential(new AutoDriveFwd(-10, 0.5, 3, true, 135));
    	addParallel(new intakeStop());
    	addSequential(new liftHeight(Robot.constants.switchHeight+5, 3));
    	addSequential(new AutoDriveFwd(12, 0.5, 3, true, 180));
    	addSequential(new intakeOut(1));
    }
}
