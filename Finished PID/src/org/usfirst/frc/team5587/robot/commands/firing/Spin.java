package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.SpinningWheelsOfDeath;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Spins the Spinning Wheels of Death either inwards (intake) or outwards (launch)
 * as desired.
 */
public class Spin extends Command
{
	
	private SpinningWheelsOfDeath wheels;
	private boolean direction;
	
	/**
	 * @param d The direction to spin: true = out, false = in.
	 */
    public Spin( boolean d )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.firingWheels );
    	direction = d;
    	wheels = Robot.firingWheels;
    	this.setInterruptible( false );
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	wheels.spin( direction );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	wheels.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}