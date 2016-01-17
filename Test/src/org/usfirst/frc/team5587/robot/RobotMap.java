package org.usfirst.frc.team5587.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	//Drive Train
	public static int leftFrontWheel = 0;
	public static int leftRearWheel = 1;
	public static int rightFrontWheel = 2;
	public static int rightRearWheel = 3;
	
	//Shooter
	public static int leftShooter = 4;
	public static int rightShooter = 5;
	public static int aimMotor = 6;
	
    public static int joystickPort = 1;
    
    //Buttons
    public static int spinIn = 0;
    public static int shoot = 1;
    
    //Axes
    public static int throttle = 4; //For adjusting aim
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
