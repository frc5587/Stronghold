package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	private double power;
	private double curve;
	
	/*
	 * Modify constructor to accept the following parameters and pass them on to the appropriate variables
	 * @param p A double that represents the power of the motors
	 * @param c A double that determines how the robot will curve
	 */
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//Set the subsystem dependency to your instance of DriveTrain in Robot.java
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /*
     * Runs the drive method of Robot.train using local variables
     */
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
