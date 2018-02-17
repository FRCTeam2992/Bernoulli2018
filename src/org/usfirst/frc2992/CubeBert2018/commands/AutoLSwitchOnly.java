package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLSwitchOnly extends CommandGroup {

    public AutoLSwitchOnly() {
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
    		if(gameData.charAt(0) == 'L') {
    			addSequential(new AutoLtoLSwitch());
    			Robot.autoPath = "AutoLtoLSwitch";
    		}
    		else {
    			addSequential(new AutoDriveFwd(Robot.constants.autoCrossLineDist,0.5,10,true,0));//auto cross line
    			Robot.autoPath = "AutoCrossLine";
    		}
    	}
    }
}
