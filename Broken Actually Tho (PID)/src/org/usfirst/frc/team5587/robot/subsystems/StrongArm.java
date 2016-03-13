package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StrongArm extends PIDSubsystem
{
	private static final double power = -.8;
	
    private VictorSP motor;
    private Encoder encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm(){
		super( .05, 0.0, 0.0 );
		motor = new VictorSP( RobotMap.AIMING_MOTOR );
		encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B );
		encoder.setDistancePerPulse( (360.0 / 500) * (16.0 / 50) );
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
		return ( Math.abs( encoder.getDistance() % 360 ) );
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

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		motor.set( output );
	}
}