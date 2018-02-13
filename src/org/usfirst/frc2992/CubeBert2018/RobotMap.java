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

import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
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
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Solenoid driveTraindriveTrainSolenoid;
    public static WPI_TalonSRX driveTrainrFDriveMotor;
    public static WPI_TalonSRX driveTrainrBDriveMotor;
    public static WPI_TalonSRX driveTrainrMDriveMotor;
    public static WPI_TalonSRX driveTrainlFDriveMotor;
    public static WPI_TalonSRX driveTrainlMDriveMotor;
    public static WPI_TalonSRX driveTrainlBDriveMotor;
    public static ArrayList<SpeedController>leftmotors;
    public static ArrayList<SpeedController>rightmotors;
    public static Encoder driveTrainrightDriveEnc;
    public static Encoder driveTrainleftDriveEnc;
    
    public static WPI_VictorSPX intakeleftIntakeMotor;
    public static WPI_VictorSPX intakerightIntakeMotor;
    public static DigitalInput intakeleftIntakeSensor;
    public static DigitalInput intakerightIntakeSensor;
    public static Solenoid intakeintakeArmsSol;
    public static Solenoid intakeintakeDeploySol;
    
    public static WPI_TalonSRX liftClimberliftMotor;
    public static DigitalInput liftClimberliftBottomSensor;
    public static DigitalInput liftClimberliftTopSensor;
    public static Encoder liftClimberliftEnc;
    public static PIDController liftPID;
    public static WPI_TalonSRX liftClimberclimbMotor1;
    public static WPI_TalonSRX liftClimberclimbMotor2;
    public static Solenoid liftClimberrampLatchSol;
    public static Solenoid liftClimberrampDeploySol;
    public static Solenoid liftClimberScaleClampSol;
    public static Solenoid liftClimberleftScaleClampSol;
    
    public static AHRS navx;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    public static final double driveEncDistPerPulse = Robot.constants.driveEncDistPerPulse;
	public static final int LiftEncCountsPerRev = Robot.constants.LiftEncCountsPerRev;
    public static final int LiftGearBoxRatio = Robot.constants.LiftGearBoxRatio;
    public static final double LiftPulleyCirc = Robot.constants.LiftPulleyCirc;
    
    public static double adjustment = 0;
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTraindriveTrainSolenoid = new Solenoid(0, 0);//(device #, port #)
        driveTraindriveTrainSolenoid.setSubsystem("DriveTrain");
        driveTraindriveTrainSolenoid.setName("driveTrainSol");
        LiveWindow.add(driveTraindriveTrainSolenoid);
        
        driveTrainrFDriveMotor = new WPI_TalonSRX(1);
        driveTrainrFDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainrBDriveMotor = new WPI_TalonSRX(3);
        driveTrainrBDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainrMDriveMotor = new WPI_TalonSRX(2);
        driveTrainrMDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainlFDriveMotor = new WPI_TalonSRX(4);
        driveTrainlFDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainlMDriveMotor = new WPI_TalonSRX(5);
        driveTrainlMDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainlBDriveMotor = new WPI_TalonSRX(6);
        driveTrainlBDriveMotor.setNeutralMode(NeutralMode.Coast);
        
        driveTrainrightDriveEnc = new Encoder(0, 1, false, EncodingType.k4X);
        driveTrainrightDriveEnc.setSubsystem("DriveTrain");
        driveTrainrightDriveEnc.setName("driveTrainRightEnc");
        LiveWindow.add(driveTrainrightDriveEnc);
        driveTrainrightDriveEnc.setDistancePerPulse(driveEncDistPerPulse);
        driveTrainrightDriveEnc.setPIDSourceType(PIDSourceType.kRate);
       
        driveTrainleftDriveEnc = new Encoder(2, 3, false, EncodingType.k4X);
        driveTrainleftDriveEnc.setSubsystem("DriveTrain");
        driveTrainleftDriveEnc.setName("driveTrainLeftEnc");
        LiveWindow.add(driveTrainleftDriveEnc);
        driveTrainleftDriveEnc.setDistancePerPulse(driveEncDistPerPulse);
        driveTrainleftDriveEnc.setPIDSourceType(PIDSourceType.kRate);
        
        intakeleftIntakeMotor = new WPI_VictorSPX(6);
        intakeleftIntakeMotor.setSubsystem("Intake");
        intakeleftIntakeMotor.setName("leftIntakeMotor");
        LiveWindow.add(intakeleftIntakeMotor);
        intakeleftIntakeMotor.setInverted(false);
        
        intakerightIntakeMotor = new WPI_VictorSPX(5);
        intakerightIntakeMotor.setSubsystem("Intake");
        intakerightIntakeMotor.setName("rightIntakeMotor");
        LiveWindow.add(intakerightIntakeMotor);
        intakerightIntakeMotor.setInverted(true);
              
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
        
        liftClimberliftMotor = new WPI_TalonSRX(7);
        liftClimberliftMotor.setNeutralMode(NeutralMode.Brake);
        liftClimberliftMotor.setSubsystem("Lift");
        liftClimberliftMotor.setName("Lift Motor");
        LiveWindow.add(liftClimberliftMotor);
        
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
        liftPID = new PIDController(0.01, 0, 0, liftClimberliftEnc, liftClimberliftMotor);
        liftPID.setAbsoluteTolerance(0.5);		// Inches which is the output of scaled encoder
        LiveWindow.add(liftPID);
        
        liftClimberclimbMotor1 = new WPI_TalonSRX(8);
        liftClimberclimbMotor1.setSubsystem("LiftClimber");
        liftClimberclimbMotor1.setName("Climb motor 1");
        liftClimberclimbMotor2 = new WPI_TalonSRX(9);
        liftClimberclimbMotor2.setSubsystem("LiftClimber");
        liftClimberclimbMotor2.setName("Climb motor 2");
        LiveWindow.add(liftClimberclimbMotor1);
        LiveWindow.add(liftClimberclimbMotor2);
        liftClimberclimbMotor1.setNeutralMode(NeutralMode.Brake);
        liftClimberclimbMotor2.setNeutralMode(NeutralMode.Brake);
        
        liftClimberrampLatchSol = new Solenoid(0, 4);
        liftClimberrampLatchSol.setSubsystem("LiftClimber");
        liftClimberrampLatchSol.setName("rampLatchSol");
        LiveWindow.add(liftClimberrampLatchSol);
        
        liftClimberrampDeploySol = new Solenoid(0, 5);
        liftClimberrampDeploySol.setSubsystem("LiftClimber");
        liftClimberrampDeploySol.setName("rampDeploySol");
        LiveWindow.add(liftClimberrampDeploySol);
        
        liftClimberScaleClampSol = new Solenoid(0, 3);
        liftClimberScaleClampSol.setSubsystem("LiftCLimber");
        liftClimberScaleClampSol.setName("scaleClampSol");
        LiveWindow.add(liftClimberScaleClampSol);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        navx = new AHRS(SPI.Port.kMXP);
        
        navx.reset();
    	navx.resetDisplacement();
    	navx.setAngleAdjustment(adjustment);
    	navx.zeroYaw();
        
        leftmotors = new ArrayList<SpeedController>();
    	rightmotors = new ArrayList<SpeedController>();
        
        LiveWindow.add(driveTrainrFDriveMotor);
        LiveWindow.add(driveTrainrBDriveMotor);
        LiveWindow.add(driveTrainrMDriveMotor);
        LiveWindow.add(driveTrainlFDriveMotor);
        LiveWindow.add(driveTrainlMDriveMotor);
        LiveWindow.add(driveTrainlBDriveMotor);
        
        //invert the motors in robotmap to avoid confusion later
        driveTrainlFDriveMotor.setInverted(true);
        driveTrainlMDriveMotor.setInverted(true);
        driveTrainlBDriveMotor.setInverted(true);
        
        //puts drive motors in an array (a list) for pid
        leftmotors.add(driveTrainlFDriveMotor);
        leftmotors.add(driveTrainlMDriveMotor);
        leftmotors.add(driveTrainlBDriveMotor);
        rightmotors.add(driveTrainrFDriveMotor);
        rightmotors.add(driveTrainrMDriveMotor);
        rightmotors.add(driveTrainrBDriveMotor);
    }
}
