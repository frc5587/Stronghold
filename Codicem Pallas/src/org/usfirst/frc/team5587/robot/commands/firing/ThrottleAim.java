package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ThrottleAim extends Command
{
	private Joystick stick;
	private StrongArm arm;
    public ThrottleAim( Joystick j )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    	arm = Robot.arm;
    	stick = j;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	int angle = arm.scale(stick.getThrottle());
    	
    	arm.setTarget(angle);
    	
    	if( arm.diffToTarget() > 0 )
    		arm.move( true );
    	else if( arm.diffToTarget() < 0 )
    		arm.move( false );
    	else
    		arm.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}
