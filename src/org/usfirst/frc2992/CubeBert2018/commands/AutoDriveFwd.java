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

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class AutoDriveFwd extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_dist;
    private double m_speed;
    private double m_timeOut;
    private boolean m_gyro;
    private double m_heading;
    
    Timer timer;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoDriveFwd(double dist, double speed, double timeOut, boolean gyro, double heading) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_dist = dist;
        m_speed = speed;
        m_timeOut = timeOut;
        m_gyro = gyro;
        m_heading = heading;
        
        timer = new Timer();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	this.setInterruptible(true);
    	
    	RobotMap.driveTrainleftDriveEnc.reset();
    	RobotMap.driveTrainrightDriveEnc.reset();
    	timer.reset();
    	timer.start();
    	
    	Robot.driveTrain.SmartDriveDist(m_dist);//sets distance
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	if (m_gyro) {
        	Robot.driveTrain.SmartDriveGyro(m_heading, m_speed);//sets heading and speed
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if(timer.get()>=m_timeOut || Robot.driveTrain.driveDone("dist")) {//if one of these true, it's finished
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	for (WPI_TalonSRX motor : RobotMap.allmotors) {
    		motor.setNeutralMode(NeutralMode.Coast);
    	}
    	Robot.driveTrain.lowGear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	for (WPI_TalonSRX motor : RobotMap.allmotors) {
    		motor.setNeutralMode(NeutralMode.Coast);
    	}
    	Robot.driveTrain.lowGear();
    }
}
