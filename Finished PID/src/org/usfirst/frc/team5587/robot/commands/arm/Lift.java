package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends Command {
	
	private StrongArm arm;
	private boolean direction;
	
	/**
	 * Moves the arm in the desired direction
	 * @param d The direction (true = up, false = down) to move the arm
	 */
    public Lift( boolean d ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	arm = Robot.arm;
    	direction = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	arm.disable(); //Make sure the arm's PID controller is not running
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.move( direction );
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
