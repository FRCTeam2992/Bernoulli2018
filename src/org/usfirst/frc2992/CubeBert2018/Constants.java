package org.usfirst.frc2992.CubeBert2018;

public class Constants {
	public final double switchHeight = 22;//in inches
	public final double midScaleHeight = 66;//in inches
	public final double topScaleHeight = midScaleHeight+12;
	public final double climbHeight = 0;
	public final double autoCrossLineDist = 209;//only for L/R positions 
	public static final double driveDistPerPulse = (8* 3.14 * 20) / (128 * 64 * 3);// diameter[6] * PI[3.14]  / PPR[128] / Gear Box constant[3] / Gear Ratio[64:20] -- inches
}
