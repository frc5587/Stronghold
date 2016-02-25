package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.EncodedMotor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ThrottleMove extends Command {

	
	private Joystick stick;
	private EncodedMotor motor;
	private double target;
    public ThrottleMove( int port ) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.motor);
        motor = Robot.motor;
        stick = new Joystick( port );
    }
    
    public ThrottleMove( Joystick s )
    {
    	requires( Robot.motor );
    	stick = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	target = ( stick.getRawAxis(3) * 90.0 / 7 );
    	
    	if( motor.getAngle() > target + 5 )
    		motor.move( .25 );
    	else if( motor.getAngle() < target - 5 )
    		motor.move( -.25 );
    	else
    		motor.move( 0 );
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
