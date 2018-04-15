package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCenterSwitch extends CommandGroup {
	//for auto stuff do commandgroup so can sequence other commands
	
    public AutoCenterSwitch() {
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
    	String gameData = Robot.gameData;
    	
    	if(gameData.length() > 0){
    		if(gameData.charAt(0) == 'L'){
    			//addSequential(new AutoAngleCtoLSwitch());
    			addSequential(new AutoCtoLSwitch());
    			Robot.autoPath = "AutoCtoLSwitch";//can't send stuff to SmartDashboard in a commandGroup.
    			return;
    			// autoPath a way to send the info to smartdashboard - sent in Robot
    		}
    		else if(gameData.charAt(0)=='R') {
    			//addSequential(new AutoAngleCtoRSwitch());
    			addSequential(new AutoCtoRSwitch());
    			Robot.autoPath =  "AutoCtoRSwitch";
    			return;
    		}
    	}
		addSequential(new intakeDeployed(false));
		addSequential(new AutoDriveFwd(30,0.8,3,true,0));
		addSequential(new AutoDriveTurn(90,0.8,3));
		addSequential(new AutoDriveFwd(49,0.8,3,true,90));
		addSequential(new AutoDriveTurn(0,0.8,3));
		addSequential(new AutoIntakeReady());
		addSequential(new liftHeight(Robot.constants.switchHeight+5, 4.0));
		addParallel(new liftStop());
		addSequential(new AutoDriveFwd(74,0.8,3,true,0));
		Robot.autoPath =  "AutoCtoCrossLine";

    		
    }
}
