package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.SpinningWheelsOfDeath;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Spins the Spinning Wheels of Death for a defined time period
 */
public class TimeSpin extends Command {

	private double targetTime, //Desired time to spin
	   			   elapsedTime; //Time since beginning
	private long startTime, //Time command initializes
	 			 endTime; //Time value refreshed each time isFinished is called
	private boolean direction;
	private SpinningWheelsOfDeath wheels;
	
	/**
	 * @param d The direction of spinning
	 * @param t The time to spin
	 */
    public TimeSpin( boolean d, double t )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.firingWheels );
    	direction = d;
    	targetTime = t;
    	wheels = Robot.firingWheels;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize()
    {
    	startTime = System.currentTimeMillis();
    	wheels.spin( direction );
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
    	wheels.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted()
    {
    	
    }
}
