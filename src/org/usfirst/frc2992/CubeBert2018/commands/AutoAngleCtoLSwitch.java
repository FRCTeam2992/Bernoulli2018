package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoAngleCtoLSwitch extends CommandGroup {
	//for auto stuff do commandgroup so can sequence other commands
	
    public AutoAngleCtoLSwitch() {
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
    	addSequential(new AutoAngleSwitchLiftLeft());
    	addParallel(new liftStop());// parallel bc otherwise wouldnt go on - return false to isfinished

    	//addSequential(new AutoDriveTurn(-33.27,0.8,2));
    	//addSequential(new AutoDriveFwd(76.55,0.8,8,true,-33.27));
    	//addSequential(new AutoDriveTurn(0,0.8,2));
    	addSequential(new AutoDriveFwd(62,0.5,3.5,true,0));
    	addSequential(new intakeOut(1.0));
    	addSequential(new WaitCommand(1.0));
    	addParallel(new intakeStop());
    	
    }
}
