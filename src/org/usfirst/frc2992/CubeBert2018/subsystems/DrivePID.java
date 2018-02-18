package org.usfirst.frc2992.CubeBert2018.subsystems;


import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;

public class DrivePID implements PIDOutput {
	private ArrayList<WPI_TalonSRX> mDrive;

	public DrivePID (ArrayList<WPI_TalonSRX> motors) {

		mDrive = motors;
	}
	@Override
	public void pidWrite(double output) {
		for (WPI_TalonSRX m : mDrive) {

			m.set(output);
		}
	}
}