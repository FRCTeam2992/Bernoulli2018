// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.CubeBert2018.subsystems;

import org.usfirst.frc2992.CubeBert2018.Robot;
import org.usfirst.frc2992.CubeBert2018.RobotMap;
import org.usfirst.frc2992.CubeBert2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Lift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_VictorSPX liftMotor = RobotMap.liftClimberliftMotor;
    private final DigitalInput liftBottomSensor = RobotMap.liftClimberliftBottomSensor;
    private final DigitalInput liftTopSensor = RobotMap.liftClimberliftTopSensor;
    private final Encoder liftEnc = RobotMap.liftClimberliftEnc;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final PIDController liftPID = RobotMap.liftPID;
    
    private final double LiftUpPower = Robot.constants.liftUpPower;
    private final double liftDownPower = Robot.constants.liftDownPower;
    
    private double liftBottomEncVal = 0.0;		// Assume we start at the bottom
    private final double liftMaxTravel = 42.0;		// Inches we can move bottom to top
   
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new liftStop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void LiftClimber() {
    	// Reset the lift encoder and initialize the bottom of lift offset
    	liftEnc.reset();
    	liftBottomEncVal = 0.0;
    }
    
    @Override
    public void periodic() {
        // Put code here to be run every loop
    	
    	// Make sure the lift PID motors aren't pushing us past the limit switches
    	//dont have to do ==true. redundant
    	if (!liftTopSensor.get() && !liftBottomSensor.get()) {
    		// Should never get here -- broken switch so disable auto moves
    		liftPID.setOutputRange(0.0,  0.0);
    	}
    	else if (!liftTopSensor.get()) {
    		// At top so only allow PID driving down
    		liftPID.setOutputRange(liftDownPower, 0.0);
    		// And reset the encoder reference for bottom of lift
    		// Bottom is our current encoder reading minus height of lift
    		liftBottomEncVal = liftEnc.getDistance() - liftMaxTravel;
    	} 
    	else if (!liftBottomSensor.get()) {
    		// At bottom so only allow PID driving up
    		liftPID.setOutputRange(0.0,  LiftUpPower);
    		// Reset bottom of lift reference to our current position
    		liftBottomEncVal = liftEnc.getDistance();
    	} 
    	else {
    		// Neither top nor bottom so full motion allowed
    		liftPID.setOutputRange(liftDownPower, LiftUpPower);
    	}
    	
    	
    	// If we are done with a PID move, then disable the PID
    	if (liftPID.isEnabled() && liftPID.onTarget()) {
    		liftPID.disable();
    	}
    	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void stopLift() {
    	liftPID.disable();
    	liftMotor.set(0);
    }

    public void downLift(double speed) {
    	liftPID.disable();
    	if(!liftBottomSensor.get()==true) {//make sure lift won't keep running down when reaches bottom
    		stopLift();
    	}
    	else {
    	liftMotor.set(Math.min(speed, 0));//make sure speed is neg
    	}
    }
    public void liftUp(double speed) {
    	liftPID.disable();
    	//make sure lift won't keep going up when reaches very top.
    	
    	if(!liftTopSensor.get()==true ) {
    		liftMotor.set(0.1);
    	}
    	else {
    			liftMotor.set(Math.max(speed, 0));//make sure speed is pos
    	}
    }
    public void goToHeight(double height) {
    	height = Math.max(0.0, Math.min(liftMaxTravel, height));  // 0 <= height <= liftMaxTravel
    	// And offset it by the current bottom of lift encoder offset
    	height += liftBottomEncVal;
    	
    	// And we are ready to drive the PID
    	liftPID.setSetpoint(height);
    	liftPID.enable();
    }
   
    public boolean atHeight() {
    	return liftPID.onTarget();
    }
    
    
}
