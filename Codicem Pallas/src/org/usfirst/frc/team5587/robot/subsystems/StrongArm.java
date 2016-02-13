package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StrongArm extends Subsystem
{
	private static final double AIM_POWER = 1;
	
	private int target = 0; //A value that will be adjusted at need
    private Jaguar motor;
    private Encoder encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm()
	{
		motor = new Jaguar( RobotMap.AIMING_MOTOR );
		encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B );
	}

	public void move( boolean d )
	{
		if( d )
			motor.set( AIM_POWER );
		else
			motor.set( -AIM_POWER);
	}
	
	public void stop()
	{
		motor.set(0);
	}
	
	public void setTarget( int t )
	{
		target = t;
	}
	
	public int getPos()
	{
		return encoder.get();
	}
	
	public int diffToTarget()
	{
		return getPos() - target;
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}