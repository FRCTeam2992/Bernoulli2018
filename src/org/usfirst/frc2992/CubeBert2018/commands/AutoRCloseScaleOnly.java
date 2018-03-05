package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRCloseScaleOnly extends CommandGroup {

    public AutoRCloseScaleOnly() {
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
    	
    	if(gameData.length() > 1){
    		if(gameData.charAt(1) == 'L') {
    			addSequential(new AutoDriveFwd(Robot.constants.autoCrossLineDist, 0.8, 5, true, 0));
    			Robot.autoPath = "AutoCrossLine";
    			return;
    		}
    		else if(gameData.charAt(1) == 'R') {
    			addSequential(new AutoRtoRScale());
    			Robot.autoPath = "AutoRtoRScale";
    			return;
    		}
    	}
		addSequential(new AutoDriveFwd(Robot.constants.autoCrossLineDist, 0.5, 3, true, 0));
		Robot.autoPath = "AutoCrossLine";

    }
}
