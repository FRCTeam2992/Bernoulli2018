// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.CubeBert2018;

import java.util.ArrayList;

import org.usfirst.frc2992.CubeBert2018.Robot.whichBot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {


	public static Robot.whichBot botState = Robot.botState; 


	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	//public static WPI_TalonSRX driveTrainrFDriveMotor;
	public static WPI_TalonSRX driveTrainrBDriveMotor;
	public static WPI_TalonSRX driveTrainrMDriveMotor;
	//public static WPI_TalonSRX driveTrainlFDriveMotor;
	public static WPI_TalonSRX driveTrainlMDriveMotor;
	public static WPI_TalonSRX driveTrainlBDriveMotor;
	public static Solenoid driveTraindriveTrainSolenoid;
	public static Encoder driveTrainrightDriveEnc;
	public static Encoder driveTrainleftDriveEnc;

	public static ArrayList<WPI_TalonSRX>leftmotors;
	public static ArrayList<WPI_TalonSRX>rightmotors;
	public static ArrayList<WPI_TalonSRX>allmotors;

	public static SpeedController intakeleftIntakeMotor;
	public static SpeedController intakerightIntakeMotor;
	public static DigitalInput intakeleftIntakeSensor;
	public static DigitalInput intakerightIntakeSensor;
	public static Solenoid intakeintakeArmsSol;
	public static Solenoid intakeintakeDeploySol;

	public static SpeedController liftClimberliftMotor;
	public static SpeedController liftClimberclimbMotor1;
	public static SpeedController liftClimberclimbMotor2;
	public static DigitalInput liftClimberliftBottomSensor;
	public static DigitalInput liftClimberliftTopSensor;
	public static Encoder liftClimberliftEnc;
	public static PIDController liftPID;
	public static Solenoid liftClimberrampLatchSol;
	public static Solenoid liftClimberrampDeploySol;
	public static Solenoid liftClimberScaleClampSol;
	public static Solenoid liftClimberleftScaleClampSol;
	public static Servo rampDeployServo;
	public static Relay rampDeployRelay;
	public static Solenoid rampDeploySol;
	public static AHRS navx;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
    public static final double driveEncDistPerPulse = Robot.constants.driveEncDistPerPulse;
	public static final int LiftEncCountsPerRev = Robot.constants.LiftEncCountsPerRev;
    public static final int LiftGearBoxRatio = Robot.constants.LiftGearBoxRatio;
    public static final double LiftPulleyCirc = Robot.constants.LiftPulleyCirc;
    
    public static double adjustment = 0;
    
    public static void init() {

    	if(!(botState == whichBot.firstBot)) {//changed so comp motors with Team b controllers
    		/*
            driveTrainrFDriveMotor = new WPI_TalonSRX(1);
            driveTrainrFDriveMotor.setNeutralMode(NeutralMode.Coast);
    		 */
    		driveTrainrBDriveMotor = new WPI_TalonSRX(3);
    		driveTrainrBDriveMotor.setNeutralMode(NeutralMode.Coast);
    		driveTrainrBDriveMotor.setSubsystem("DriveTrain");

    		driveTrainrMDriveMotor = new WPI_TalonSRX(2);
    		driveTrainrMDriveMotor.setNeutralMode(NeutralMode.Coast);
    		/*
            driveTrainlFDriveMotor = new WPI_TalonSRX(4);
            driveTrainlFDriveMotor.setNeutralMode(NeutralMode.Coast);
    		 */
    		driveTrainlMDriveMotor = new WPI_TalonSRX(5);
    		driveTrainlMDriveMotor.setNeutralMode(NeutralMode.Coast);

    		driveTrainlBDriveMotor = new WPI_TalonSRX(6);
    		driveTrainlBDriveMotor.setNeutralMode(NeutralMode.Coast);
    		driveTrainlBDriveMotor.setSubsystem("DriveTrain");

    		intakeleftIntakeMotor = new WPI_VictorSPX(6);
    		((WPI_VictorSPX) intakeleftIntakeMotor).setSubsystem("Intake");
    		((WPI_VictorSPX) intakeleftIntakeMotor).setName("leftIntakeMotor");
    		LiveWindow.add((Sendable) intakeleftIntakeMotor);
    		intakeleftIntakeMotor.setInverted(false);

    		intakerightIntakeMotor = new WPI_VictorSPX(5);
    		((WPI_VictorSPX) intakerightIntakeMotor).setSubsystem("Intake");
    		((WPI_VictorSPX) intakerightIntakeMotor).setName("rightIntakeMotor");
    		LiveWindow.add((Sendable) intakerightIntakeMotor);
    		intakerightIntakeMotor.setInverted(true);

    		liftClimberliftMotor = new WPI_VictorSPX(1);
    		//in next line is a cast - says although SpeedController treat the motor like a 
    		//BaseMotorController or WPI_VictorSPX bc is one (if not one - then crashes)
    		((BaseMotorController) liftClimberliftMotor).setNeutralMode(NeutralMode.Brake);
    		((WPI_VictorSPX) liftClimberliftMotor).setSubsystem("Lift");
    		((WPI_VictorSPX) liftClimberliftMotor).setName("Lift Motor");
    		LiveWindow.add((Sendable) liftClimberliftMotor);
    		
    		liftClimberclimbMotor1 = new WPI_VictorSPX(4);
    		((WPI_VictorSPX) liftClimberclimbMotor1).setSubsystem("LiftClimber");
    		((WPI_VictorSPX) liftClimberclimbMotor1).setName("Climb motor 1");

    		liftClimberclimbMotor2 = new WPI_VictorSPX(3);
    		((WPI_VictorSPX) liftClimberclimbMotor2).setSubsystem("LiftClimber");
    		((WPI_VictorSPX) liftClimberclimbMotor2).setName("Climb motor 2");
    		LiveWindow.add((Sendable) liftClimberclimbMotor1);
    		LiveWindow.add((Sendable) liftClimberclimbMotor2);
    		liftClimberclimbMotor1.setInverted(true);
    		liftClimberclimbMotor2.setInverted(false);
    		((BaseMotorController) liftClimberclimbMotor1).setNeutralMode(NeutralMode.Brake);
    		((BaseMotorController) liftClimberclimbMotor2).setNeutralMode(NeutralMode.Brake);
    	}
    	
    	else if(!(botState == whichBot.secondBot)) {//changed so new motors with old controllers
    		driveTrainrBDriveMotor = new WPI_TalonSRX(2);
    		driveTrainrBDriveMotor.setNeutralMode(NeutralMode.Coast);
    		
    		driveTrainrMDriveMotor = new WPI_TalonSRX(3);
    		driveTrainrMDriveMotor.setNeutralMode(NeutralMode.Coast);
    		
    		driveTrainlMDriveMotor = new WPI_TalonSRX(5);
    		driveTrainlMDriveMotor.setNeutralMode(NeutralMode.Coast);
    		
    		driveTrainlBDriveMotor = new WPI_TalonSRX(6);
    		driveTrainlBDriveMotor.setNeutralMode(NeutralMode.Coast);
    		
    		intakerightIntakeMotor = new VictorSP(0);
    		
    		intakeleftIntakeMotor = new VictorSP(1);
    		intakeleftIntakeMotor.setInverted(true);
    		
    		liftClimberclimbMotor1 = new VictorSP(2);
    		liftClimberclimbMotor2 = new VictorSP(3);
    		
    		liftClimberliftMotor = new WPI_TalonSRX(4);
    		
    	}
    	
    	leftmotors = new ArrayList<WPI_TalonSRX>();
		rightmotors = new ArrayList<WPI_TalonSRX>();
		allmotors = new ArrayList<WPI_TalonSRX>();

    	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	driveTraindriveTrainSolenoid = new Solenoid(0, 0);//(device #, port #)
    	driveTraindriveTrainSolenoid.setSubsystem("DriveTrain");
    	driveTraindriveTrainSolenoid.setName("driveTrainSol");
    	LiveWindow.add(driveTraindriveTrainSolenoid);


    	driveTrainrightDriveEnc = new Encoder(0, 1, false, EncodingType.k4X);
    	driveTrainrightDriveEnc.setSubsystem("DriveTrain");
    	driveTrainrightDriveEnc.setName("driveTrainRightEnc");
    	LiveWindow.add(driveTrainrightDriveEnc);
    	driveTrainrightDriveEnc.setDistancePerPulse(driveEncDistPerPulse);
    	driveTrainrightDriveEnc.setPIDSourceType(PIDSourceType.kDisplacement);

    	driveTrainleftDriveEnc = new Encoder(2, 3, false, EncodingType.k4X);
    	driveTrainleftDriveEnc.setSubsystem("DriveTrain");
    	driveTrainleftDriveEnc.setName("driveTrainLeftEnc");
    	LiveWindow.add(driveTrainleftDriveEnc);
    	driveTrainleftDriveEnc.setDistancePerPulse(driveEncDistPerPulse);
    	driveTrainleftDriveEnc.setPIDSourceType(PIDSourceType.kDisplacement);

    	intakeleftIntakeSensor = new DigitalInput(6);
    	intakeleftIntakeSensor.setSubsystem("Intake");
    	intakeleftIntakeSensor.setName("leftIntakeSensor");
    	LiveWindow.add(intakeleftIntakeSensor);

    	intakerightIntakeSensor = new DigitalInput(7);
    	intakerightIntakeSensor.setSubsystem("Intake");
    	intakerightIntakeSensor.setName("rightIntakeSensor"); 
    	LiveWindow.add(intakerightIntakeSensor);

    	intakeintakeArmsSol = new Solenoid(0, 1);
    	intakeintakeArmsSol.setSubsystem("Intake");
    	intakeintakeArmsSol.setName("intakeArmSol");
    	LiveWindow.add(intakeintakeArmsSol);

    	intakeintakeDeploySol = new Solenoid(0, 2);
    	intakeintakeDeploySol.setSubsystem("Intake");
    	intakeintakeDeploySol.setName("intakeDeploySol");
    	LiveWindow.add(intakeintakeDeploySol);

    	liftClimberliftBottomSensor = new DigitalInput(8);
    	liftClimberliftBottomSensor.setSubsystem("LiftClimber");
    	liftClimberliftBottomSensor.setName("bottomLiftSensor");
    	LiveWindow.add(liftClimberliftBottomSensor);

    	liftClimberliftTopSensor = new DigitalInput(9);
    	liftClimberliftTopSensor.setSubsystem("LiftClimber");
    	liftClimberliftTopSensor.setName("topLiftSensor");
    	LiveWindow.add(liftClimberliftTopSensor);

    	liftClimberliftEnc = new Encoder(4, 5, false, EncodingType.k4X);
    	liftClimberliftEnc.setSubsystem("LiftClimber");
    	liftClimberliftEnc.setName("liftEnc");
    	LiveWindow.add(liftClimberliftEnc); 

    	// Encoder is geared 20:1 onto a 1.125 inch shaft -- 1024 pulses per revolution encoder
    	//in inches.  finding dist of string per click
    	liftClimberliftEnc.setDistancePerPulse(LiftPulleyCirc / (LiftGearBoxRatio * LiftEncCountsPerRev));
    	liftClimberliftEnc.setPIDSourceType(PIDSourceType.kDisplacement);

    	// PID Controller for cube lift
    	liftPID = new PIDController(0.6, 0, 0.02, liftClimberliftEnc, liftClimberliftMotor);
    	liftPID.setAbsoluteTolerance(1.5);		// Inches which is the output of scaled encoder
    	LiveWindow.add(liftPID);

    	//liftClimberrampLatchSol = new Solenoid(0, 4);
    	//liftClimberrampLatchSol.setSubsystem("LiftClimber");
    	//liftClimberrampLatchSol.setName("rampLatchSol");
    	//LiveWindow.add(liftClimberrampLatchSol);

    	//liftClimberrampDeploySol = new Solenoid(0, 5);
    	//liftClimberrampDeploySol.setSubsystem("LiftClimber");
    	//liftClimberrampDeploySol.setName("rampDeploySol");
    	//LiveWindow.add(liftClimberrampDeploySol);


    	//liftClimberScaleClampSol = new Solenoid(0, 3);
    	//liftClimberScaleClampSol.setSubsystem("LiftCLimber");
    	//liftClimberScaleClampSol.setName("scaleClampSol");
    	//LiveWindow.add(liftClimberScaleClampSol);

    	rampDeployServo = new Servo(8);
    	rampDeployServo.setSubsystem("LiftClimber");
    	rampDeployServo.setName("rampDeployServo");
    	LiveWindow.add(rampDeployServo);

    	rampDeployRelay = new Relay(0);
    	rampDeployRelay.setSubsystem("LiftClimber");
    	rampDeployRelay.setName("Ramp Deploy Relay");
    	LiveWindow.add(rampDeployRelay);

    	rampDeploySol = new Solenoid(0,3);
    	rampDeploySol.setSubsystem("LiftClimber");
    	rampDeploySol.setName("rampDeploySolenoid");
    	LiveWindow.add(rampDeploySol);
    	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    	navx = new AHRS(SPI.Port.kMXP);
    	navx.setSubsystem("DriveTrain");
    	navx.setName("Gyro");
    	LiveWindow.add(navx);

    	navx.reset();
    	navx.resetDisplacement();
    	navx.setAngleAdjustment(adjustment);
    	navx.zeroYaw();

        //LiveWindow.add(driveTrainrFDriveMotor);
        LiveWindow.add(driveTrainrBDriveMotor);
        LiveWindow.add(driveTrainrMDriveMotor);
        //LiveWindow.add(driveTrainlFDriveMotor);
        LiveWindow.add(driveTrainlMDriveMotor);
        LiveWindow.add(driveTrainlBDriveMotor);
        
        //invert the motors in robotmap to avoid confusion later
        //driveTrainlFDriveMotor.setInverted(true);
        driveTrainlMDriveMotor.setInverted(true);
        driveTrainlBDriveMotor.setInverted(true);
        
        //puts drive motors in an array (a list) for pid
        //leftmotors.add(driveTrainlFDriveMotor);
        leftmotors.add(driveTrainlMDriveMotor);
        leftmotors.add(driveTrainlBDriveMotor);
        //rightmotors.add(driveTrainrFDriveMotor);
        rightmotors.add(driveTrainrMDriveMotor);
        rightmotors.add(driveTrainrBDriveMotor);
        allmotors.addAll(leftmotors);
        allmotors.addAll(rightmotors);
    }
}
