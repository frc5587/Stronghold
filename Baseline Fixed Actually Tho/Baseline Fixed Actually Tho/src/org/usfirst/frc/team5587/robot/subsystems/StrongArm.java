package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StrongArm extends Subsystem
{
	private static final double power = -.8;
	
    private VictorSP motor;
    private Encoder encoder;
    private DigitalInput topLimit, bottomLimit;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public StrongArm(){
		motor = new VictorSP( RobotMap.AIMING_MOTOR );
		encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B );
		encoder.setDistancePerPulse( (360.0 / 500) * (16.0 / 50) );
		topLimit = new DigitalInput( RobotMap.TOP_LIMIT );
		bottomLimit = new DigitalInput( RobotMap.BOTTOM_LIMIT );
}
public boolean atTop()
{
	if(topLimit.get()){
		return false;
	}
	else{
		return true;
	}
}
public boolean atBottom()
{
	if(bottomLimit.get()){
		return false;
	}
	else{
		return true;
	}
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
	{
		if(!atTop()){
			motor.set( power );
		}
		else{
			stop();
		}
	}
	else
	{
		if(!atBottom()){
			motor.set( -power );
		}
		else{
			stop();
		}
	}
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
}