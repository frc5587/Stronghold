package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StrongArm extends Subsystem
{
	private static final double AIM_POWER = 1;
	private static final int SCALE_FACTOR = 100,
							 MARGIN = 10;
	private static final boolean REVERSE = false;
	
	private int target = 0; //A value that will be adjusted at need
    private VictorSP motor;
    private Encoder encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm()
	{
		motor = new VictorSP( RobotMap.AIMING_MOTOR );
		encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B, REVERSE );
	}

	public void move( boolean d )
	{
		if( d )
			motor.set( AIM_POWER );
		else
			motor.set( -AIM_POWER );
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
	
	public boolean atTarget()
	{
		return (getPos() <= (target + MARGIN) && getPos() >= (target - MARGIN));
	}

	public int scale ( double in )
	{
		double scaled = (in + 1) / 2;
		return (int)( scaled * SCALE_FACTOR );	
	}
	
	public void add( int t )
	{
		setTarget( getPos() + t );
	}
	
	public void subtract( int t )
	{
		setTarget( getPos() - t );
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}