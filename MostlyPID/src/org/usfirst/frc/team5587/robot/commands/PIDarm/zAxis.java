package org.usfirst.frc.team5587.robot.commands.PIDarm;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class zAxis extends Command {
	private Joystick joystick1;
	private static final double ABSOLUTE_BOTTOM = 230;
	
    public zAxis(Joystick j) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	joystick1 = j;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double setPoint = ( joystick1.getZ() + 1 )/ 2 * ABSOLUTE_BOTTOM;
    	if( !Robot.arm.isTop() || setPoint > 20 )
    		Robot.arm.setSetpoint( setPoint );
        SmartDashboard.putNumber("Joystick Z", joystick1.getZ());
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
