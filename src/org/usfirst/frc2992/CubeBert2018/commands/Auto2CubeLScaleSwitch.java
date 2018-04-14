package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
    	addParallel(new AutoIntakeReady());
    	addSequential(new AutoDriveFwd(244, 0.8, 4, true, 0));
    	addSequential(new liftHeight(33.5, 3));
    	addParallel(new liftStop());    	
    	addSequential(new AutoDriveTurn(-60, 0.8, 3));
    	addSequential(new AutoDriveFwd(12, 0.3, 3, true, -60));
    	addParallel(new intakeOut(1.0));
    	addSequential(new WaitCommand(0.25));
    	addSequential(new AutoDriveFwd(-12, 0.3, 3, true, -60));
    	addParallel(new intakeStop());
    	addParallel(new liftHeight(0, 5));
    	addSequential(new AutoDriveTurn(-145, 0.3, 3));
    	//next lines for getting 2nd cube
    	addSequential(new intakeArmsOpen(true));
    	addSequential(new AutoDriveFwd(45, 0.8, 3, true, -90));
    	addSequential(new AutoDriveTurn(-180, 0.8, 1));
    	addParallel(new intakeIn(1));
    	addSequential(new AutoDriveFwd(45, 0.35, 3, true, -180));
    	//addSequential(new WaitCommand(0.25));
    	addSequential(new intakeArmsOpen(false));
    	addSequential(new WaitCommand(0.5));
    	addParallel(new intakeStop());
    	//addSequential(new AutoLtoLScale());//loads 2nd cube already (didnt work bc never ended)
    	//next lines are for getting switch
    	addSequential(new AutoDriveFwd(-10, 0.5, 3, true, 0));
    	addParallel(new intakeStop());
    	addSequential(new liftHeight(Robot.constants.switchHeight+5, 3));
    	addSequential(new AutoDriveFwd(20, 0.5, 3, true, 180));
    	addParallel(new intakeOut(1));
    	addSequential(new WaitCommand(1));
    	addParallel(new intakeStop());
    }
}
