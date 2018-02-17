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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2992.CubeBert2018.commands.*;
import org.usfirst.frc2992.CubeBert2018.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    public static String autoName;
    public static int autoCommandNum;
    public static String gameData = "   ";// need blank string so can "read" something when called
    public static String autoPath = "Do Nothing";// to send command group info to smartDashboard

    
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static LiftClimber liftClimber;
    public static Constants constants;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        SmartDashboard.putData(driveTrain);
        intake = new Intake();
        SmartDashboard.putData(intake);
        liftClimber = new LiftClimber();
        SmartDashboard.putData(liftClimber);
        constants = new Constants();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addDefault("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	setAutoMode();
        Scheduler.getInstance().run();
        dashupdate();
    }

    @Override
    public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		RobotMap.navx.zeroYaw();//this is to make the gyro yaw==0;
				
		setAutoMode();	// Read switches and do final setting for auto program
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dashupdate();
    }
    public void setAutoMode() {
    	
    	//so can change the auto command with the buttons on btnBox.
    	//I got the numbers from binary: 2^0, 2^1, 2^2, 2^3, etc
    	//not else if so can trigger 2+ btns at once for dif command
    	int autoMode = 0;
    	if(Robot.oi.autoA.get()) {
    		autoMode +=1;
    	}
    	if(Robot.oi.autoB.get()) {
    		autoMode += 2;
    	}
    	if(Robot.oi.autoC.get()) {
    		autoMode+=4;
    	}
    	if(Robot.oi.autoD.get()) {
    		autoMode+=8;
    	}

    	autoCommandNum = autoMode;
    	
    	switch(autoMode) {
    	
    	case 0: autonomousCommand = new AutoDriveStop(); 
    			autoName = "Do Nothing";
    			break; 
    			
    	case 1: autonomousCommand = new AutoDriveFwd(constants.autoCrossLineDist,0.5,10,false,0);
    			autoName = "Go Forward - Never in Center!!";
    			autoPath = "AutoDriveFwd";
    			break;
    			
    	case 2: autonomousCommand = new AutoCenterSwitch();
    			autoName = "Center, switch";
    			break;
    	
    	case 3: autonomousCommand = new AutoLSwitchOnly();
    			autoName = "Left, switch only";
    			break;
    			
    	case 4: autonomousCommand = new AutoLCloseScaleOnly();
    			autoName = "Left, Left scale only";
    			break;
    			
    	case 5: autonomousCommand = new AutoLAnyScale();
    			autoName = "Left, Any scale";
    			break;
    	
    	case 6: autonomousCommand = new AutoLSwitchCloseScale();
    			autoName = "Left, Left switch or scale";
    			break;
    			
    	case 7: autonomousCommand = new AutoLSwitchAnyScale();
    			autoName = "Left, Left switch or any scale";
    			break;
    			
    	case 8: autonomousCommand = new AutoLCloseScaleSwitch();
    			autoName = "Left, Left scale or switch";
    			break;
    			
    	case 9: autonomousCommand = new AutoRSwitchOnly();
    			autoName = "Right, Right switch only";
    			break;

    	case 10: autonomousCommand = new AutoRCloseScaleOnly();
				autoName = "Right, Right scale only";
				break;
				
    	case 11: autonomousCommand = new AutoRAnyScale();
				autoName = "Right, Any scale";
				break;
				
    	case 12: autonomousCommand = new AutoRSwitchCloseScale();
				autoName = "Right, Right switch or scale";
				break;

    	case 13: autonomousCommand = new AutoRSwitchAnyScale();
				autoName = "Right, Right switch or any scale";
				break;

    	case 14: autonomousCommand = new AutoRCloseScaleSwitch();
				autoName = "Right, Right scale or switch";
				break;

    	//set default so if num created is not specified - do default		
    	default: autonomousCommand = new AutoDriveStop(); 
				autoName = "Do Nothing";
				break;
    	}
    }
    
    void dashupdate() {
        SmartDashboard.putString("Auto Name", autoName);
        SmartDashboard.putNumber("Auto Number", autoCommandNum);
    	SmartDashboard.putString("AutoPath", autoPath);
    	
  		SmartDashboard.putNumber("Gyro Angle", RobotMap.navx.getYaw());
  		SmartDashboard.putNumber("Gyro Pitch", RobotMap.navx.getPitch());
  		SmartDashboard.putNumber("Gyro Roll", RobotMap.navx.getRoll());
  		
  		SmartDashboard.putNumber("Lift Encoder", RobotMap.liftClimberliftEnc.getDistance());
  		SmartDashboard.putBoolean("Top Limit Switches", RobotMap.liftClimberliftTopSensor.get());
  		SmartDashboard.putBoolean("Bottom Limit Switch", RobotMap.liftClimberliftBottomSensor.get());
    }
    
    
}
