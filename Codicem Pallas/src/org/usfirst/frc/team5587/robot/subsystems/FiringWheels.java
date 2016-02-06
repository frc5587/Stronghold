package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import org.usfirst.frc.team5587.classes.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The two wheels on the front of the launch mechanism that spin in
 * or out depending on our needs
 */
public class FiringWheels extends Subsystem
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive launchWheels;
	private static final double LAUNCH_POWER = 1.0, //The power necessary to launch a ball at the desired speed
							   INTAKE_POWER = .25; //The power necessary to bring a ball into the mechanism
	
	public FiringWheels()
	{
		launchWheels = new RobotDrive( RobotMap.LEFT_SHOOTER_WHEEL, RobotMap.RIGHT_SHOOTER_WHEEL );
		launchWheels.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}
	
	public void spin( boolean d )
	{
		if( d )
			launchWheels.drive( LAUNCH_POWER, 0 );
		else
			launchWheels.drive( INTAKE_POWER, 0 );
	}

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

