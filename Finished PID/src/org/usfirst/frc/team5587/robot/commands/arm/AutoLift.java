package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLift extends Command {

	private StrongArm sinister;
	private double setPoint;
	
	/**
	 * Moves the arm to a specified setpoint
	 * 
	 * @param s The setpoint to move the arm
	 */
    public AutoLift( double s ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);'
    	requires( Robot.arm );
    	sinister = Robot.arm;
    	setPoint = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sinister.enable();
    	sinister.setSetpoint( setPoint );
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return sinister.onTarget(); //Stop the command when the arm says it is on target
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
