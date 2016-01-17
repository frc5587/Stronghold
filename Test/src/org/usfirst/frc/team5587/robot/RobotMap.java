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
	public static int LEFT_FRONT_WHEEL = 0;
	public static int LEFT_REAR_WHEEL = 1;
	public static int RIGHT_FRONT_WHEEL = 2;
	public static int RIGHT_REAR_WHEEL = 3;
	
	//Shooter
	public static int LEFT_SHOOTER = 4;
	public static int RIGHT_SHOOTER= 5;
	public static int AIM_MOTOR = 6;
	
    public static int JOYSTICK_PORT = 1;
    
    //Buttons
    public static int SPIN_IN = 0;
    public static int SHOOT = 1;
    
    //Axes
    public static int THROTTLE_AXIS = 4; //For adjusting aim
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
