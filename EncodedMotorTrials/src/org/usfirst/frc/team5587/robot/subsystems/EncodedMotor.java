
package org.usfirst.frc.team5587.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncodedMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon motor;
	private Encoder encoder;
	
	public EncodedMotor( int motorChannel, int aChannel, int bChannel )
	{
		motor = new Talon( motorChannel );
		encoder = new Encoder( aChannel, bChannel );
		encoder.setDistancePerPulse( 360.0 / 500 );
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
	
	public void move( double p )
	{
		motor.set( p );
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

