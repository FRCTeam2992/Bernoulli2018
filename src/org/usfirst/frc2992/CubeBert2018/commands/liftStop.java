// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.CubeBert2018.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2992.CubeBert2018.Robot;
import org.usfirst.frc2992.CubeBert2018.RobotMap;

/**
 *
 */
public class liftStop extends Command {
	
	Timer stopTimer = new Timer();
	double position = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public liftStop() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	this.setInterruptible(true);
    	stopTimer.reset();
    	stopTimer.start();
    	if (Robot.constants.liftEncoder) {
    		position = RobotMap.liftClimberliftEnc.getDistance();
    		Robot.lift.holdPosn(position);
    	} else {
    		Robot.lift.liftUp(0.1);
    		
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if (stopTimer.get() < 30 && !Robot.oi.climbMasterEnableBtn.get()) {
    		
    		// Don't do backdrive prevention if in climbing mode
    		if (Robot.constants.liftEncoder) {
        		Robot.lift.holdPosn(position);
        	} else {
        		Robot.lift.liftUp(0.1);        		
        	}


    	} else {
        	Robot.lift.stopLift();    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.lift.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	Robot.lift.stopLift();
    }
}
