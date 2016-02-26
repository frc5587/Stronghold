package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.EncodedMotor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GivenMove extends Command {

	private EncodedMotor motor;
	private double given;
	
    public GivenMove( double g ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.motor );
    	motor = Robot.motor;
    	given = g;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if( motor.getAngle() > given + 5 )
    		motor.move( .25 );
    	else if( motor.getAngle() < given - 5 )
    		motor.move( -.25 );
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString( "DB/String 2", "" + motor.getAngle() );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (motor.getAngle() <= given + 5) && ( motor.getAngle() >= given - 5);
    }

    // Called once after isFinished returns true
    protected void end() {
    	motor.move( 0 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
