package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AbsoluteLift extends Command {

	private double position;
    public AbsoluteLift( double pos ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.arm.enable();
    	Robot.arm.setSetpoint(position);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.onTarget();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.arm.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
