package org.usfirst.frc.team5587.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//Drive Train motors
	public static int LEFT_FRONT_MOTOR = 9;
	public static int LEFT_REAR_MOTOR = 9;
	public static int RIGHT_FRONT_MOTOR = 9;
	public static int RIGHT_REAR_MOTOR = 9;
	
	//Shooting mechanism
	public static int LEFT_SHOOTER_WHEEL = 9;
	public static int RIGHT_SHOOTER_WHEEL = 9;
	public static int LOADING_SERVO = 9;
	public static int TOP_LIMIT = 9;
	public static int BOTTOM_LIMIT = 9;
	
    //Aiming mechanism
	public static int AIMING_MOTOR = 9;
	public static int ENCODER_A = 9;
	public static int ENCODER_B = 9;
	
	public static int LIGHT = 9;
	
	//Joysticks
	public static int DRIVER = 9;
	public static int CODRIVER = 9;
	
	//Buttons
	public static int FIRE = 9; //Begins sequence of actually shooting a boulder
	public static int PRIME = 9;
	public static int SWEEP_IN = 9; //Spins the wheels inward to collect a boulder
	public static int UP = 9;
	public static int DOWN = 9;
	public static int BLIND = 9;
	
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}