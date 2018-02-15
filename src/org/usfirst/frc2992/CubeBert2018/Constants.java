package org.usfirst.frc2992.CubeBert2018;

public class Constants {
	public final double switchHeight = 22/2;//in inches. /2 bc actual height is half since 2 stages away 
	public final double midScaleHeight = 66/2;//in inches
	public final double topScaleHeight = midScaleHeight+12;
	public final double climbHeight = 0;
	public final double autoCrossLineDist = 209;//only for L/R positions 
	
	
	public static final double driveEncDistPerPulse = (8* 3.14 * 20) / (128 * 64 * 3);// diameter[6] * PI[3.14]  / PPR[128] / Gear Box constant[3] / Gear Ratio[64:20] -- inches
	public static final int LiftEncCountsPerRev = 1024;//1024 encoder clicks per rev of the encoder
    public static final int LiftGearBoxRatio = 1;//1 rev of encoder per rev of the pulley
    public static final double LiftPulleyCirc = 1.125 * Math.PI;
    
    public static final double liftUpPower = 0.5;
    public static final double liftDownPower = -0.2;//maybe -.15
}
