package org.usfirst.frc.team5587.robot.commands.aimbot;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IncrementalAim extends Command {
	
	private int increment;
	private StrongArm arm;
	
    public IncrementalAim( int i )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	arm = Robot.arm;
    	increment = i;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	if( !AimBot.withinY() )
    	{
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return arm.atTarget();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
