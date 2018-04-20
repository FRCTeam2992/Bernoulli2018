package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoAngleCtoRSwitch extends CommandGroup {
	//for auto stuff do commandgroup so can sequence other commands
	
    public AutoAngleCtoRSwitch() {
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

    	/*
    	addSequential(new AutoIntakeReady());
    	addSequential(new liftHeight(Robot.constants.switchHeight+5,3));
    	addParallel(new liftStop());// parallel bc otherwise wouldnt go on - return false to isfinished
    	addSequential(new AutoDriveFwd(20+76.55,0.8,3,true,-33.27));
    	*/
    	addSequential(new AutoAngleSwitchLiftRight());
    	addParallel(new liftHeight(Robot.constants.switchHeight+7,3));
    	addSequential(new AutoDriveTurn(70, 0.5, 1));
    	addSequential(new AutoDriveFwd(60,0.5,2.5,true,0));//dist used to be 56

    	addParallel(new liftStop());// parallel bc otherwise wouldnt go on - return false to isfinished
    	
    	//addSequential(new AutoDriveTurn(-33.27,0.8,2));
    	//addSequential(new AutoDriveFwd(76.55,0.8,8,true,-33.27));
    	//addSequential(new AutoDriveTurn(0,0.8,2));
    	//addSequential(new WaitCommand(2.0));
    	addParallel(new intakeOut(1.0));
    	addSequential(new WaitCommand(1.0));
    	addParallel(new intakeStop());
    	
    	//un-comment next part for a double cube auto
    	
    	addSequential(new AutoDriveFwd(-48, 0.8, 2, true, 0));
    	addParallel(new liftHeight(0, 3));
    	addSequential(new AutoDriveTurn(-60, 0.8, 1.5));
    	//addParallel(new liftStop());
    	addParallel(new intakeArmsOpen(true));
    	addParallel(new intakeIn(1));
    	addSequential(new AutoDriveFwd(46, 0.4, 3, true, -60));//change value 
    	addParallel(new AutoDriveFwd(10, 0.3, 3, true, -90));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new intakeArmsOpen(false));
    	addSequential(new WaitCommand(0.7));
    	addParallel(new liftHeight(Robot.constants.switchHeight+7, 3));
    	addSequential(new AutoDriveFwd(-49, 0.8, 3, true, -60));
    	addParallel(new intakeStop());
    	addSequential(new AutoDriveTurn(0, 0.8, 3));
    	addSequential(new AutoDriveFwd(50, 0.8, 3, true, 0));
    	addParallel(new liftStop());
    	addParallel(new intakeOut(1));
    	addSequential(new WaitCommand(1));
    	addParallel(new intakeStop());
    	addSequential(new AutoDriveFwd(-20, 0.8, 3, true, 0));
    }
}
