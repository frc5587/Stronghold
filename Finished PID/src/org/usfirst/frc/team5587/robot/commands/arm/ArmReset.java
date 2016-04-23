package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Resets the encoder of the Strong Arm to zero and also sets the Arm's
 * setpoint to zero. To be used in manual mode when resetting the robot
 * to start in PID mode.
 */
public class ArmReset extends Command {

    public ArmReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.arm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.arm.reset();
    	Robot.arm.setSetpoint( 0 );
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
