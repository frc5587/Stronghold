package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.BoulderLoader;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Load extends Command
{

	private BoulderLoader loader;
	private static final int LOADING_ANGLE = 45;
    public Load()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.loader );
    	loader = Robot.loader;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	loader.set(LOADING_ANGLE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	Timer.delay(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	loader.set( 0 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}