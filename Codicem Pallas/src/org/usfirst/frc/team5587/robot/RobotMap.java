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
	public static int LEFT_FRONT_MOTOR = 0;
	public static int LEFT_REAR_MOTOR = 1;
	public static int RIGHT_FRONT_MOTOR = 2;
	public static int RIGHT_REAR_MOTOR = 3;
	
	//Shooting mechanism
	public static int LEFT_SHOOTER_WHEEL = 4;
	public static int RIGHT_SHOOTER_WHEEL = 5;
	public static int LOADING_SERVO = 8;
	
    //Aiming mechanism
	public static int AIMING_MOTOR = 7;
	public static int ENCODER_A = 0;
	public static int ENCODER_B = 1;
	
	//Joysticks
	public static int DRIVER = 0;
	public static int CODRIVER = 1;
	
	//Buttons
	public static int FIRE = 1; //Begins sequence of actually shooting a boulder
	public static int PRIME = 2;
	public static int AIM = 3;
	public static int SWEEP_IN = 4; //Spins the wheels inward to collect a boulder
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}