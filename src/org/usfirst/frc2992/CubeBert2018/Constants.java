package org.usfirst.frc2992.CubeBert2018;

public class Constants {
	public final double switchHeight = 22/2;//in inches. /2 bc actual height is half since 2 stages away 
	public final double midScaleHeight = 62/2;//in inches
	public final double topScaleHeight = midScaleHeight;
	public final double climbHeight = 23;
	public final double autoCrossLineDist = 209;//only for L/R positions 
	
	
	public static final double driveEncDistPerPulse = (8* 3.14 * 20) / (128 * 64 * 3);// diameter[6] * PI[3.14]  / PPR[128] / Gear Box constant[3] / Gear Ratio[64:20] -- inches
	public static final int LiftEncCountsPerRev = 1024;//1024 encoder clicks per rev of the encoder
    public static final int LiftGearBoxRatio = 1;//1 rev of encoder per rev of the pulley
    public static final double LiftPulleyCirc = 1.1* 0.5 * Math.PI;
    
    public static final double liftUpPower = 1.0;
    public static final double liftDownPower = -0.7;//maybe -.15
    
    public static final double rampServoDeploy = 0.5;
    public static final double rampServoNotDeploy = 0.95;
    
    
    public static final boolean liftEncoder = true;	// Do we have lift encoder?
    public static final double liftTime = 2.7;		// Seconds to do full lift
    public static final double liftMax = 82/2;		// Inches bottom to max stage 2 ift
    
}
