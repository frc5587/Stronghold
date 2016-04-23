package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.Hooves;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Canter is the basic command for joystick control of the robot
 */
public class Canter extends Command 
{
	
	private Joystick stick;
	private Hooves hooves;
	
	/**
	 * @param s The joystick from which input is to be read.
	 */
    public Canter( Joystick s )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.hooves );
    	hooves = Robot.hooves;
    	stick = s;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute()
    {
    	hooves.canter( stick );
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished()
    {
        return false;
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