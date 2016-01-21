package org.usfirst.frc.team5587.robot.commands.firing;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.FiringWheels;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinDown extends Command implements Spin {

	private double power;
	
    public SpinDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.firingWheels );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	power = FiringWheels.LAUNCH_POWER;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.firingWheels.spin(power);
    	power -= STEP;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return power == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
