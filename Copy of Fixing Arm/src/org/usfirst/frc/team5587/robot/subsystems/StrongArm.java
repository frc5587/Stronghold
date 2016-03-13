package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class StrongArm extends PIDSubsystem
{
	private static final double power = -.6;
	
    private static final VictorSP motor = new VictorSP( RobotMap.AIMING_MOTOR );
    private static final Encoder encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B );

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm()
	{
		super( "Strong Arm", 0.05, 0.0, 0.0 );
		encoder.setDistancePerPulse( (360.0 / 497) * (16.0 / 50) );
		encoder.setReverseDirection( true );
		enable();
		setAbsoluteTolerance( 5 );
		setOutputRange( -.4, .4 );
		setInputRange( -240.0, 240.0 );
	}

	public int getRaw()
	{
		return encoder.getRaw();
	}
	
	public int get()
	{
		return encoder.get();
	}
	
	public double getAngle()
	{
		return ( encoder.getDistance() % 360 );
	}
	
	public void reset()
	{
		encoder.reset();
	}
	
	public void move( boolean d )
	{
		if( d )
			motor.set( power );
		else
			motor.set( -power );
	}
	
	public void stop()
	{
		motor.set(0);
	}
	
	public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	protected double returnPIDInput()
	{
		return getAngle();
	}
	
	protected void usePIDOutput( double output )
	{
		motor.pidWrite(output);
	}
}