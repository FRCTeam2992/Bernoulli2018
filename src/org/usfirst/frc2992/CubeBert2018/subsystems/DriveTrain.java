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

import org.usfirst.frc2992.CubeBert2018.RobotMap;
import org.usfirst.frc2992.CubeBert2018.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.usfirst.frc2992.CubeBert2018.mhJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Solenoid driveTrainSolenoid = RobotMap.driveTraindriveTrainSolenoid;
    private final WPI_TalonSRX rFDriveMotor = RobotMap.driveTrainrFDriveMotor;
    private final WPI_TalonSRX rBDriveMotor = RobotMap.driveTrainrBDriveMotor;
    private final WPI_TalonSRX rMDriveMotor = RobotMap.driveTrainrMDriveMotor;
    private final WPI_TalonSRX lFDriveMotor = RobotMap.driveTrainlFDriveMotor;
    private final WPI_TalonSRX lMDriveMotor = RobotMap.driveTrainlMDriveMotor;
    private final WPI_TalonSRX lBDriveMotor = RobotMap.driveTrainlBDriveMotor;
    public final Encoder rightDriveEnc = RobotMap.driveTrainrightDriveEnc;
    public final Encoder leftDriveEnc = RobotMap.driveTrainleftDriveEnc;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public final AHRS navx = RobotMap.navx;
    
    public PIDController lDistPID, rDistPID;
    DrivePID lDistance, rDistance;
    

    //distance pid
    final double dkp = .12;
    final double dki = 0;
    final double dkd = .1;
    
    //gyro pid
    double gkp = .03; 
    double gkd = .0;
    double gError = 0.0;
    
    RotatePID turn;
    public PIDController turnPID;
    
    //rotate pid
    final double rkp = .03;
    final double rki = .01;
    final double rkd = .056;

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new driveSticks());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public DriveTrain(){
    	lDistance = new DrivePID(RobotMap.leftmotors);
    	lDistPID = new PIDController(dkp, dki, dkd,leftDriveEnc, lDistance);
    	lDistPID.setOutputRange(-0.5, 0.5);
    	//lDistPID.setInputRange(-321.0, 321.0);
    	lDistPID.setPercentTolerance(1.0);
    	lDistPID.setName("Left Dist PID");
    	LiveWindow.add(lDistPID);
    	
    	lDistPID.disable();


    	rDistance = new DrivePID(RobotMap.rightmotors);
    	rDistPID = new PIDController(dkp, dki, dkd, rightDriveEnc, rDistance);
    	rDistPID.setOutputRange(-0.5, 0.5);
    	//rDistPID.setInputRange(-321.0, 321.0);
    	rDistPID.setPercentTolerance(1.0);
    	rDistPID.setName("Right Dist PID");
    	LiveWindow.add(rDistPID);
    	rDistPID.disable();

    	turn = new RotatePID(RobotMap.leftmotors, RobotMap.rightmotors);
    	turnPID = new PIDController(rkp, rki, rkd, navx, turn);//change to navx for real robot
    	turnPID.setOutputRange(-0.35, 0.35);
    	turnPID.setInputRange(-180.0, 180.0);
    	turnPID.setContinuous();
    	turnPID.setAbsoluteTolerance(3);
    	LiveWindow.add(turnPID);
    	turnPID.disable();
    }
    
    public void SmartDriveDist(double distance){//for pid- drive no gyro
    	turnPID.disable();
    	//drivelib.smartDrive(distance, 0, lDistPID, rDistPID);
    	lDistPID.reset();
    	rDistPID.reset();
    	lDistPID.setSetpoint(distance);
    	rDistPID.setSetpoint(distance);
    	lDistPID.enable();
    	rDistPID.enable();
    }

    public void SmartDriveGyro(double heading, double power){//for pid - drive w/gyro
    	power = Math.abs(power);
    	double gyroError = calcGyroError(heading);
    	double pGyro = gError - gyroError;
    	System.out.println("GyroError:  " + gyroError);
    	lDistPID.setOutputRange(-power - gkp*gyroError + gkd *pGyro, power - gkp*gyroError + gkd *pGyro);
    	rDistPID.setOutputRange(-power + gkp*gyroError - gkd *pGyro, power + gkp*gyroError - gkd *pGyro);
    	System.out.println("Left power:  " + (power-gkp*gyroError - gkd *pGyro));
    	System.out.println("Right power:  " + (power + gkp*gyroError + gkd *pGyro));
    	gError = gyroError;
    }
    
    public void SmartDriveRot(double degrees){//for pid- rotate
    	lDistPID.disable();
    	rDistPID.disable();
    	//drivelib.smartDrive(0, degrees, turnPID);
    	turnPID.setSetpoint(degrees);
    	turnPID.enable();
    }
    
    private double calcGyroError(double heading){//for pid- finding error (difference)
    	double error = 0;
    	error = scaleAngle(navx.getYaw() - heading);
    	if(Math.abs(error) >= 1){
    		return error;
    	} else {
    		return 0;
    	}
    }

    private double scaleAngle(double angle){//for pid- make sure turning shortest dist - think circle
    	while(angle > 180){
    		angle -= 360;
    	}
    	while(angle < -180){
    		angle += 360;
    	}
    	return angle;
    }

    public boolean driveDone(String type){//for pid to see if drive fwd or drive turn is finished
    	if(type == "dist"){
    		if(lDistPID.onTarget() && rDistPID.onTarget()){
    			return true;
    		} else {
    			return false;
    		}
    	} else if(type == "rot"){
    		if(turnPID.onTarget()){
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
	}
    
    public void allStop() {
    	rFDriveMotor.set(0.0);
    	rMDriveMotor.set(0.0);
    	rBDriveMotor.set(0.0);
    	lFDriveMotor.set(0.0);
    	lMDriveMotor.set(0.0);
    	lBDriveMotor.set(0.0);
    }
    
    public void tankDrive(double left, double right) {
    	rFDriveMotor.set(right);
    	rMDriveMotor.set(right);
    	rBDriveMotor.set(right);
    	lFDriveMotor.set(left);
    	lMDriveMotor.set(left);
    	lBDriveMotor.set(left);
    	
    }
    
    public void highGear() {
    	driveTrainSolenoid.set(true);
    }
    
    public void lowGear() {
    	driveTrainSolenoid.set(false);
    }
    
    /*
    public boolean autoDone(String type) {
    	if(type=="dist") {
    		if()
    	}
    }
   */ 
    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

