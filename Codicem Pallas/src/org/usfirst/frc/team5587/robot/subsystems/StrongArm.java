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
	
    private VictorSP motor;
    private Encoder encoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm(){
		motor = new VictorSP( RobotMap.AIMING_MOTOR );
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
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}