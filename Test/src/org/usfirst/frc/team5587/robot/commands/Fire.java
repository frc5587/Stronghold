package org.usfirst.frc.team5587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Fire extends Command {

	private static final int LAUNCH_ANGLE = 45;
	
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//Tell the command that it requires the Robo.java instance of FiringArm
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * Set the firing arm's angle to LAUNCH_ANGLE
     */
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute(
    /*
     * Modify the command so that it returns true only when the firing arm has reached the launch angle
     */
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
