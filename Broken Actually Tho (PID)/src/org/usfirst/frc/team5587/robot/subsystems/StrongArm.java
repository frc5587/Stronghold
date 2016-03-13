package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StrongArm extends PIDSubsystem
{
	private static final double power = -.8;
	
    private static final VictorSP MOTOR = new VictorSP( RobotMap.AIMING_MOTOR );
    private static final Encoder ENCODER = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B );
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm(){
		super( "StrongArm", .05, 0.0, 0.0 );
		ENCODER.setDistancePerPulse( (360.0 / 500) * (16.0 / 50) );
		ENCODER.setReverseDirection( true );
		ENCODER.setPIDSourceType( PIDSourceType.kDisplacement );
		setAbsoluteTolerance( 5 );
		getPIDController().setContinuous( false );
	}

	public int getRaw()
	{
		return ENCODER.getRaw();
	}

	public int get()
	{
		return ENCODER.get();
	}

	public double getAngle()
	{
		return ( ENCODER.getDistance() % 360 );
	}

	public void reset()
	{
		ENCODER.reset();
	}

	public void move( boolean d )
	{
		if( d )
			MOTOR.set( power );
		else
			MOTOR.set( -power );
	}

	public void stop()
	{
		MOTOR.set(0);
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
		MOTOR.set( output );
	}
}