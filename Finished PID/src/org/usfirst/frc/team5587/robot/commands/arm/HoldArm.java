package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Stops moving the arm. To be used in Manual Mode
 */
public class HoldArm extends Command {

	private StrongArm arm;
	
    public HoldArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	arm = Robot.arm;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	arm.disable(); //Make sure the arm's PID controller is not currently running
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	arm.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}
