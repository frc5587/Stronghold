package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimeLift extends Command {

	private StrongArm sinister;
	private boolean direction;
	private double targetTime, elapsedTime;
	private long startTime, endTime;
    public TimeLift( boolean d, double t ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);'
    	requires(Robot.arm);
    	sinister = Robot.arm;
    	targetTime = t;
    	direction = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	sinister.move( direction );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	endTime = System.currentTimeMillis();
    	elapsedTime = (endTime - startTime)/1000.0;
    	
    	return (elapsedTime >= targetTime - .05) &&( elapsedTime <= targetTime +.05 );
    }

    // Called once after isFinished returns true
    protected void end() {
    	sinister.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
