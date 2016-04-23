package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.Hooves;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives Pallas based on input power and curve, over a given time period (needs to be tested)
 */
public class Trot extends Command
{

	private double power, //Power for the motors
				   curve, //Curve of the motion
				   targetTime, //The duration of the motion
				   elapsedTime; //A double representation of the time since beginning the command
	private long startTime, //The timestamp at the time the command initializes
				 endTime; //The timestamp everytime the isFinished method is run
	
	private Hooves hooves;
	
	/**
	 * Basic autonomous driving that moves the robot according to the power, curve,
	 * and time desired.
	 * 
	 * @param p The power of the motors
	 * @param c The curve of the motion
	 * @param t The time (in seconds) to drive
	 */
    public Trot( double p, double c, double t )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.hooves );
    	hooves = Robot.hooves;
    	power = p;
    	targetTime = t;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	hooves.trot( power, curve ); //GO
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	endTime = System.currentTimeMillis(); //Time at which the check is being made
    	elapsedTime = (endTime - startTime)/1000.0; //Total time the command has been running
    	
    	//Check if elapsedTime has surpassed the target time
    	return ( elapsedTime >= targetTime );
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	hooves.stop(); //STOP
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}