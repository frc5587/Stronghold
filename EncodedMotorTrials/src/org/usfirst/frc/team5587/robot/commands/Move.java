
package org.usfirst.frc.team5587.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.EncodedMotor;

/**
 *
 */
public class Move extends Command {

	private Joystick stick;
	private EncodedMotor motor;
    public Move( int port ) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.motor);
        motor = Robot.motor;
        stick = new Joystick( port );
    }
    
    public Move( Joystick s )
    {
    	requires( Robot.motor );
    	stick = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	motor.move( stick.getY() );
    	
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
