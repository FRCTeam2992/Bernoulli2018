package org.usfirst.frc2992.CubeBert2018.subsystems;


import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RotatePID implements PIDOutput {
	private ArrayList<WPI_TalonSRX> lDrive;
	private ArrayList<WPI_TalonSRX> rDrive;
	
	
	public RotatePID (ArrayList<WPI_TalonSRX> lMotors, ArrayList<WPI_TalonSRX> rMotors) {
		lDrive = lMotors;
		rDrive = rMotors;
	}
	@Override
	public void pidWrite(double output) {
		for (WPI_TalonSRX m : lDrive) {
			m.set(output);
		}
		for(WPI_TalonSRX m : rDrive){

			m.set(-output);;
		}
	}
}