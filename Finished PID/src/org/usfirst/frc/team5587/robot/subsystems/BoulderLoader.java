package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The servo mounted on the Strong Arm that pushes boulders into the
 * Spinning Wheels of Death to launch them.
 */
public class BoulderLoader extends Subsystem
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Servo loader;
	public BoulderLoader()
	{
		loader = new Servo( RobotMap.LOADING_SERVO );
		loader.setAngle(178);
	}
	
	public void set( double angle )
	{
		loader.setAngle( angle );
	}
	
    @Override
	public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

