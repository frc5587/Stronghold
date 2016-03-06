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
	private static final double power = .4;
	private Joystick stick;
	private StrongArm arm;
	private double target;
    public ThrottleAim( Joystick j )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.arm);
    	//arm = Robot.arm;
    	stick = j;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	double startValue = arm.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	target = ( (stick.getRawAxis(3) - 1) * 55.0 );
    	
    	if( arm.getAngle() > startValue-target + 1 )
    		arm.move( -power );
    	else if( arm.getAngle() < startValue-target - 1 )
    		arm.move( power );
    	else
    		arm.move( 0 );
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
