package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BlindingLight extends Subsystem {
    
	private Relay relay;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public BlindingLight()
	{
		relay = new Relay( RobotMap.LIGHT );
		relay.setDirection( Relay.Direction.kForward );
	}
	
	public void blind()
	{
			relay.set( Relay.Value.kForward );
	}
	
	public void sleep()
	{
		relay.set( Relay.Value.kOff );
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

