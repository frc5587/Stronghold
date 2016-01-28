package org.usfirst.frc.team5587.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FiringMechanism extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final double INTAKE_POWER = -.5,
							   LAUNCH_POWER = 1;
	private RobotDrive wheels;

	/*
	 * Create a class constructor for FiringMechanism, no parameters
	 * 1. Declare wheels as a new RobotDrive with the appropriate variables for the left and right wheels as parameters
	 * 2. Invert the right wheel
	 */
	
	
	
	/*
	 *  Create a method called 'spin' that accepts a boolean as a parameter
	 *  1. Create a local double called 'power'
	 *  2. If the boolean is true, set 'power' to equal 'LAUNCH_POWER'
	 *  3. Else, set 'power' to equal 'INTAKE_POWER'
	 *  4. Drive wheels, inputting 'power' and '0' as the parameters
	 */
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

