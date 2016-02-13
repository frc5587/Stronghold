package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.BoulderLoader;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Fire extends Command
{

	private BoulderLoader loader;
	private static final int LOADING_ANGLE = 45;
    public Fire()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.loader );
    	loader = Robot.loader;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	loader.setAngle( LOADING_ANGLE );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return loader.getAngle() == LOADING_ANGLE;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	loader.setAngle( 0 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}