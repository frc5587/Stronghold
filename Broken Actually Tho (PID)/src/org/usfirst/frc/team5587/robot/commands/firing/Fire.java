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
	private static final int LOADING_ANGLE = 80;
	private long startTime, endTime;
	private double elapsedTime, targetTime;
    public Fire()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.loader );
    	loader = Robot.loader;
    	targetTime = 1.0;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	loader.set(LOADING_ANGLE);
    	startTime = System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	endTime = System.currentTimeMillis();
    	elapsedTime = (endTime - startTime)/1000.0;
    	
    	return (elapsedTime >= targetTime - .05) &&( elapsedTime <= targetTime +.05 );
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	
    	loader.set( 170 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}