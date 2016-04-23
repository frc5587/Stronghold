package org.usfirst.frc.team5587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives Pallas based on input power and curve, over a given time period (needs to be tested)
 */
public class WaitTime extends Command
{

	private double targetTime, //Desired time to wait
				   elapsedTime; //Time since beginning
	private long startTime, //Time command initializes
				 endTime; //Time value refreshed each time isFinished is called
	
	/**
	 * @param t The time (in seconds) to wait
	 */
    public WaitTime( double t )
    {
    	targetTime = t;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize()
    {
    	startTime = System.currentTimeMillis(); //Mark the time at which the command starts
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished()
    {
    	endTime = System.currentTimeMillis(); //Mark the current time
    	elapsedTime = (endTime - startTime)/1000.0; //Calculate the passage of time
    	
    	//Check to see if elapsedTime has surpassed targetTime
    	return (elapsedTime >= targetTime );
    }

    // Called once after isFinished returns true
    @Override
	protected void end()
    {
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted()
    {
    	
    }
}