package org.usfirst.frc2992.CubeBert2018.commands;

import org.usfirst.frc2992.CubeBert2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Auto2CubeRScale extends CommandGroup {

    public Auto2CubeRScale() {
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
    	
    	addSequential(new AutoRtoRScale());//loads 2nd cube
    	//next lines for 2nd cube
    	addSequential(new AutoDriveFwd(-30, 0.5, 3, true, -135));
    	addParallel(new intakeStop());
    	addParallel(new liftHeight(35.5, 3.5));
    	addSequential(new AutoDriveTurn(0, 0.3, 3));
    	addSequential(new AutoDriveFwd(10, 0.3, 3, true, 0));
    	addParallel(new intakeOut(1));
    	addSequential(new WaitCommand(1));
    	addParallel(new intakeStop());
    }
}
