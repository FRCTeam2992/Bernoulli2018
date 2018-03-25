
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

import org.usfirst.frc2992.CubeBert2018.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc2992.CubeBert2018.mhJoystick;
import org.usfirst.frc2992.CubeBert2018.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  
    public JoystickButton intakeFeedInBtn;
    public JoystickButton intakeFeedOutBtn;
    public JoystickButton intakeDeployBtn;
    public JoystickButton intakeArmOpenBtn;
    public JoystickButton intakeArmsClosed;
    
    public JoystickButton liftCubeUpBtn;
    public JoystickButton liftCubeDownBtn;
    public JoystickButton groundLevelBtn;
    public JoystickButton rampDeployBtn;
    public JoystickButton newRevClimbBtn;
    public JoystickButton tensionClimbBtn;//lifts to climbing height
    
    public JoystickButton smallClimbSpeedBtn;
    public JoystickButton bigClimbSpeedBtn;
    public JoystickButton scaleClampBtn;
    public JoystickButton climbMasterEnableBtn;//deploy both ramps
 
    public JoystickButton autoA;
    public JoystickButton autoB;
    public JoystickButton autoC;
    public JoystickButton autoD;
    
    //on the left joy
    public JoystickButton outTakeJoy;
    public JoystickButton openIntakeJoy;
    public JoystickButton closeIntakeJoy;
    public JoystickButton liftDownJoy;
    public JoystickButton liftUpJoy;
    
    public Joystick buttonBox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public mhJoystick rightJoy;
    public mhJoystick leftJoy;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    	rightJoy = new mhJoystick(0);
    	leftJoy = new mhJoystick(1);
        buttonBox = new Joystick(2);
        
        outTakeJoy = new JoystickButton(leftJoy,3);
        outTakeJoy.whileHeld(new intakeOut(1.0));
        outTakeJoy.whenReleased(new intakeStop());
        
        openIntakeJoy= new JoystickButton(leftJoy,4);
        openIntakeJoy.whenPressed(new intakeArmsOpen(true));
        
        closeIntakeJoy = new JoystickButton(leftJoy, 1);
        closeIntakeJoy.whenPressed(new intakeArmsOpen(false));
        
        liftDownJoy = new JoystickButton(rightJoy, 4);
        liftDownJoy.whileHeld(new liftDown(Robot.constants.liftDownPower));
        liftDownJoy.whenReleased(new liftStop());
        
        liftUpJoy = new JoystickButton(rightJoy, 3);
        liftUpJoy.whileHeld(new liftUp(Robot.constants.liftUpPower));
        liftUpJoy.whenReleased(new liftStop());
        
        intakeFeedInBtn = new JoystickButton(buttonBox, 1);
        intakeFeedInBtn.whileHeld(new intakeIn(0.9));//whileHeld in case commands get out of order (race condition)
        intakeFeedInBtn.whenReleased(new intakeStop());
        
        intakeFeedOutBtn = new JoystickButton(buttonBox, 2);
        intakeFeedOutBtn.whileHeld(new intakeOut(1.0));
        intakeFeedOutBtn.whenReleased(new intakeStop());
        
        intakeDeployBtn = new JoystickButton(buttonBox, 3);
        intakeDeployBtn.whenPressed(new intakeDeployed(false));
        intakeDeployBtn.whenReleased(new intakeDeployed(true));
        
        intakeArmOpenBtn = new JoystickButton(buttonBox, 4);
        intakeArmOpenBtn.whenPressed(new intakeArmsOpen(true));
        
        intakeArmsClosed = new JoystickButton(buttonBox, 5);
        intakeArmsClosed.whenPressed(new intakeArmsOpen(false));
        
        liftCubeUpBtn = new JoystickButton(buttonBox, 6);
        liftCubeUpBtn.whileHeld(new liftUp(Robot.constants.liftUpPower));
        liftCubeUpBtn.whenReleased(new liftStop());
      
        liftCubeDownBtn = new JoystickButton(buttonBox, 7);
        liftCubeDownBtn.whileHeld(new liftDown(Robot.constants.liftDownPower));
        liftCubeDownBtn.whenReleased(new liftStop());
        
        groundLevelBtn = new JoystickButton(buttonBox, 8);
       groundLevelBtn.whenPressed(new liftHeight(0.0, 4.0));
        
        
        rampDeployBtn = new JoystickButton(buttonBox, 9);
        rampDeployBtn.whenPressed(new rampDeploy(true));
        
        newRevClimbBtn = new JoystickButton(buttonBox, 10);
        //the dist is how high the first stage of the lift is gonna go-actually twice the height bc 2 stages away
        //newRevClimbBtn.whenPressed(new liftHeight(Robot.constants.midScaleHeight, 4.0));
        newRevClimbBtn.whileHeld(new climbStart(-0.6));
        newRevClimbBtn.whenReleased(new climbStop());

        
        tensionClimbBtn = new JoystickButton(buttonBox, 11);
        //climbingPosBtn.whenPressed(new liftHeight(Robot.constants.climbHeight, 4.0));//liftHeight(dist,time) 
        tensionClimbBtn.whileHeld(new climbStart(0.9));
        tensionClimbBtn.whenReleased(new climbStop());
        
        smallClimbSpeedBtn = new JoystickButton(buttonBox, 12);//change to replace limit switch - in case breaks
        //smallClimbSpeedBtn.whenPressed(new climbStart(1.0));
        //smallClimbSpeedBtn.whenReleased(new climbStop());
        
        bigClimbSpeedBtn = new JoystickButton(buttonBox, 13);
        bigClimbSpeedBtn.whenPressed(new climbStart(0.6));
        bigClimbSpeedBtn.whenReleased(new climbStop());
        
        //scaleClampBtn = new JoystickButton(buttonBox, 14); no longer needed
        //scaleClampBtn.whenPressed(new ScaleClampDeploy(true));
        
        climbMasterEnableBtn = new JoystickButton(buttonBox,15);
        
        autoA = new JoystickButton(buttonBox, 16);
        
        autoB = new JoystickButton(buttonBox, 17);
        
        autoC = new JoystickButton(buttonBox, 18);
        
        autoD = new JoystickButton(buttonBox, 19);

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("driveSticks", new driveSticks());
        SmartDashboard.putData("intakeIn", new intakeIn(0.5));
        SmartDashboard.putData("intakeStop", new intakeStop());
        SmartDashboard.putData("intakeOut", new intakeOut(0.5));
        SmartDashboard.putData("liftUp 0.2", new liftUp(0.2));
        SmartDashboard.putData("liftUp 0.35", new liftUp(0.35));
        SmartDashboard.putData("liftUp 0.5", new liftUp(0.5));
        SmartDashboard.putData("liftDown 0.2", new liftDown(-0.2));
        SmartDashboard.putData("liftDown 0.5", new liftDown(-0.5));
        SmartDashboard.putData("liftDown 0.75", new liftDown(-0.75));
        SmartDashboard.putData("liftDown 1.0", new liftDown(-1.0));
        SmartDashboard.putData("liftStop", new liftStop());
        SmartDashboard.putData("climbStart 0.3", new climbStart(0.3));
        SmartDashboard.putData("climbStart 0.5", new climbStart(0.5));
        SmartDashboard.putData("climbStart 0.8", new climbStart(0.8));
        SmartDashboard.putData("climbStart 1.0", new climbStart(1.0));
        SmartDashboard.putData("climbDown 0.2", new climbStart(-0.2));
        


        SmartDashboard.putData("climbStop", new climbStop());
        SmartDashboard.putData("intakeDeployed", new intakeDeployed(false));
        SmartDashboard.putData("intakeArmsOpen", new intakeArmsOpen(false));
        SmartDashboard.putData("driveAutoFwd", new AutoDriveFwd(25.0,1.0,3.0,false,0.5));
        SmartDashboard.putData("driveAutoTurn", new AutoDriveTurn(0.5,0.5,0.5));
        SmartDashboard.putData("scaleClampDeploy", new ScaleClampDeploy(false));
        SmartDashboard.putData("liftHeight 0", new liftHeight(0.0, 4.0));
        SmartDashboard.putData("autoHighGear", new autoHighGear(false));
        SmartDashboard.putData("autoDrive24in", new AutoDriveFwd(24, 0.8, 5, true, 0));
        SmartDashboard.putData("autoDriveTurn90", new AutoDriveTurn(90, 0.8, 5));
        SmartDashboard.putData("liftToScaleHeight 33", new liftHeight(Robot.constants.midScaleHeight, 4.0));
        SmartDashboard.putData("liftToSwitchHeight 11", new liftHeight(Robot.constants.switchHeight, 4.0));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        
    }

    public mhJoystick getrightJoy() {
        return rightJoy;
    }

    public mhJoystick getleftJoy() {
        return leftJoy;
    }
    
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    public Joystick getbuttonBox() {
        return buttonBox;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}


