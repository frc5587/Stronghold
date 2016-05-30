package org.usfirst.frc.team5587.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//PWM Ports
	public static int LEFT_FRONT_MOTOR = 0; //Left front motor on the drive train
	public static int LEFT_REAR_MOTOR = 1; //Left rear motor on the drive train
	public static int RIGHT_FRONT_MOTOR = 2; //Right front motor on the drive train
	public static int RIGHT_REAR_MOTOR = 3; //Right rear motor on the drive train
	public static int LOADING_SERVO = 6; //Servo that pushes boulders into launch
	public static int STRONG_ARM = 7; //Motor that moves the arm up and down
	public static int LEFT_SHOOTER_WHEEL = 8; //Motor for the left shooting wheel
	public static int RIGHT_SHOOTER_WHEEL = 9; //Motor for the right shooting wheel
	
	//Digital IO Ports
	public static int ENCODER_A = 0; //Channel A of the encoder built into LIFT_MOTOR
	public static int ENCODER_B = 1; //Channel B of the encoder built into LIFT_MOTOR
	public static int TOP_LIMIT = 2; //Limit switch that prevents the arm from wrecking the interior of the robot
	
	//Joystick
	public static int DRIVER = 0;
	
	//Buttons
	public static int FIRE = 1; //Actuates the servo, pushing a boulder into the wheels
	public static int DOWN = 2; //When TeleOp is in manual mode, moves the arm down
	public static int UP = 3; //When TeleOp is in PID mode, moves the arm up
	public static int PRIME = 4; //Spins the wheels outward to fire a boulder
	public static int SWEEP_IN = 5; //Spins the wheels inward to collect a boulder

}