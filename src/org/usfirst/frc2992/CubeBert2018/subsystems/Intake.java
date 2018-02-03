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
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Intake extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final SpeedController leftIntakeMotor = RobotMap.intakeleftIntakeMotor;
	private final SpeedController rightIntakeMotor = RobotMap.intakerightIntakeMotor;
	private final DigitalInput leftIntakeSensor = RobotMap.intakeleftIntakeSensor;
	private final DigitalInput rightIntakeSensor = RobotMap.intakerightIntakeSensor;
	private final Solenoid intakeArmsSol = RobotMap.intakeintakeArmsSol;
	private final Solenoid intakeDeploySol = RobotMap.intakeintakeDeploySol;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new intakeStop());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public double leftCounter=0;//for intake stop function
	public double rightCounter=0;//counters up here so dont reset to 0 every time reruns

	public void deployIntake(boolean deploy) {
		intakeDeploySol.set(deploy);
	}

	public void intakeArmsOpen(boolean open) {
		intakeArmsSol.set(open);
	}
	public void intakeIn(double speed){
		if(intakeDeploySol.get()==true) {   //only runs the intake when arms are down- never up.
			speed = Math.max(0.0,  Math.min(1.0, speed)); // Enforce 0.0 <= speed <= 1.0. finds min of 1 or speed so cant be faster than 100% then max so not neg.
			leftIntakeMotor.set(speed);
			rightIntakeMotor.set(speed-0.2);//make one side run slower than other to correct angled cubes
		}
		else {
			intakeStop();
		}
	}

	public void intakeOut(double speed){
		if(intakeDeploySol.get()==true) {
			speed = Math.max(0.0,  Math.min(1.0, speed));  // Enforce 0.0 <= speed <= 1.0
			leftIntakeMotor.set(-speed);
			rightIntakeMotor.set(-speed);
		}
		else {
			intakeStop();
		}
	}
	public void intakeStop(){
		if(leftIntakeSensor.get()==true) {//makes left intake motor run a bit longer when sensor sees smthg-to get cube in all way
			leftCounter++;//increments counter
			if(leftCounter==5) {//after 100ms motor stops
				leftIntakeMotor.set(0);
				leftCounter=0;//resets counter
			}
		}
		if(rightIntakeSensor.get()==true) {//makes right intake motor run a bit longer when sensor sees smthg-to get cube in all way
			rightCounter++;
			if(rightCounter==5) {//after 100ms motor stops bc runs again every 20ms
				rightIntakeMotor.set(0);
				rightCounter=0;//resets counter
			}
		}
		else {
			leftIntakeMotor.set(0);
			rightIntakeMotor.set(0);
		}
		
	}
}


